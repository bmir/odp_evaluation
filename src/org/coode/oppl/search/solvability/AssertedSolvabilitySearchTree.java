/**
 * 
 */
package org.coode.oppl.search.solvability;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class AssertedSolvabilitySearchTree extends
		AbstractSolvabilityOPPLOWLAxiomSearchTree {
	private final OWLOntologyManager ontologyManager;

	/**
	 * @param constraintSystem
	 */
	public AssertedSolvabilitySearchTree(ConstraintSystem constraintSystem,
			OWLOntologyManager ontologyManager,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		super(constraintSystem, runtimeExceptionHandler);
		if (ontologyManager == null) {
			throw new NullPointerException(
					"The ontology manager cannot be null");
		}
		this.ontologyManager = ontologyManager;
	}

	@Override
	protected AxiomSolvability getAxiomSolvability() {
		AssertedModelQuerySolver querySolver = new AssertedModelQuerySolver(
				this.getOntologyManager());
		return new MultipleAxiomSolvability(Arrays.asList(
				new OWLClassSubClassOfAxiomSolvability(this
						.getConstraintSystem(), querySolver),
				new NoResultsAxiomSolvability(this.getConstraintSystem(),
						querySolver),
				new OWLObjectPropertyFillersAxiomSolvability(this
						.getConstraintSystem(), querySolver)));
	}

	/**
	 * @see org.coode.oppl.search.solvability.AbstractSolvabilityOPPLOWLAxiomSearchTree#goalReachedUnsolvabelNode(org.coode.oppl.search.solvability.UnsolvableSearchNode)
	 */
	@Override
	protected boolean goalReachedUnsolvabelNode(
			UnsolvableSearchNode unsolvableSearchNode) {
		VariableExtractor variableExtractor = new VariableExtractor(
				this.getConstraintSystem(), true);
		Set<Variable<?>> extractVariables = variableExtractor
				.extractVariables(unsolvableSearchNode.getAxiom());
		return extractVariables.isEmpty() ? this.findAxiom(unsolvableSearchNode
				.getAxiom()) : false;
	}

	private boolean findAxiom(OWLAxiom axiom) {
		boolean found = false;
		Iterator<OWLOntology> iterator = this.getConstraintSystem()
				.getOntologyManager().getOntologies().iterator();
		while (!found && iterator.hasNext()) {
			OWLOntology ontology = iterator.next();
			found = ontology.containsAxiom(axiom);
		}
		return found;
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}
}
