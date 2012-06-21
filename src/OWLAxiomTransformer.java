import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomVisitorEx;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLClassExpressionVisitorEx;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;

import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;


public class OWLAxiomTransformer implements OWLAxiomVisitorEx<Set<OWLAxiom>>,
		OWLClassExpressionVisitorEx<OWLClassExpression> {

	
	OWLDataFactory df = new OWLDataFactoryImpl() ;
	
	@Override
	public Set<OWLAxiom> visit(OWLSubClassOfAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		for(OWLClassExpression sup:axiom.getSuperClass().asConjunctSet()){
			for(OWLClassExpression sub: axiom.getSubClass().asDisjunctSet()){
				result.add(df.getOWLSubClassOfAxiom(sub.accept(this), sup.accept(this)));
			}
		}
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLReflexiveObjectPropertyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDisjointClassesAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		for(OWLSubClassOfAxiom s: axiom.asOWLSubClassOfAxioms()){
			result.addAll(s.accept(this));
		}
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDataPropertyDomainAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLObjectPropertyDomainAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDifferentIndividualsAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDisjointDataPropertiesAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDisjointObjectPropertiesAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLObjectPropertyRangeAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLObjectPropertyAssertionAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLFunctionalObjectPropertyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLSubObjectPropertyOfAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDisjointUnionAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.addAll(axiom.getOWLDisjointClassesAxiom().accept(this));
		result.addAll(axiom.getOWLEquivalentClassesAxiom().accept(this));
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDeclarationAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLAnnotationAssertionAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLSymmetricObjectPropertyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDataPropertyRangeAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLFunctionalDataPropertyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLEquivalentDataPropertiesAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLClassAssertionAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLEquivalentClassesAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		for(OWLSubClassOfAxiom s: axiom.asOWLSubClassOfAxioms()){
			result.addAll(s.accept(this));
		}
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDataPropertyAssertionAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLTransitiveObjectPropertyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLSubDataPropertyOfAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLSameIndividualAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLSubPropertyChainOfAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLInverseObjectPropertiesAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLHasKeyAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLDatatypeDefinitionAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(SWRLRule rule) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(rule);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLSubAnnotationPropertyOfAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLAnnotationPropertyDomainAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public Set<OWLAxiom> visit(OWLAnnotationPropertyRangeAxiom axiom) {
		Set<OWLAxiom> result = new HashSet<OWLAxiom>();
		result.add(axiom);
		return result;
	}

	@Override
	public OWLClassExpression visit(OWLClass ce) {
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLObjectIntersectionOf ce) {
		return df.getOWLObjectIntersectionOf(ce.asConjunctSet());
	}

	@Override
	public OWLClassExpression visit(OWLObjectUnionOf ce) {
		return df.getOWLObjectUnionOf(ce.asDisjunctSet());
	}

	@Override
	public OWLClassExpression visit(OWLObjectComplementOf ce) {
		return df.getOWLObjectComplementOf(ce.getOperand().accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectSomeValuesFrom ce) {
		return df.getOWLObjectSomeValuesFrom(ce.getProperty().getSimplified(), ce.getFiller().accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectAllValuesFrom ce) {
		return df.getOWLObjectAllValuesFrom(ce.getProperty().getSimplified(), ce.getFiller().accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectHasValue ce) {
		return ce.asSomeValuesFrom().accept(this);
	}

	@Override
	public OWLClassExpression visit(OWLObjectMinCardinality ce) {
		OWLClassExpression result=ce;
		if(ce.getCardinality()==1){
			result=df.getOWLObjectSomeValuesFrom(ce.getProperty().getSimplified(), ce.getFiller().accept(this));
		}
		return result;
	}

	@Override
	public OWLClassExpression visit(OWLObjectExactCardinality ce) {
		return ce.asIntersectionOfMinMax().accept(this);
	}

	@Override
	public OWLClassExpression visit(OWLObjectMaxCardinality ce) {
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLObjectHasSelf ce) {
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLObjectOneOf ce) {
		return ce.asObjectUnionOf();
	}

	@Override
	public OWLClassExpression visit(OWLDataSomeValuesFrom ce) {
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataAllValuesFrom ce) {
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataHasValue ce) {
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataMinCardinality ce) {
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataExactCardinality ce) {
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataMaxCardinality ce) {
		return ce;
	}


}
