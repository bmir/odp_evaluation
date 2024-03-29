package org.coode.parsers.oppl.variableattribute;

import org.coode.oppl.Variable;
import org.coode.oppl.function.AttributeName;
import org.coode.oppl.function.GroupVariableAttribute;
import org.coode.oppl.function.RenderingVariableAttribute;
import org.coode.oppl.function.VariableAttribute;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.parsers.oppl.OPPLSymbolVisitor;
import org.coode.parsers.oppl.OPPLSymbolVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;

public abstract class StringVariableAttributeSymbol extends
		VariableAttributeSymbol<VariableAttribute<String>> {
	/**
	 * @param name
	 * @param type
	 * @param variableAttribute
	 */
	public StringVariableAttributeSymbol(String name, VariableAttribute<String> variableAttribute) {
		super(name, VariableAttributeType.STRING, variableAttribute);
	}

	public void accept(OPPLSymbolVisitor visitor) {
		visitor.visitStringVariableAttributeSymbol(this);
	}

	public <O> O accept(OPPLSymbolVisitorEx<O> visitor) {
		return visitor.visitStringVariableAttributeSymbol(this);
	}

	public static StringVariableAttributeSymbol getRendering(Variable<?> v) {
		return new StringVariableAttributeSymbol(String.format(
				"%s.%s",
				v.getName(),
				AttributeName.RENDERING), new RenderingVariableAttribute(v)) {
		};
	}

	public static <O extends OWLObject> StringVariableAttributeSymbol getGroup(
			RegexpGeneratedVariable<O> v, final int index) {
		return new StringVariableAttributeSymbol(String.format(
				"%s.%s(%d)",
				v.getName(),
				AttributeName.GROUP,
				index), new GroupVariableAttribute<O>(v, index)) {
			@Override
			public String toString() {
				return String.format("%s.GROUP(%d)", this.getName(), index);
			}
		};
	}
}
