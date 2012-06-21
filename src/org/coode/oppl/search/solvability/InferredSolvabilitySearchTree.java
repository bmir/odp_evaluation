package org.coode.oppl.search.solvability;

import java.util.Arrays;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

public final class InferredSolvabilitySearchTree extends
		AbstractSolvabilityOPPLOWLAxiomSearchTree {
	/**
	 * @param constraintSystem
	 */
	public InferredSolvabilitySearchTree(ConstraintSystem constraintSystem,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		super(constraintSystem, runtimeExceptionHandler);
		OWLReasoner reasoner = constraintSystem.getReasoner();
		if (reasoner == null) {
			throw new IllegalArgumentException(
					"The reasoner cannot be null in the input constraint system");
		}
	}

	@Override
	protected boolean goalReachedUnsolvabelNode(
			UnsolvableSearchNode unsolvableSearchNode) {
		VariableExtractor variableExtractor = new VariableExtractor(
				this.getConstraintSystem(), true);
		Set<Variable<?>> extractVariables = variableExtractor
				.extractVariables(unsolvableSearchNode.getAxiom());
		return extractVariables.isEmpty() ? this.getConstraintSystem()
				.getReasoner().isEntailed(unsolvableSearchNode.getAxiom())
				: false;
	}

	@Override
	protected AxiomSolvability getAxiomSolvability() {
		QuerySolver querySolver = new InferredModelQuerySolver(this
				.getConstraintSystem().getReasoner());
		return new MultipleAxiomSolvability(Arrays.asList(
				new OWLClassSubClassOfAxiomSolvability(this
						.getConstraintSystem(), querySolver),
				new NoResultsAxiomSolvability(this.getConstraintSystem(),
						querySolver),
				new OWLObjectPropertyFillersAxiomSolvability(this
						.getConstraintSystem(), querySolver)));
	}
}
