/**
 * 
 */
package org.coode.oppl.utils;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class AbstractVariableVisitorExAdapter<O> implements VariableVisitorEx<O> {
	private final O defaultValue;

	/**
	 * @param defaultValue
	 */
	public AbstractVariableVisitorExAdapter(O defaultValue) {
		this.defaultValue = defaultValue;
	}

	protected <P extends OWLObject> O getDefaultValue(Variable<P> v) {
		return this.defaultValue;
	}

	public <P extends OWLObject> O visit(InputVariable<P> v) {
		return this.getDefaultValue(v);
	}

	public <P extends OWLObject> O visit(GeneratedVariable<P> v) {
		return this.getDefaultValue(v);
	}

	public <P extends OWLObject> O visit(RegexpGeneratedVariable<P> regExpGenerated) {
		return this.getDefaultValue(regExpGenerated);
	}
}
