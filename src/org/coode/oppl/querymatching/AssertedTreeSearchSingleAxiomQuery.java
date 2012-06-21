/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.oppl.querymatching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.search.OPPLAssertedSingleOWLAxiomSearchTree;
import org.coode.oppl.search.OPPLOWLAxiomSearchNode;
import org.coode.oppl.search.SearchTree;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.PositionBasedVariableComparator;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 */
public class AssertedTreeSearchSingleAxiomQuery extends AbstractAxiomQuery {
	private final Map<OWLAxiom, SearchTree<OPPLOWLAxiomSearchNode>> searchTrees = new HashMap<OWLAxiom, SearchTree<OPPLOWLAxiomSearchNode>>();
	private final ConstraintSystem constraintSystem;
	private final Set<OWLOntology> ontologies = new HashSet<OWLOntology>();
	private final Map<BindingNode, Set<OWLAxiom>> instantiations = new HashMap<BindingNode, Set<OWLAxiom>>();
	private final Map<OWLAxiom, Collection<? extends OWLObject>> cache = new HashMap<OWLAxiom, Collection<? extends OWLObject>>();

	public AssertedTreeSearchSingleAxiomQuery(Set<OWLOntology> ontologies,
			ConstraintSystem constraintSystem,
			RuntimeExceptionHandler runtimeExceptionHandler) {
		super(runtimeExceptionHandler);
		if (ontologies == null) {
			throw new NullPointerException(
					"The ontologies collection cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException(
					"The constraint system cannot be null");
		}
		this.constraintSystem = constraintSystem;
		this.ontologies.addAll(ontologies);
	}

	@Override
	protected Set<BindingNode> match(OWLAxiom axiom) {
		this.clearInstantions();
		List<List<OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
		VariableExtractor variableExtractor = new VariableExtractor(
				this.getConstraintSystem(), false);
		Set<Variable<?>> extractedVariables = variableExtractor
				.extractVariables(axiom);
		SortedSet<Variable<?>> sortedVariables = new TreeSet<Variable<?>>(
				new PositionBasedVariableComparator(axiom, this
						.getConstraintSystem().getOntologyManager()
						.getOWLDataFactory()));
		sortedVariables.addAll(extractedVariables);
		OPPLOWLAxiomSearchNode start = new OPPLOWLAxiomSearchNode(axiom,
				new BindingNode(new HashSet<Assignment>(), sortedVariables));
		solutions.addAll(this.doMatch(start));
		return new HashSet<BindingNode>(this.extractLeaves(solutions));
	}

	/**
	 * @param axiom
	 * @param start
	 */
	private List<List<OPPLOWLAxiomSearchNode>> doMatch(
			OPPLOWLAxiomSearchNode start) {
		List<List<OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
		for (OWLOntology ontology : this.getOntologies()) {
			for (OWLAxiom targetAxiom : this.filterAxioms(start.getAxiom(),
					ontology.getAxioms())) {
				if (start.getAxiom().getAxiomType()
						.equals(targetAxiom.getAxiomType())) {
					solutions.addAll(this.matchTargetAxiom(start, targetAxiom));
				}
			}
		}
		return solutions;
	}

	private Collection<? extends BindingNode> extractLeaves(
			List<List<OPPLOWLAxiomSearchNode>> solutions) {
		Set<BindingNode> toReturn = new HashSet<BindingNode>();
		for (List<OPPLOWLAxiomSearchNode> path : solutions) {
			OPPLOWLAxiomSearchNode searchLeaf = path.get(path.size() - 1);
			BindingNode leaf = searchLeaf.getBinding();
			toReturn.add(leaf);
		}
		return toReturn;
	}

	/**
	 * @param axiom
	 * @param targetAxiom
	 * @param start
	 */
	private List<List<OPPLOWLAxiomSearchNode>> matchTargetAxiom(
			OPPLOWLAxiomSearchNode start, OWLAxiom targetAxiom) {
		SearchTree<OPPLOWLAxiomSearchNode> searchTree = this
				.getSearchTree(targetAxiom);
		List<List<OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
		searchTree.exhaustiveSearchTree(start, solutions);
		return solutions;
	}

	/**
	 * @param targetAxiom
	 * @return
	 */
	private SearchTree<OPPLOWLAxiomSearchNode> getSearchTree(
			OWLAxiom targetAxiom) {
		SearchTree<OPPLOWLAxiomSearchNode> toReturn = this.searchTrees
				.get(targetAxiom);
		if (toReturn == null) {
			toReturn = new OPPLAssertedSingleOWLAxiomSearchTree(targetAxiom,
					this.getConstraintSystem(),
					this.getRuntimeExceptionHandler());
			this.searchTrees.put(targetAxiom, toReturn);
		}
		return toReturn;
	}

	private void clearInstantions() {
		this.instantiations.clear();
	}

	public Map<BindingNode, Set<OWLAxiom>> getInstantiations() {
		return new HashMap<BindingNode, Set<OWLAxiom>>(this.instantiations);
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	public Set<OWLOntology> getOntologies() {
		return new HashSet<OWLOntology>(this.ontologies);
	}

	private Collection<? extends OWLAxiom> filterAxioms(OWLAxiom toMatchAxiom,
			Collection<? extends OWLAxiom> axioms) {
		Set<OWLAxiom> toReturn = new HashSet<OWLAxiom>();
		VariableExtractor variableExtractor = new VariableExtractor(
				this.getConstraintSystem(), true);
		Set<Variable<?>> variables = variableExtractor
				.extractVariables(toMatchAxiom);
		Collection<? extends OWLObject> toMatchAllOWLObjects = this
				.extractOWLObjects(toMatchAxiom);
		for (OWLAxiom candidate : axioms) {
			// if (candidate.getAxiomType().equals(toMatchAxiom.getAxiomType()))
			// {
			Collection<? extends OWLObject> candidateAllOWLObjects = this
					.extractOWLObjects(candidate);
			if (candidate.getAxiomType().equals(toMatchAxiom.getAxiomType())
					&& toMatchAllOWLObjects.containsAll(candidateAllOWLObjects)) {
				toReturn.add(candidate);
			} else {
				Set<OWLObject> difference = new HashSet<OWLObject>(
						candidateAllOWLObjects);
				difference.removeAll(toMatchAllOWLObjects);
				Iterator<OWLObject> iterator = difference.iterator();
				boolean found = false;
				while (!found && iterator.hasNext()) {
					OWLObject leftOutOWLObject = iterator.next();
					Iterator<? extends Variable<?>> variableIterator = variables
							.iterator();
					boolean compatible = false;
					while (!compatible && variableIterator.hasNext()) {
						Variable<?> variable = variableIterator.next();
						compatible = variable.getType().isCompatibleWith(
								leftOutOWLObject);
					}
					found = !compatible;
				}
				if (!found) {
					toReturn.add(candidate);
				}
			}
		}
		return toReturn;
	}

	/**
	 * @param axiom
	 * @return
	 */
	private Collection<? extends OWLObject> extractOWLObjects(OWLAxiom axiom) {
		Collection<? extends OWLObject> toReturn = this.cache.get(axiom);
		if (toReturn == null) {
			toReturn = OWLObjectExtractor.getAllOWLPrimitives(axiom);
			this.cache.put(axiom, toReturn);
		}
		return toReturn;
	}
}
