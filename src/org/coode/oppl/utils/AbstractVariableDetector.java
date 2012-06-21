package org.coode.oppl.utils;

import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLBuiltInAtom;
import org.semanticweb.owlapi.model.SWRLClassAtom;
import org.semanticweb.owlapi.model.SWRLDataPropertyAtom;
import org.semanticweb.owlapi.model.SWRLDataRangeAtom;
import org.semanticweb.owlapi.model.SWRLDifferentIndividualsAtom;
import org.semanticweb.owlapi.model.SWRLIndividualArgument;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLSameIndividualAtom;
import org.semanticweb.owlapi.model.SWRLVariable;

public abstract class AbstractVariableDetector implements OWLObjectVisitorEx<Boolean> {
	protected ConstraintSystem constraintSystem;

	/**
	 * @param constraintSystem
	 */
	protected AbstractVariableDetector(ConstraintSystem constraintSystem) {
		this.constraintSystem = constraintSystem;
	}

	public Boolean visit(OWLObjectIntersectionOf desc) {
		boolean found = false;
		Iterator<OWLClassExpression> it = desc.getOperands().iterator();
		OWLClassExpression operand;
		while (!found && it.hasNext()) {
			operand = it.next();
			found = operand.accept(this);
		}
		return found;
	}

	public Boolean visit(OWLObjectUnionOf desc) {
		boolean found = false;
		Iterator<OWLClassExpression> it = desc.getOperands().iterator();
		OWLClassExpression operand;
		while (!found && it.hasNext()) {
			operand = it.next();
			found = operand.accept(this);
		}
		return found;
	}

	public Boolean visit(OWLObjectComplementOf desc) {
		return desc.getOperand().accept(this);
	}

	public Boolean visit(OWLObjectSomeValuesFrom desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
				|| desc.getFiller().accept(this);
	}

	public Boolean visit(OWLObjectAllValuesFrom desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
				|| desc.getFiller().accept(this);
	}

	public Boolean visit(OWLObjectHasValue desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
				|| desc.getValue().accept(this);
	}

	public Boolean visit(OWLAnonymousIndividual individual) {
		return false;
	}

	public Boolean visit(OWLObjectMinCardinality desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
				|| (desc.getFiller() == null ? false : desc.getFiller().accept(this));
	}

	public Boolean visit(OWLObjectExactCardinality desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
				|| (desc.getFiller() == null ? false : desc.getFiller().accept(this));
	}

	public Boolean visit(OWLObjectMaxCardinality desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty())
				|| (desc.getFiller() == null ? false : desc.getFiller().accept(this));
	}

	public Boolean visit(OWLObjectHasSelf desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLObjectProperty());
	}

	public Boolean visit(OWLObjectOneOf desc) {
		boolean found = false;
		Iterator<OWLIndividual> it = desc.getIndividuals().iterator();
		OWLIndividual individual;
		while (!found && it.hasNext()) {
			individual = it.next();
			found = individual.accept(this);
		}
		return found;
	}

	public Boolean visit(OWLDataSomeValuesFrom desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLDataProperty());
	}

	public Boolean visit(OWLDataAllValuesFrom desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLDataProperty());
	}

	public Boolean visit(OWLDataHasValue desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLDataProperty());
	}

	public Boolean visit(OWLDataMinCardinality desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLDataProperty());
	}

	public Boolean visit(OWLDataExactCardinality desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLDataProperty());
	}

	public Boolean visit(OWLDataMaxCardinality desc) {
		return this.constraintSystem.isVariable(desc.getProperty().asOWLDataProperty());
	}

	public Boolean visit(OWLSubClassOfAxiom axiom) {
		return axiom.getSubClass().accept(this) || axiom.getSuperClass().accept(this);
	}

	public Boolean visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		return axiom.getProperty().accept(this) || axiom.getSubject().accept(this)
				|| axiom.getObject().accept(this);
	}

	public Boolean visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		return axiom.getProperty().accept(this);
	}

	public Boolean visit(OWLReflexiveObjectPropertyAxiom axiom) {
		return axiom.getProperty().accept(this);
	}

	public Boolean visit(OWLDisjointClassesAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		Iterator<OWLClassExpression> iterator = descriptions.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLDataPropertyDomainAxiom axiom) {
		return axiom.getProperty().accept(this) || axiom.getDomain().accept(this);
	}

	public Boolean visit(OWLObjectPropertyDomainAxiom axiom) {
		return axiom.getProperty().accept(this) || axiom.getDomain().accept(this);
	}

	public Boolean visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> descriptions = axiom.getProperties();
		Iterator<OWLObjectPropertyExpression> iterator = descriptions.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		return axiom.getProperty().accept(this) || axiom.getSubject().accept(this)
				|| axiom.getObject().accept(this);
	}

	public Boolean visit(OWLDifferentIndividualsAxiom axiom) {
		Set<OWLIndividual> descriptions = axiom.getIndividuals();
		Iterator<OWLIndividual> iterator = descriptions.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLDisjointDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> descriptions = axiom.getProperties();
		Iterator<OWLDataPropertyExpression> iterator = descriptions.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLDisjointObjectPropertiesAxiom axiom) {
		Set<OWLObjectPropertyExpression> descriptions = axiom.getProperties();
		Iterator<OWLObjectPropertyExpression> iterator = descriptions.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLObjectPropertyRangeAxiom axiom) {
		return axiom.getProperty().accept(this) || axiom.getRange().accept(this);
	}

	public Boolean visit(OWLObjectPropertyAssertionAxiom axiom) {
		return axiom.getProperty().accept(this) || axiom.getSubject().accept(this)
				|| axiom.getObject().accept(this);
	}

	public Boolean visit(OWLFunctionalObjectPropertyAxiom axiom) {
		return axiom.getProperty().accept(this);
	}

	public Boolean visit(OWLSubObjectPropertyOfAxiom axiom) {
		return axiom.getSubProperty().accept(this) || axiom.getSuperProperty().accept(this);
	}

	public Boolean visit(OWLDisjointUnionAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		Iterator<OWLClassExpression> iterator = descriptions.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLDeclarationAxiom axiom) {
		return Boolean.FALSE;
	}

	public Boolean visit(OWLSymmetricObjectPropertyAxiom axiom) {
		return axiom.getProperty().accept(this);
	}

	public Boolean visit(OWLDataPropertyRangeAxiom axiom) {
		return axiom.getProperty().accept(this) || axiom.getRange().accept(this);
	}

	public Boolean visit(OWLFunctionalDataPropertyAxiom axiom) {
		return axiom.getProperty().accept(this);
	}

	public Boolean visit(OWLEquivalentDataPropertiesAxiom axiom) {
		Set<OWLDataPropertyExpression> descriptions = axiom.getProperties();
		Iterator<OWLDataPropertyExpression> iterator = descriptions.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLClassAssertionAxiom axiom) {
		return axiom.getClassExpression().accept(this) || axiom.getIndividual().accept(this);
	}

	public Boolean visit(OWLEquivalentClassesAxiom axiom) {
		Set<OWLClassExpression> descriptions = axiom.getClassExpressions();
		Iterator<OWLClassExpression> iterator = descriptions.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLDataPropertyAssertionAxiom axiom) {
		return axiom.getProperty().accept(this) || axiom.getSubject().accept(this)
				|| axiom.getObject().accept(this);
	}

	public Boolean visit(OWLTransitiveObjectPropertyAxiom axiom) {
		return axiom.getProperty().accept(this);
	}

	public Boolean visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		return axiom.getProperty().accept(this);
	}

	public Boolean visit(OWLSubDataPropertyOfAxiom axiom) {
		return axiom.getSubProperty().accept(this) || axiom.getSuperProperty().accept(this);
	}

	public Boolean visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		return axiom.getProperty().accept(this);
	}

	public Boolean visit(OWLSameIndividualAxiom axiom) {
		Iterator<OWLIndividual> iterator = axiom.getIndividuals().iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(OWLSubPropertyChainOfAxiom axiom) {
		Iterator<OWLObjectPropertyExpression> iterator = axiom.getPropertyChain().iterator();
		boolean found = false;
		while (found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found || axiom.getSuperProperty().accept(this);
	}

	public Boolean visit(OWLInverseObjectPropertiesAxiom axiom) {
		Iterator<OWLObjectPropertyExpression> iterator = axiom.getProperties().iterator();
		boolean found = false;
		while (found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return found;
	}

	public Boolean visit(SWRLRule rule) {
		return false;
	}

	public Boolean visit(OWLDatatype node) {
		return false;
	}

	public Boolean visit(OWLDataComplementOf node) {
		return false;
	}

	public Boolean visit(OWLDataOneOf node) {
		Iterator<OWLLiteral> iterator = node.getValues().iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			found = iterator.next().accept(this);
		}
		return false;
	}

	public Boolean visit(OWLObjectInverseOf property) {
		return property.getInverseProperty().accept(this);
	}

	public Boolean visit(OWLDatatypeRestriction node) {
		return false;
	}

	public Boolean visit(SWRLClassAtom node) {
		return false;
	}

	public Boolean visit(SWRLDataRangeAtom node) {
		return false;
	}

	public Boolean visit(SWRLObjectPropertyAtom node) {
		return false;
	}

	public Boolean visit(OWLOntology ontology) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom)
	 */
	public Boolean visit(OWLSubAnnotationPropertyOfAxiom axiom) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom)
	 */
	public Boolean visit(OWLAnnotationPropertyDomainAxiom axiom) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom)
	 */
	public Boolean visit(OWLAnnotationPropertyRangeAxiom axiom) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationObjectVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotation)
	 */
	public Boolean visit(OWLAnnotation node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAnnotationValueVisitorEx#visit(org.semanticweb.owlapi.model.IRI)
	 */
	public Boolean visit(IRI iri) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLEntityVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationProperty)
	 */
	public Boolean visit(OWLAnnotationProperty property) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLDataVisitorEx#visit(org.semanticweb.owlapi.model.OWLDataIntersectionOf)
	 */
	public Boolean visit(OWLDataIntersectionOf node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLDataVisitorEx#visit(org.semanticweb.owlapi.model.OWLDataUnionOf)
	 */
	public Boolean visit(OWLDataUnionOf node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLDataVisitorEx#visit(org.semanticweb.owlapi.model.OWLFacetRestriction)
	 */
	public Boolean visit(OWLFacetRestriction node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom)
	 */
	public Boolean visit(OWLAnnotationAssertionAxiom axiom) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLHasKeyAxiom)
	 */
	public Boolean visit(OWLHasKeyAxiom axiom) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.OWLAxiomVisitorEx#visit(org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom)
	 */
	public Boolean visit(OWLDatatypeDefinitionAxiom axiom) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLDataPropertyAtom)
	 */
	public Boolean visit(SWRLDataPropertyAtom node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLBuiltInAtom)
	 */
	public Boolean visit(SWRLBuiltInAtom node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLVariable)
	 */
	public Boolean visit(SWRLVariable node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLIndividualArgument)
	 */
	public Boolean visit(SWRLIndividualArgument node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLLiteralArgument)
	 */
	public Boolean visit(SWRLLiteralArgument node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLSameIndividualAtom)
	 */
	public Boolean visit(SWRLSameIndividualAtom node) {
		return false;
	}

	/**
	 * @see org.semanticweb.owlapi.model.SWRLObjectVisitorEx#visit(org.semanticweb.owlapi.model.SWRLDifferentIndividualsAtom)
	 */
	public Boolean visit(SWRLDifferentIndividualsAtom node) {
		return false;
	}
}
