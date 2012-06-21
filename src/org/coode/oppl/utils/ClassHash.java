package org.coode.oppl.utils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;


public class ClassHash {

	private Multimap<OWLClassExpression,OWLClass> m;
	private HashMap<OWLAxiom,Set<OWLObject>> p;
	
	private ClassHash(){
		
	}
	
	public static final ClassHash instance = new ClassHash();
	
	
	public void hashStuff(OWLOntology o){
		hashSubClasses(o);
		hashPrimitives(o);
	}
	
	private void hashSubClasses(OWLOntology o){
		m = HashMultimap.create();
		for (OWLSubClassOfAxiom owlAxiom : o.getAxioms(AxiomType.SUBCLASS_OF)) {
			if(!owlAxiom.getSubClass().isAnonymous())
				m.put(owlAxiom.getSuperClass(), owlAxiom.getSubClass().asOWLClass());
		}
	}
	
	private void hashPrimitives(OWLOntology o){
		p = new HashMap<OWLAxiom, Set<OWLObject>>();
		for (OWLAxiom owlAxiom : o.getAxioms()) {
			p.put(owlAxiom, OWLObjectExtractor.getAllOWLPrimitives(owlAxiom));
		}
	}
	
	
	public Collection<OWLClass> getHashedSubClasses(OWLClassExpression e){
		return this.m.get(e);
	}
	
	public Set<OWLObject> getHashedPrimitives(OWLAxiom a){
		Set<OWLObject> toReturn = this.p.get(a);
		if(toReturn==null){
			toReturn=OWLObjectExtractor.getAllOWLPrimitives(a);
			this.p.put(a, toReturn);
		}
		return toReturn;
	}
}
