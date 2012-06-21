package org.coode.oppl.entity;

import org.semanticweb.owlapi.model.OWLException;

/**
 * Author: drummond<br>
 * http://www.cs.man.ac.uk/~drummond/<br>
 * <br>
 * <p/>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Sep 18, 2008<br>
 * <br>
 */
public class OWLEntityCreationException extends OWLException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8621012100349331741L;

	public OWLEntityCreationException(String s) {
		super(s);
	}

	public OWLEntityCreationException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public OWLEntityCreationException(Throwable throwable) {
		super(throwable);
	}
}
