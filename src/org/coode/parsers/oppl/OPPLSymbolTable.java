package org.coode.parsers.oppl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.Token;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.datafactory.OPPLOWLDataFactory;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.function.VariableAttribute;
import org.coode.oppl.function.inline.InlineSet;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.parsers.DefaultTypeVistorEx;
import org.coode.parsers.IRISymbol;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLLiteralSymbol;
import org.coode.parsers.OWLType;
import org.coode.parsers.Scope;
import org.coode.parsers.Symbol;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.StringVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.ValuesVariableAttributeSymbol;
import org.coode.parsers.oppl.variableattribute.VariableAttributeSymbol;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

public class OPPLSymbolTable extends SymbolTable {
	/**
	 * @param globalScope
	 * @param dataFactory
	 */
	public OPPLSymbolTable(Scope globalScope, OWLDataFactory dataFactory) {
		super(globalScope, dataFactory);
	}

	@Override
	public OPPLOWLDataFactory getDataFactory() {
		return new OPPLOWLDataFactory(super.getDataFactory());
	}

	/**
	 * Defines a new Symbol in this OPPLSymbolTable under the input Token.
	 * 
	 * @param token
	 *            The input token. Cannot be {@code null}.
	 * @param symbol
	 *            The Symbol to be defined. Cannot be {@code null}.
	 * 
	 */
	public void define(Token token, Symbol symbol) {
		if (token == null) {
			throw new NullPointerException("The token cannot be null");
		}
		if (symbol == null) {
			throw new NullPointerException("The symbol cannot be null");
		}
		this.storeSymbol(token, symbol);
	}

	public void defineVariable(ManchesterOWLSyntaxTree identifier,
			ManchesterOWLSyntaxTree variableType, ConstraintSystem constraintSystem) {
		VariableType type = VariableType.getVariableType(variableType.getText());
		if (type == null) {
			this.reportIllegalToken(
					variableType,
					"The variable type is not amongst those recognised");
		} else {
			this.define(
					identifier.token,
					type.getSymbol(this.getDataFactory(), identifier.token.getText()));
			try {
				constraintSystem.createVariable(
						identifier.token.getText(),
						type.getOPPLVariableType(),
						null);
			} catch (OPPLException e) {
				this.reportIllegalToken(identifier, "Error in creating variable: " + e.getMessage());
			}
		}
	}

	public Type getClassVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree classExpression) {
		Type toReturn = null;
		if (!OWLType.isClassExpression(classExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(
					classExpression,
					classExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = classExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getPropertyVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree propertyExpression) {
		Type toReturn = null;
		if (!OWLType.isPropertyExpression(propertyExpression.getEvalType())) {
			this.reportIncompatibleSymbolType(
					propertyExpression,
					propertyExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = propertyExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getIndividualVariableScopeType(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree individualExpression) {
		Type toReturn = null;
		if (OWLType.OWL_INDIVIDUAL != individualExpression.getEvalType()) {
			this.reportIncompatibleSymbolType(
					individualExpression,
					individualExpression.getEvalType(),
					parentExpression);
		} else {
			toReturn = individualExpression.getEvalType();
		}
		return toReturn;
	}

	public Type getExpressionGeneratedVariableType(ManchesterOWLSyntaxTree parentExpression,
			ManchesterOWLSyntaxTree variableType, ManchesterOWLSyntaxTree expression) {
		Type toReturn = null;
		org.coode.oppl.variabletypes.VariableType<?> opplVariableVariableType = VariableTypeFactory.getVariableType(variableType.getText());
		if (opplVariableVariableType == null) {
			this.reportIllegalToken(variableType, "Unknown variable type");
		} else if (expression.getOWLObject() == null) {
			this.reportIllegalToken(expression, "Null OWL Object in expression");
		} else if (!opplVariableVariableType.isCompatibleWith(expression.getOWLObject())) {
			this.reportIncompatibleSymbols(parentExpression, variableType, expression);
		} else {
			toReturn = expression.getEvalType();
		}
		return toReturn;
	}

	public org.coode.oppl.variabletypes.VariableType<?> getVaribaleType(
			ManchesterOWLSyntaxTree variableType) {
		return VariableType.getVariableType(variableType.getText()).getOPPLVariableType();
	}

	public <O extends OWLObject> OPPLFunction<String> defineGroupAttributeReferenceSymbol(
			final OPPLSyntaxTree variableSyntaxTree, ManchesterOWLSyntaxTree indexNode,
			ConstraintSystem constraintSystem) {
		Variable<?> v = constraintSystem.getVariable(variableSyntaxTree.getText());
		OPPLFunction<String> toReturn = null;
		if (v != null) {
			try {
				final int index = Integer.parseInt(indexNode.getText());
				VariableAttributeSymbol<VariableAttribute<String>> symbol = v.accept(new VariableVisitorEx<VariableAttributeSymbol<VariableAttribute<String>>>() {
					public <P extends OWLObject> VariableAttributeSymbol<VariableAttribute<String>> visit(
							InputVariable<P> v) {
						OPPLSymbolTable.this.reportIllegalToken(
								variableSyntaxTree,
								"The variable has to be a regural expression variable");
						return null;
					}

					public <P extends OWLObject> VariableAttributeSymbol<VariableAttribute<String>> visit(
							GeneratedVariable<P> v) {
						OPPLSymbolTable.this.reportIllegalToken(
								variableSyntaxTree,
								"The variable has to be a regural expression variable");
						return null;
					}

					public <P extends OWLObject> VariableAttributeSymbol<VariableAttribute<String>> visit(
							RegexpGeneratedVariable<P> regExpGenerated) {
						return StringVariableAttributeSymbol.getGroup(regExpGenerated, index);
					}
				});
				if (symbol != null) {
					this.storeSymbol(symbol.getName(), symbol);
					toReturn = symbol.getVariableAttribute();
				} else {
					this.reportUnrecognisedSymbol(variableSyntaxTree);
				}
			} catch (NumberFormatException e) {
				this.getErrorListener().reportThrowable(
						e,
						indexNode.getLine(),
						indexNode.getCharPositionInLine(),
						indexNode.getText().length());
			}
		} else {
			this.reportUnrecognisedSymbol(variableSyntaxTree);
		}
		return toReturn;
	}

	public VariableAttribute<String> defineRenderingAttributeReferenceSymbol(
			OPPLSyntaxTree variableSyntaxTree, ConstraintSystem constraintSystem) {
		VariableAttribute<String> toReturn = null;
		Variable<?> v = constraintSystem.getVariable(variableSyntaxTree.getText());
		if (v != null) {
			VariableAttributeSymbol<VariableAttribute<String>> symbol = StringVariableAttributeSymbol.getRendering(v);
			this.storeSymbol(symbol.getName(), symbol);
			toReturn = symbol.getVariableAttribute();
		} else {
			this.reportUnrecognisedSymbol(variableSyntaxTree);
		}
		return toReturn;
	}

	public VariableAttribute<?> defineValuesAttributeReferenceSymbol(
			OPPLSyntaxTree variableSyntaxTree, ConstraintSystem constraintSystem) {
		VariableAttribute<?> toReturn = null;
		Variable<?> v = constraintSystem.getVariable(variableSyntaxTree.getText());
		if (v != null) {
			ValuesVariableAtttribute<?> valuesVariableAtttribute = ValuesVariableAtttribute.getValuesVariableAtttribute(v);
			ValuesVariableAttributeSymbol<?> symbol = ValuesVariableAttributeSymbol.getValuesVariableAttributeSymbol(
					v.getName(),
					valuesVariableAtttribute);
			this.storeSymbol(symbol.getName(), symbol);
			toReturn = symbol.getVariableAttribute();
		} else {
			this.reportUnrecognisedSymbol(variableSyntaxTree);
		}
		return toReturn;
	}

	public InequalityConstraint getInequalityConstraint(OPPLSyntaxTree parentExpression,
			OPPLSyntaxTree variableIdentifier, OPPLSyntaxTree expression,
			ConstraintSystem constraintSystem) {
		Symbol variableSymbol = this.resolve(variableIdentifier);
		final Type variableType = variableSymbol.getType();
		InequalityConstraint toReturn = null;
		if (variableType == null) {
			this.reportIncompatibleSymbolType(variableIdentifier, null, parentExpression);
		} else {
			final Type expressionType = expression.getEvalType();
			final boolean compatibleTypes = this.checkCompatibleTypes(variableType, expressionType);
			if (!compatibleTypes) {
				this.reportIncompatibleSymbols(parentExpression, variableIdentifier, expression);
			} else {
				Variable<?> variable = constraintSystem.getVariable(variableIdentifier.getText());
				if (variable == null) {
					this.reportIllegalToken(variableIdentifier, "Unknown variable");
				} else if (expression.getOWLObject() != null) {
					toReturn = new InequalityConstraint(variable, expression.getOWLObject(),
							constraintSystem);
				} else {
					this.reportIllegalToken(expression, "No OWL object");
				}
			}
		}
		return toReturn;
	}

	/**
	 * @param variableType
	 * @param expressionType
	 * @return
	 */
	private boolean checkCompatibleTypes(final Type variableType, final Type expressionType) {
		return variableType.accept(new DefaultTypeVistorEx<Boolean>() {
			@Override
			protected Boolean doDefault(Type type) {
				return false;
			}

			@Override
			public Boolean visitOWLType(OWLType owlType) {
				boolean toReturn = false;
				switch (owlType) {
				case OWL_CLASS:
				case OWL_DATA_ALL_RESTRICTION:
				case OWL_DATA_EXACT_CARDINALITY_RESTRICTION:
				case OWL_DATA_MAX_CARDINALITY_RESTRICTION:
				case OWL_DATA_MIN_CARDINALITY_RESTRICTION:
				case OWL_DATA_SOME_RESTRICTION:
				case OWL_DATA_VALUE_RESTRICTION:
				case OWL_OBJECT_ALL_RESTRICTION:
				case OWL_OBJECT_COMPLEMENT_OF:
				case OWL_OBJECT_EXACT_CARDINALITY_RESTRICTION:
				case OWL_OBJECT_INTERSECTION_OF:
				case OWL_OBJECT_MAX_CARDINALITY_RESTRICTION:
				case OWL_OBJECT_MIN_CARDINALITY_RESTRICTION:
				case OWL_OBJECT_ONE_OF:
				case OWL_OBJECT_SELF_RESTRICTION:
				case OWL_OBJECT_SOME_RESTRICTION:
				case OWL_OBJECT_UNION_OF:
				case OWL_OBJECT_VALUE_RESTRICTION:
					toReturn = OWLType.isClassExpression(expressionType);
					break;
				case OWL_OBJECT_PROPERTY:
				case OWL_OBJECT_INVERSE_PROPERTY:
					toReturn = OWLType.isObjectPropertyExpression(expressionType);
					break;
				case OWL_DATA_PROPERTY:
					toReturn = OWLType.OWL_DATA_PROPERTY == expressionType;
					break;
				case OWL_INDIVIDUAL:
					toReturn = OWLType.OWL_INDIVIDUAL == expressionType;
					break;
				case OWL_CONSTANT:
					toReturn = OWLType.OWL_CONSTANT == expressionType;
					break;
				default:
					toReturn = false;
				}
				return toReturn;
			}
		});
	}

	public InCollectionConstraint<OWLObject> getInSetConstraint(OPPLSyntaxTree parentExpression,
			OPPLSyntaxTree v, ConstraintSystem constraintSystem, OPPLSyntaxTree... elements) {
		InCollectionConstraint<OWLObject> toReturn = null;
		boolean allCompatible = true;
		if (elements.length > 0) {
			List<OPPLSyntaxTree> incompatibles = new ArrayList<OPPLSyntaxTree>(elements.length);
			List<OWLObject> owlObjects = new ArrayList<OWLObject>(elements.length);
			Symbol variableSymbol = this.resolve(v);
			final Type variableType = variableSymbol.getType();
			for (OPPLSyntaxTree element : elements) {
				Symbol resolvedElement = this.resolve(element);
				if (resolvedElement == null) {
					this.reportUnrecognisedSymbol(element);
					allCompatible = false;
				}
			}
			if (allCompatible) {
				for (OPPLSyntaxTree element : elements) {
					Symbol resolvedElement = this.resolve(element);
					final boolean isCompatible = resolvedElement != null
							&& this.checkCompatibleTypes(variableType, resolvedElement.getType())
							&& element.getOWLObject() != null;
					allCompatible = allCompatible && isCompatible;
					if (!isCompatible) {
						incompatibles.add(element);
					} else {
						owlObjects.add(element.getOWLObject());
					}
				}
			}
			if (allCompatible) {
				Variable variable = constraintSystem.getVariable(v.getText());
				if (variable == null) {
					this.reportIllegalToken(v, "Unknown variable");
				} else {
					toReturn = InCollectionConstraint.getInCollectionConstraint(
							variable,
							owlObjects,
							constraintSystem);
				}
			} else if (!incompatibles.isEmpty()) {
				incompatibles.add(0, v);
				this.reportIncompatibleSymbols(
						parentExpression,
						incompatibles.toArray(new OPPLSyntaxTree[incompatibles.size()]));
			}
		} else {
			this.reportIllegalToken(parentExpression, "Empty set");
		}
		return toReturn;
	}

	public Variable<?> getVariable(OPPLSyntaxTree identifier, ConstraintSystem constraintSystem) {
		Symbol variableSymbol = this.resolve(identifier);
		Variable<?> toReturn = null;
		if (variableSymbol == null) {
			this.reportIllegalToken(identifier, "Undefined variable ");
		} else {
			toReturn = constraintSystem.getVariable(variableSymbol.getName());
			if (toReturn == null) {
				this.reportIllegalToken(
						identifier,
						"Undefined variable in the script constraint system");
			}
		}
		return toReturn;
	}

	/**
	 * Import all the variables in the input ConstraintSystem into this
	 * OPPLSymbolTable.
	 * 
	 * @param constraintSystem
	 *            The input constraint system. It cannot be {@code null}.
	 * @throws NullPointerException
	 *             if the input is {@code null}.
	 */
	public void importConstraintSystem(ConstraintSystem constraintSystem) {
		Set<Variable<?>> variables = constraintSystem.getVariables();
		for (Variable<?> variable : variables) {
			this.importVariable(variable);
		}
	}

	private void importVariable(Variable<?> variable) {
		VariableType type = VariableType.getVariableType(variable.getType().toString());
		Symbol symbol = type.getSymbol(this.getDataFactory(), variable.getName());
		this.storeSymbol(variable.getName(), symbol);
	}

	public VariableAttribute<String> getStringVariableAttribute(
			final OPPLSyntaxTree variableAttributeSyntaxTree) {
		Symbol symbol = this.retrieveSymbol(variableAttributeSyntaxTree.getText());
		VariableAttribute<String> toReturn = null;
		if (symbol != null) {
			toReturn = symbol.accept(new OPPLSymbolVisitorEx<VariableAttribute<String>>() {
				public VariableAttribute<String> visitSymbol(Symbol symbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							variableAttributeSyntaxTree,
							"Invalid symbol or variable attribute");
					return null;
				}

				public VariableAttribute<String> visitOWLLiteral(OWLLiteralSymbol owlConstantSymbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							variableAttributeSyntaxTree,
							"Invalid symbol or variable attribute");
					return null;
				}

				public VariableAttribute<String> visitIRI(IRISymbol iriSymbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							variableAttributeSyntaxTree,
							"Invalid symbol or variable attribute");
					return null;
				}

				public VariableAttribute<String> visitOWLEntity(OWLEntitySymbol owlEntitySymbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							variableAttributeSyntaxTree,
							"Invalid symbol or variable attribute");
					return null;
				}

				public VariableAttribute<String> visitStringVariableAttributeSymbol(
						StringVariableAttributeSymbol stringVariableAttributeSymbol) {
					return stringVariableAttributeSymbol.getVariableAttribute();
				}

				public <P extends OWLObject, T extends VariableAttribute<Collection<? extends P>>> VariableAttribute<String> visitCollectionVariableAttributeSymbol(
						CollectionVariableAttributeSymbol<P, T> collectionVariableAttributeSymbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							variableAttributeSyntaxTree,
							"Invalid symbol or variable attribute");
					return null;
				}

				public VariableAttribute<String> visitCreateOnDemandIdentifier(
						CreateOnDemandIdentifier createOnDemandIdentifier) {
					OPPLSymbolTable.this.reportIllegalToken(
							variableAttributeSyntaxTree,
							"Invalid symbol or variable attribute");
					return null;
				}
			});
		} else {
			this.reportIllegalToken(
					variableAttributeSyntaxTree,
					"Invalid symbol or variable attribute");
		}
		return toReturn;
	}

	public <P extends OWLObject, O extends VariableAttribute<Collection<? extends P>>> CollectionVariableAttributeSymbol<P, O> getCollectionVariableAttributeSymbol(
			final org.coode.oppl.variabletypes.VariableType<?> type,
			final OPPLSyntaxTree attributeSyntaxTree) {
		Symbol symbol = this.retrieveSymbol(attributeSyntaxTree.getText());
		CollectionVariableAttributeSymbol<P, O> toReturn = null;
		if (symbol != null) {
			toReturn = symbol.accept(new OPPLSymbolVisitorEx<CollectionVariableAttributeSymbol<P, O>>() {
				public CollectionVariableAttributeSymbol<P, O> visitSymbol(Symbol symbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							attributeSyntaxTree,
							"Wrong kind of symbol ");
					return null;
				}

				public CollectionVariableAttributeSymbol<P, O> visitOWLLiteral(
						OWLLiteralSymbol owlConstantSymbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							attributeSyntaxTree,
							"Wrong kind of symbol ");
					return null;
				}

				public CollectionVariableAttributeSymbol<P, O> visitOWLEntity(
						OWLEntitySymbol owlEntitySymbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							attributeSyntaxTree,
							"Wrong kind of symbol ");
					return null;
				}

				public CollectionVariableAttributeSymbol<P, O> visitStringVariableAttributeSymbol(
						StringVariableAttributeSymbol stringVariableAttributeSymbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							attributeSyntaxTree,
							"Wrong kind of symbol ");
					return null;
				}

				public CollectionVariableAttributeSymbol<P, O> visitIRI(IRISymbol iriSymbol) {
					OPPLSymbolTable.this.reportIllegalToken(
							attributeSyntaxTree,
							"Wrong kind of symbol ");
					return null;
				}

				public <R extends OWLObject, S extends VariableAttribute<Collection<? extends R>>> CollectionVariableAttributeSymbol<P, O> visitCollectionVariableAttributeSymbol(
						CollectionVariableAttributeSymbol<R, S> collectionVariableAttributeSymbol) {
					CollectionVariableAttributeSymbol<P, O> toReturn = null;
					if (collectionVariableAttributeSymbol.getVariableAttribute().getVariable().getType() == type) {
						// The cast to object is currently necessary see
						// BugID 6548436
						// http://bugs.sun.com/view_bug.do?bug_id=6548436
						// Eclipse will compile but the JVM invoked by
						// the javac ANT task for instance will not
						toReturn = (CollectionVariableAttributeSymbol<P, O>) collectionVariableAttributeSymbol;
					} else {
						OPPLSymbolTable.this.reportIllegalToken(
								attributeSyntaxTree,
								"Wrong kind of symbol ");
					}
					return toReturn;
				}

				public CollectionVariableAttributeSymbol<P, O> visitCreateOnDemandIdentifier(
						CreateOnDemandIdentifier createOnDemandIdentifier) {
					OPPLSymbolTable.this.reportIllegalToken(
							attributeSyntaxTree,
							"Wrong kind of symbol ");
					return null;
				}
			});
		} else {
			this.reportUnrecognisedSymbol(attributeSyntaxTree);
		}
		return toReturn;
	}

	public void defineVariableIRI(OPPLSyntaxTree iriTree, OPPLSyntaxTree variableNameTree,
			ConstraintSystem constraintSystem) {
		Symbol toReturn = this.retrieveSymbol(iriTree.getText());
		if (toReturn == null) {
			String name = variableNameTree.getToken().getText();
			Variable<?> variable = constraintSystem.getVariable(name);
			if (variable != null) {
				IRI iri = new VariableIRI(variable);
				if (iri != null) {
					toReturn = new IRISymbol(name, iri);
				}
				this.storeSymbol(iriTree.getText(), toReturn);
			} else {
				this.reportUnrecognisedSymbol(variableNameTree);
			}
		}
	}

	public OWLAxiom getDisjointAxiom(final OPPLSyntaxTree expression,
			final Collection<? extends Aggregandum<?>> aggregandums,
			final List<OPPLSyntaxTree> aggregdandumTrees, final ConstraintSystem constraintSystem) {
		org.coode.oppl.variabletypes.VariableType<?> aggregandumCollectionType = this.getAggregandumCollectionType(
				aggregandums,
				aggregdandumTrees,
				expression);
		OWLAxiom toReturn = null;
		if (aggregandumCollectionType != null) {
			toReturn = aggregandumCollectionType.accept(new VariableTypeVisitorEx<OWLAxiom>() {
				public OWLAxiom visitANNOTATIONPROPERTYVariableType(
						ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
					OPPLSymbolTable.this.reportIncompatibleSymbolType(
							expression,
							VariableType.ANNOTATIONPROPERTY,
							expression);
					return null;
				}

				public OWLAxiom visitCONSTANTVariableType(CONSTANTVariableType constantVariableType) {
					OPPLSymbolTable.this.reportIncompatibleSymbolType(
							expression,
							VariableType.CONSTANT,
							expression);
					return null;
				}

				public OWLAxiom visitINDIVIDUALVariableType(
						INDIVIDUALVariableType individualVariableType) {
					OPPLSymbolTable.this.reportIncompatibleSymbolType(
							expression,
							VariableType.INDIVIDUAL,
							expression);
					return null;
				}

				public OWLAxiom visitCLASSVariableType(CLASSVariableType classVariableType) {
					Collection<? extends Aggregandum<Collection<? extends OWLClassExpression>>> aggregandumCollection = OPPLSymbolTable.this.getAggregandumCollection(
							classVariableType,
							aggregandums,
							aggregdandumTrees,
							expression);
					InlineSet<OWLClassExpression> inlineSet = new InlineSet<OWLClassExpression>(
							classVariableType, aggregandumCollection,
							OPPLSymbolTable.this.getDataFactory(), constraintSystem);
					return OPPLSymbolTable.this.getDataFactory().getOWLDisjointClassesAxiom(
							inlineSet,
							inlineSet.size() == 2);
				}

				public OWLAxiom visitDATAPROPERTYVariableType(
						DATAPROPERTYVariableType datapropertyVariableType) {
					Collection<? extends Aggregandum<Collection<? extends OWLDataPropertyExpression>>> aggregandumCollection = OPPLSymbolTable.this.getAggregandumCollection(
							datapropertyVariableType,
							aggregandums,
							aggregdandumTrees,
							expression);
					InlineSet<OWLDataPropertyExpression> inlineSet = new InlineSet<OWLDataPropertyExpression>(
							datapropertyVariableType, aggregandumCollection,
							OPPLSymbolTable.this.getDataFactory(), constraintSystem);
					return OPPLSymbolTable.this.getDataFactory().getOWLDisjointDataPropertiesAxiom(
							inlineSet,
							inlineSet.size() == 2);
				}

				public OWLAxiom visitOBJECTPROPERTYVariableType(
						OBJECTPROPERTYVariableType objectpropertyVariableType) {
					Collection<? extends Aggregandum<Collection<? extends OWLObjectPropertyExpression>>> aggregandumCollection = OPPLSymbolTable.this.getAggregandumCollection(
							objectpropertyVariableType,
							aggregandums,
							aggregdandumTrees,
							expression);
					InlineSet<OWLObjectPropertyExpression> inlineSet = new InlineSet<OWLObjectPropertyExpression>(
							objectpropertyVariableType, aggregandumCollection,
							OPPLSymbolTable.this.getDataFactory(), constraintSystem);
					return OPPLSymbolTable.this.getDataFactory().getOWLDisjointObjectPropertiesAxiom(
							inlineSet,
							inlineSet.size() == 2);
				}
			});
		} else {
			this.reportIncompatibleSymbols(
					expression,
					aggregdandumTrees.toArray(new OPPLSyntaxTree[aggregdandumTrees.size()]));
		}
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	public <O extends OWLObject> Collection<? extends Aggregandum<Collection<? extends O>>> getAggregandumCollection(
			org.coode.oppl.variabletypes.VariableType<O> variableType,
			Collection<? extends Aggregandum<?>> aggregandums,
			List<OPPLSyntaxTree> aggregandumsTrees, OPPLSyntaxTree parentExpression) {
		List<Aggregandum<Collection<? extends O>>> toReturn = new ArrayList<Aggregandum<Collection<? extends O>>>(
				aggregandums.size());
		boolean allFine = true;
		Iterator<? extends Aggregandum<?>> iterator = aggregandums.iterator();
		int i = 0;
		while (allFine && iterator.hasNext()) {
			Aggregandum<?> aggregandum = iterator.next();
			allFine = aggregandum.isCompatible(variableType);
			if (allFine) {
				toReturn.add((Aggregandum<Collection<? extends O>>) aggregandum);
			} else {
				OPPLSyntaxTree opplSyntaxTree = aggregandumsTrees.get(i);
				this.reportIncompatibleSymbolType(
						opplSyntaxTree,
						opplSyntaxTree.getEvalType(),
						parentExpression);
			}
			i++;
		}
		return allFine ? toReturn : null;
	}

	@SuppressWarnings("unchecked")
	public org.coode.oppl.variabletypes.VariableType<?> getAggregandumCollectionType(
			Collection<? extends Aggregandum<?>> aggregandums,
			List<OPPLSyntaxTree> aggregandumsTrees, OPPLSyntaxTree parentExpression) {
		org.coode.oppl.variabletypes.VariableType<?> toReturn = null;
		boolean allFine = true;
		Iterator<? extends Aggregandum<?>> iterator = aggregandums.iterator();
		int i = 0;
		while (allFine && iterator.hasNext()) {
			Aggregandum<?> aggregandum = iterator.next();
			org.coode.oppl.variabletypes.VariableType<?> aggregandumVariableType = this.getAggregandumVariableType(
					aggregandum,
					aggregandumsTrees.get(i));
			allFine = toReturn == null || toReturn.equals(aggregandumVariableType);
			if (allFine) {
				toReturn = aggregandumVariableType;
			} else {
				OPPLSyntaxTree opplSyntaxTree = aggregandumsTrees.get(i);
				this.reportIncompatibleSymbolType(
						opplSyntaxTree,
						opplSyntaxTree.getEvalType(),
						parentExpression);
			}
			i++;
		}
		return allFine ? toReturn : null;
	}

	private org.coode.oppl.variabletypes.VariableType<?> getAggregandumVariableType(
			Aggregandum<?> aggregandum, OPPLSyntaxTree opplSyntaxTree) {
		org.coode.oppl.variabletypes.VariableType<?> toReturn = null;
		Iterator<org.coode.oppl.variabletypes.VariableType<?>> iterator = VariableTypeFactory.getAllVariableTypes().iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			org.coode.oppl.variabletypes.VariableType<?> variableType = iterator.next();
			found = aggregandum.isCompatible(variableType);
			if (found) {
				toReturn = variableType;
			}
		}
		return toReturn;
	}

	public OWLAxiom getDifferentIndividualsAxiom(OPPLSyntaxTree opplSyntaxTree,
			List<Aggregandum<?>> list, List<OPPLSyntaxTree> tokenList,
			ConstraintSystem constraintSystem) {
		OWLAxiom toReturn = null;
		org.coode.oppl.variabletypes.VariableType<?> aggregandumCollectionType = this.getAggregandumCollectionType(
				list,
				tokenList,
				opplSyntaxTree);
		if (aggregandumCollectionType == VariableTypeFactory.getINDIVIDUALVariableType()) {
			Collection<? extends Aggregandum<Collection<? extends OWLIndividual>>> aggregandumCollection = this.getAggregandumCollection(
					VariableTypeFactory.getINDIVIDUALVariableType(),
					list,
					tokenList,
					opplSyntaxTree);
			InlineSet<OWLIndividual> individuals = new InlineSet<OWLIndividual>(
					VariableTypeFactory.getINDIVIDUALVariableType(), aggregandumCollection,
					this.getDataFactory(), constraintSystem);
			toReturn = this.getDataFactory().getOWLDifferentIndividualsAxiom(
					individuals,
					individuals.size() == 2);
		} else {
			this.reportIncompatibleSymbolType(
					opplSyntaxTree,
					VariableType.getVariableType(aggregandumCollectionType),
					opplSyntaxTree);
		}
		return toReturn;
	}

	public OWLAxiom getSameIndividualAxiom(OPPLSyntaxTree opplSyntaxTree,
			List<Aggregandum<?>> list, List<OPPLSyntaxTree> tokenList,
			ConstraintSystem constraintSystem) {
		OWLAxiom toReturn = null;
		org.coode.oppl.variabletypes.VariableType<?> aggregandumCollectionType = this.getAggregandumCollectionType(
				list,
				tokenList,
				opplSyntaxTree);
		if (aggregandumCollectionType == VariableTypeFactory.getINDIVIDUALVariableType()) {
			Collection<? extends Aggregandum<Collection<? extends OWLIndividual>>> aggregandumCollection = this.getAggregandumCollection(
					VariableTypeFactory.getINDIVIDUALVariableType(),
					list,
					tokenList,
					opplSyntaxTree);
			InlineSet<OWLIndividual> individuals = new InlineSet<OWLIndividual>(
					VariableTypeFactory.getINDIVIDUALVariableType(), aggregandumCollection,
					this.getDataFactory(), constraintSystem);
			toReturn = this.getDataFactory().getOWLSameIndividualAxiom(
					individuals,
					individuals.size() == 2);
		} else {
			this.reportIncompatibleSymbolType(
					opplSyntaxTree,
					VariableType.getVariableType(aggregandumCollectionType),
					opplSyntaxTree);
		}
		return toReturn;
	}
}
