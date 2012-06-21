package org.coode.oppl.utils;

import org.coode.parsers.oppl.IRIVisitorEx;
import org.coode.parsers.oppl.VariableIRI;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

public class IRIVisitorExAdapter<O> extends OWLObjectVisitorExAdapter<O> implements IRIVisitorEx<O> {
	/**
	 * 
	 */
	public IRIVisitorExAdapter() {
		super();
	}

	/**
	 * @param defaultReturnValue
	 */
	public IRIVisitorExAdapter(O defaultReturnValue) {
		super(defaultReturnValue);
	}

	@Override
	public O visit(IRI iri) {
		return this.visitIRI(iri);
	}

	public O visitIRI(IRI iri) {
		return this.getDefaultReturnValue(iri);
	}

	public O visitVariableIRI(VariableIRI iri) {
		return this.getDefaultReturnValue(iri);
	}
}
