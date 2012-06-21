/**
 * 
 */
package org.coode.parsers.oppl.variableattribute;

import java.util.Collection;

import org.coode.oppl.function.VariableAttribute;
import org.coode.parsers.oppl.OPPLSymbolVisitor;
import org.coode.parsers.oppl.OPPLSymbolVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class CollectionVariableAttributeSymbol<P extends OWLObject, O extends VariableAttribute<Collection<? extends P>>>
		extends VariableAttributeSymbol<O> {
	/**
	 * @param name
	 * @param type
	 * @param variableAttribute
	 */
	public CollectionVariableAttributeSymbol(String name, O variableAttribute) {
		super(name, VariableAttributeType.COLLECTION, variableAttribute);
	}

	public void accept(OPPLSymbolVisitor visitor) {
		visitor.visitCollectionVariableAttributeSymbol(this);
	}

	public <T> T accept(OPPLSymbolVisitorEx<T> visitor) {
		return visitor.visitCollectionVariableAttributeSymbol(this);
	}
}
