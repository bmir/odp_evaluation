/**
 * 
 */
package org.coode.oppl.search.solvability;

import java.util.Collection;
import java.util.Iterator;

import org.coode.oppl.bindingtree.BindingNode;
import org.semanticweb.owlapi.model.OWLAxiom;

/**
 * Applies a set of solvability strategies, until either a node is solved or the
 * strategies are exhausted.
 * 
 * @author Luigi Iannone
 * 
 */
public class MultipleAxiomSolvability implements AxiomSolvability {
//	private final Set<AxiomSolvability> delegates = new HashSet<AxiomSolvability>();
	private final Collection<? extends AxiomSolvability> delegates;

	public MultipleAxiomSolvability(
			Collection<? extends AxiomSolvability> delegates) {
		if (delegates == null) {
			throw new NullPointerException(
					"The delegate collection cannot be null");
		}
		if (delegates.isEmpty()) {
			throw new IllegalArgumentException(
					"The delegate collection canont be empty");
		}
		this.delegates=delegates;
	}

	/**
	 * @see org.coode.oppl.search.solvability.AxiomSolvability#getSolvabilitySearchNode
	 *      (org.semanticweb.owlapi.model.OWLAxiom,
	 *      org.coode.oppl.bindingtree.BindingNode)
	 */
	public SolvabilitySearchNode getSolvabilitySearchNode(OWLAxiom owlAxiom,
			BindingNode bindingNode) {
		boolean solved = false;
		Iterator<? extends AxiomSolvability> iterator = this.getDelegates().iterator();
		SolvabilitySearchNode toReturn = null;
		while (!solved && iterator.hasNext()) {
			AxiomSolvability axiomSolvability = iterator.next();
			toReturn = axiomSolvability.getSolvabilitySearchNode(owlAxiom,
					bindingNode);
			solved = toReturn
					.accept(new SolvabilitySearchNodeVisitorEx<Boolean>() {
						public Boolean visitSolvableSearchNode(
								SolvableSearchNode solvableSearchNode) {
							return true;
						}

						public Boolean visitSolvedSearchNode(
								SolvedSearchNode solvedSearchNode) {
							return true;
						}

						public Boolean visitNoSolutionSolvableSearchNode(
								NoSolutionSolvableSearchNode noSolutionSolvableSearchNode) {
							return true;
						}

						public Boolean visitUnsolvableSearchNode(
								UnsolvableSearchNode unsolvableSearchNode) {
							return false;
						}
					});
		}
		return toReturn;
	}

	/**
	 * @return the delegates
	 */
	public Collection<? extends AxiomSolvability> getDelegates() {
		return this.delegates;
	}
}
