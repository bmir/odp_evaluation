package org.coode.oppl.variabletypes;

import java.util.regex.Pattern;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

public class VariableFactory {
	public static Variable<OWLClassExpression> getCLASSVariable(String name,
			VariableScope<?> variableScope) {
		return VariableTypeFactory.getCLASSVariableType().getInputVariable(
				name, variableScope);
	}

	public static Variable<OWLObjectPropertyExpression> getOBJECTPROPERTYVariable(
			String name, VariableScope<?> variableScope) {
		return VariableTypeFactory.getOBJECTPROPERTYTypeVariableType()
				.getInputVariable(name, variableScope);
	}

	public static Variable<OWLDataPropertyExpression> getDATAPROPERTYVariable(
			String name, VariableScope<?> variableScope) {
		return VariableTypeFactory.getDATAPROPERTYVariableType()
				.getInputVariable(name, variableScope);
	}

	public static Variable<OWLIndividual> getINDIVIDUALVariable(String name,
			VariableScope<?> variableScope) {
		return VariableTypeFactory.getINDIVIDUALVariableType()
				.getInputVariable(name, variableScope);
	}

	public static Variable<OWLLiteral> getCONSTANTVariable(String name,
			VariableScope<?> variableScope) {
		return VariableTypeFactory.getCONSTANTVariableType().getInputVariable(
				name, variableScope);
	}

	public static <O extends OWLObject> GeneratedVariable<O> getGeneratedVariable(
			String name, VariableType<O> type,
			OPPLFunction<? extends O> opplFunction) {
		return type.getGeneratedVariable(name, opplFunction);
	}

	public static <O extends OWLObject> RegexpGeneratedVariable<? extends O> getRegexpGeneratedVariable(
			String name, VariableType<O> type,
			OPPLFunction<Pattern> opplFunction) {
		return type.getRegexpGeneratedVariable(name, opplFunction);
	}
}
