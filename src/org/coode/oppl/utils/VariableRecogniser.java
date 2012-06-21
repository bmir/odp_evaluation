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
public class VariableRecogniser {
	public static VariableRecogniser INPUT_VARIABLE_RECOGNISER = new VariableRecogniser(
			new AbstractVariableVisitorExAdapter<Boolean>(false) {
				@Override
				public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
					return true;
				}
			});
	public static VariableRecogniser GENERATED_VARIABLE_RECOGNISER = new VariableRecogniser(
			new AbstractVariableVisitorExAdapter<Boolean>(false) {
				@Override
				public <P extends OWLObject> Boolean visit(GeneratedVariable<P> v) {
					return true;
				}
			});
	public static VariableRecogniser REGEXP_VARIABLE_RECOGNISER = new VariableRecogniser(
			new AbstractVariableVisitorExAdapter<Boolean>(false) {
				@Override
				public <P extends OWLObject> Boolean visit(
						RegexpGeneratedVariable<P> regExpGenerated) {
					return true;
				}
			});
	private final VariableVisitorEx<Boolean> recogniser;

	/**
	 * @return the recogniser
	 */
	public VariableVisitorEx<Boolean> getRecogniser() {
		return this.recogniser;
	}

	/**
	 * @param recogniser
	 */
	VariableRecogniser(VariableVisitorEx<Boolean> recogniser) {
		if (recogniser == null) {
			throw new NullPointerException("The recogniser cannot be null");
		}
		this.recogniser = recogniser;
	}

	public boolean recognise(Variable<?> v) {
		return v.accept(this.getRecogniser());
	}
}
