package org.coode.parsers.oppl;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g 2011-07-18 15:59:56
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OPPLLexer extends Lexer {
	public static final int HAS_KEY = 109;
	public static final int VALUE_RESTRICTION = 63;
	public static final int LETTER = 43;
	public static final int REMOVE = 91;
	public static final int TYPES = 39;
	public static final int SAME_AS_AXIOM = 52;
	public static final int INVERSE_OF = 25;
	public static final int NOT = 12;
	public static final int SUBCLASS_OF = 20;
	public static final int EOF = -1;
	public static final int ESCLAMATION_MARK = 149;
	public static final int CREATE = 80;
	public static final int POW = 36;
	public static final int NOT_EQUAL = 72;
	public static final int INVERSE_OBJECT_PROPERTY_EXPRESSION = 68;
	public static final int INSTANCE_OF = 38;
	public static final int BEGIN = 83;
	public static final int QUESTION_MARK = 46;
	public static final int DISJOINT_PROPERTIES = 117;
	public static final int SYMMETRIC = 30;
	public static final int CARDINALITY_RESTRICTION = 64;
	public static final int SELECT = 75;
	public static final int ROLE_ASSERTION = 67;
	public static final int DIFFERENT_FROM_AXIOM = 53;
	public static final int TO_LOWER_CASE = 120;
	public static final int TRANSITIVE = 34;
	public static final int ANTI_SYMMETRIC = 31;
	public static final int GREATER_THAN_EQUAL = 486;
	public static final int ALL_RESTRICTION = 62;
	public static final int CONJUNCTION = 56;
	public static final int NEGATED_ASSERTION = 59;
	public static final int WHITESPACE = 9;
	public static final int MATCH = 176;
	public static final int VALUE = 18;
	public static final int FAIL = 466;
	public static final int GROUPS = 356;
	public static final int OPEN_CURLY_BRACES = 6;
	public static final int DISJUNCTION = 55;
	public static final int INVERSE = 19;
	public static final int DBLQUOTE = 40;
	public static final int OR = 11;
	public static final int LESS_THAN = 483;
	public static final int CONSTANT = 70;
	public static final int ENTITY_REFERENCE = 45;
	public static final int END = 84;
	public static final int COMPOSITION = 4;
	public static final int CLOSED_SQUARE_BRACKET = 86;
	public static final int SAME_AS = 23;
	public static final int WHERE = 71;
	public static final int DIFFERENT_INDIVIDUALS = 119;
	public static final int DISJOINT_WITH = 26;
	public static final int SUPER_PROPERTY_OF = 88;
	public static final int VARIABLE_TYPE = 89;
	public static final int CLOSED_PARENTHESYS = 8;
	public static final int ONLY = 14;
	public static final int EQUIVALENT_TO_AXIOM = 49;
	public static final int SUB_PROPERTY_OF = 21;
	public static final int NEGATED_EXPRESSION = 58;
	public static final int MAX = 16;
	public static final int TO_UPPER_CASE = 121;
	public static final int CREATE_DISJUNCTION = 82;
	public static final int AND = 10;
	public static final int INVERSE_PROPERTY = 60;
	public static final int AT = 114;
	public static final int VARIABLE_NAME = 464;
	public static final int DIFFERENT_FROM = 24;
	public static final int IN = 74;
	public static final int EQUIVALENT_TO = 22;
	public static final int UNARY_AXIOM = 54;
	public static final int COMMA = 37;
	public static final int CLOSED_CURLY_BRACES = 7;
	public static final int IDENTIFIER = 44;
	public static final int IRI = 110;
	public static final int SOME = 13;
	public static final int EQUAL = 73;
	public static final int OPEN_PARENTHESYS = 5;
	public static final int SAME_INDIVIDUAL = 118;
	public static final int REFLEXIVE = 32;
	public static final int PLUS = 79;
	public static final int DIGIT = 41;
	public static final int DOT = 78;
	public static final int SUPER_CLASS_OF = 87;
	public static final int EXPRESSION = 69;
	public static final int SOME_RESTRICTION = 61;
	public static final int ADD = 90;
	public static final int INTEGER = 42;
	public static final int GREATER_THAN = 485;
	public static final int EXACTLY = 17;
	public static final int SUB_PROPERTY_AXIOM = 51;
	public static final int OPEN_SQUARE_BRACKET = 85;
	public static final int VALUES = 354;
	public static final int RANGE = 28;
	public static final int SET = 115;
	public static final int ONE_OF = 65;
	public static final int MIN = 15;
	public static final int SUB_CLASS_AXIOM = 48;
	public static final int Tokens = 47;
	public static final int DOMAIN = 27;
	public static final int SUBPROPERTY_OF = 105;
	public static final int COLON = 77;
	public static final int DISJOINT_WITH_AXIOM = 50;
	public static final int CREATE_INTERSECTION = 81;
	public static final int INVERSE_FUNCTIONAL = 35;
	public static final int RENDERING = 355;
	public static final int IRI_ATTRIBUTE_NAME = 112;
	public static final int IRREFLEXIVE = 33;
	public static final int LESS_THAN_EQUAL = 484;
	public static final int ASSERTED = 76;
	public static final int FUNCTIONAL = 29;
	public static final int PROPERTY_CHAIN = 57;
	public static final int TYPE_ASSERTION = 66;
	public static final int DISJOINT_CLASSES = 116;
	// delegates
	public OPPLLexer_MOWLLexer gMOWLLexer;

	// delegators
	public OPPLLexer() {
		;
	}

	public OPPLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public OPPLLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
		this.gMOWLLexer = new OPPLLexer_MOWLLexer(input, state, this);
	}

	@Override
	public String getGrammarFileName() {
		return "/Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g";
	}

	// $ANTLR start "VARIABLE_TYPE"
	public final void mVARIABLE_TYPE() throws RecognitionException {
		try {
			int _type = VARIABLE_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:14:3: (
			// 'CLASS' | 'OBJECTPROPERTY' | 'DATAPROPERTY' |
			// 'ANNOTATIONPROPERTY' | 'INDIVIDUAL' | 'CONSTANT' )
			int alt1 = 6;
			switch (this.input.LA(1)) {
			case 'C': {
				int LA1_1 = this.input.LA(2);
				if (LA1_1 == 'L') {
					alt1 = 1;
				} else if (LA1_1 == 'O') {
					alt1 = 6;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 1, 1, this.input);
					throw nvae;
				}
			}
				break;
			case 'O': {
				alt1 = 2;
			}
				break;
			case 'D': {
				alt1 = 3;
			}
				break;
			case 'A': {
				alt1 = 4;
			}
				break;
			case 'I': {
				alt1 = 5;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 1, 0, this.input);
				throw nvae;
			}
			switch (alt1) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:15:2:
				// 'CLASS'
			{
				this.match("CLASS");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:16:4:
				// 'OBJECTPROPERTY'
			{
				this.match("OBJECTPROPERTY");
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:17:4:
				// 'DATAPROPERTY'
			{
				this.match("DATAPROPERTY");
			}
				break;
			case 4:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:18:4:
				// 'ANNOTATIONPROPERTY'
			{
				this.match("ANNOTATIONPROPERTY");
			}
				break;
			case 5:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:19:4:
				// 'INDIVIDUAL'
			{
				this.match("INDIVIDUAL");
			}
				break;
			case 6:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:20:4:
				// 'CONSTANT'
			{
				this.match("CONSTANT");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VARIABLE_TYPE"
	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:29:3: (
			// 'ADD' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:30:5:
			// 'ADD'
			{
				this.match("ADD");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ADD"
	// $ANTLR start "REMOVE"
	public final void mREMOVE() throws RecognitionException {
		try {
			int _type = REMOVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:34:3: (
			// 'REMOVE' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:35:5:
			// 'REMOVE'
			{
				this.match("REMOVE");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "REMOVE"
	// $ANTLR start "WHERE"
	public final void mWHERE() throws RecognitionException {
		try {
			int _type = WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:39:3: (
			// 'WHERE' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:40:5:
			// 'WHERE'
			{
				this.match("WHERE");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "WHERE"
	// $ANTLR start "NOT_EQUAL"
	public final void mNOT_EQUAL() throws RecognitionException {
		try {
			int _type = NOT_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:44:3: (
			// '!=' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:45:5:
			// '!='
			{
				this.match("!=");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NOT_EQUAL"
	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:49:3: (
			// 'IN' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:50:5:
			// 'IN'
			{
				this.match("IN");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IN"
	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:54:3: (
			// 'SELECT' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:55:5:
			// 'SELECT'
			{
				this.match("SELECT");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SELECT"
	// $ANTLR start "ASSERTED"
	public final void mASSERTED() throws RecognitionException {
		try {
			int _type = ASSERTED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:59:3: (
			// 'ASSERTED' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:60:5:
			// 'ASSERTED'
			{
				this.match("ASSERTED");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ASSERTED"
	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:64:3: (
			// ':' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:65:5:
			// ':'
			{
				this.match(':');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "COLON"
	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:69:3: (
			// '.' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:70:5:
			// '.'
			{
				this.match('.');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DOT"
	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:76:3: (
			// '+' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:77:5:
			// '+'
			{
				this.match('+');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "PLUS"
	// $ANTLR start "CREATE"
	public final void mCREATE() throws RecognitionException {
		try {
			int _type = CREATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:83:3: (
			// 'create' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:84:5:
			// 'create'
			{
				this.match("create");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CREATE"
	// $ANTLR start "CREATE_INTERSECTION"
	public final void mCREATE_INTERSECTION() throws RecognitionException {
		try {
			int _type = CREATE_INTERSECTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:88:3: (
			// 'createIntersection' | 'CreateIntersection' )
			int alt2 = 2;
			int LA2_0 = this.input.LA(1);
			if (LA2_0 == 'c') {
				alt2 = 1;
			} else if (LA2_0 == 'C') {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0, this.input);
				throw nvae;
			}
			switch (alt2) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:89:5:
				// 'createIntersection'
			{
				this.match("createIntersection");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:89:28:
				// 'CreateIntersection'
			{
				this.match("CreateIntersection");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CREATE_INTERSECTION"
	// $ANTLR start "CREATE_DISJUNCTION"
	public final void mCREATE_DISJUNCTION() throws RecognitionException {
		try {
			int _type = CREATE_DISJUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:93:3: (
			// 'createUnion' | 'CreateUnion' )
			int alt3 = 2;
			int LA3_0 = this.input.LA(1);
			if (LA3_0 == 'c') {
				alt3 = 1;
			} else if (LA3_0 == 'C') {
				alt3 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0, this.input);
				throw nvae;
			}
			switch (alt3) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:94:5:
				// 'createUnion'
			{
				this.match("createUnion");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:94:21:
				// 'CreateUnion'
			{
				this.match("CreateUnion");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CREATE_DISJUNCTION"
	// $ANTLR start "BEGIN"
	public final void mBEGIN() throws RecognitionException {
		try {
			int _type = BEGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:98:3: (
			// 'BEGIN' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:99:5:
			// 'BEGIN'
			{
				this.match("BEGIN");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "BEGIN"
	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:103:3: (
			// 'END;' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:104:5:
			// 'END;'
			{
				this.match("END;");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "END"
	// $ANTLR start "DISJOINT_CLASSES"
	public final void mDISJOINT_CLASSES() throws RecognitionException {
		try {
			int _type = DISJOINT_CLASSES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:108:2: (
			// ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'J' | 'j' ) ( 'O' |
			// 'o' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'C' | 'c' ) (
			// 'L' | 'l' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e'
			// ) ( 'S' | 's' ) ( ':' )? )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:109:2: (
			// 'D' | 'd' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'J' | 'j' ) ( 'O' | 'o'
			// ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'L' |
			// 'l' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) (
			// 'S' | 's' ) ( ':' )?
			{
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'J' || this.input.LA(1) == 'j') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:109:137:
				// ( ':' )?
				int alt4 = 2;
				int LA4_0 = this.input.LA(1);
				if (LA4_0 == ':') {
					alt4 = 1;
				}
				switch (alt4) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:109:137:
					// ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DISJOINT_CLASSES"
	// $ANTLR start "DISJOINT_PROPERTIES"
	public final void mDISJOINT_PROPERTIES() throws RecognitionException {
		try {
			int _type = DISJOINT_PROPERTIES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:113:2: (
			// ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'J' | 'j' ) ( 'O' |
			// 'o' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'P' | 'p' ) (
			// 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r'
			// ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( ':'
			// )? )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:114:2: (
			// 'D' | 'd' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'J' | 'j' ) ( 'O' | 'o'
			// ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'P' | 'p' ) ( 'R' |
			// 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' ) (
			// 'T' | 't' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( ':' )?
			{
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'J' || this.input.LA(1) == 'j') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'P' || this.input.LA(1) == 'p') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'P' || this.input.LA(1) == 'p') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:114:164:
				// ( ':' )?
				int alt5 = 2;
				int LA5_0 = this.input.LA(1);
				if (LA5_0 == ':') {
					alt5 = 1;
				}
				switch (alt5) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:114:164:
					// ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DISJOINT_PROPERTIES"
	// $ANTLR start "SAME_INDIVIDUAL"
	public final void mSAME_INDIVIDUAL() throws RecognitionException {
		try {
			int _type = SAME_INDIVIDUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:118:2: (
			// ( 'S' | 's' ) ( 'A' | 'a' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'I' |
			// 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'V' | 'v' ) (
			// 'I' | 'i' ) ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l'
			// ) ( ':' )? )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:118:4: (
			// 'S' | 's' ) ( 'A' | 'a' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'I' | 'i'
			// ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'I' |
			// 'i' ) ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' ) (
			// ':' )?
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'M' || this.input.LA(1) == 'm') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:118:130:
				// ( ':' )?
				int alt6 = 2;
				int LA6_0 = this.input.LA(1);
				if (LA6_0 == ':') {
					alt6 = 1;
				}
				switch (alt6) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:118:130:
					// ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SAME_INDIVIDUAL"
	// $ANTLR start "DIFFERENT_INDIVIDUALS"
	public final void mDIFFERENT_INDIVIDUALS() throws RecognitionException {
		try {
			int _type = DIFFERENT_INDIVIDUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:122:2: (
			// ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'F' | 'f' ) ( 'E' |
			// 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) (
			// 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'V' | 'v'
			// ) ( 'I' | 'i' ) ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' |
			// 'l' ) ( 'S' | 's' ) ( ':' )? )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:122:4: (
			// 'D' | 'd' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'F' | 'f' ) ( 'E' | 'e'
			// ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'I' |
			// 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'V' | 'v' ) (
			// 'I' | 'i' ) ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l'
			// ) ( 'S' | 's' ) ( ':' )?
			{
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'F' || this.input.LA(1) == 'f') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'N' || this.input.LA(1) == 'n') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'V' || this.input.LA(1) == 'v') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'I' || this.input.LA(1) == 'i') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'D' || this.input.LA(1) == 'd') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:122:184:
				// ( ':' )?
				int alt7 = 2;
				int LA7_0 = this.input.LA(1);
				if (LA7_0 == ':') {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
					// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:122:184:
					// ':'
				{
					this.match(':');
				}
					break;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DIFFERENT_INDIVIDUALS"
	// $ANTLR start "SUPER_CLASS_OF"
	public final void mSUPER_CLASS_OF() throws RecognitionException {
		try {
			int _type = SUPER_CLASS_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:126:3: (
			// 'superClassOf' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:127:5:
			// 'superClassOf'
			{
				this.match("superClassOf");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUPER_CLASS_OF"
	// $ANTLR start "SUPER_PROPERTY_OF"
	public final void mSUPER_PROPERTY_OF() throws RecognitionException {
		try {
			int _type = SUPER_PROPERTY_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:131:3: (
			// 'superPropertyOf' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:132:5:
			// 'superPropertyOf'
			{
				this.match("superPropertyOf");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUPER_PROPERTY_OF"
	// $ANTLR start "MATCH"
	public final void mMATCH() throws RecognitionException {
		try {
			int _type = MATCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:136:3: (
			// 'MATCH' | 'Match' )
			int alt8 = 2;
			int LA8_0 = this.input.LA(1);
			if (LA8_0 == 'M') {
				int LA8_1 = this.input.LA(2);
				if (LA8_1 == 'A') {
					alt8 = 1;
				} else if (LA8_1 == 'a') {
					alt8 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 8, 1, this.input);
					throw nvae;
				}
			} else {
				NoViableAltException nvae = new NoViableAltException("", 8, 0, this.input);
				throw nvae;
			}
			switch (alt8) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:137:4:
				// 'MATCH'
			{
				this.match("MATCH");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:138:6:
				// 'Match'
			{
				this.match("Match");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MATCH"
	// $ANTLR start "FAIL"
	public final void mFAIL() throws RecognitionException {
		try {
			int _type = FAIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:142:2: (
			// 'FAIL' | 'fail' | 'Fail' )
			int alt9 = 3;
			int LA9_0 = this.input.LA(1);
			if (LA9_0 == 'F') {
				int LA9_1 = this.input.LA(2);
				if (LA9_1 == 'A') {
					alt9 = 1;
				} else if (LA9_1 == 'a') {
					alt9 = 3;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 9, 1, this.input);
					throw nvae;
				}
			} else if (LA9_0 == 'f') {
				alt9 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 9, 0, this.input);
				throw nvae;
			}
			switch (alt9) {
			case 1:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:143:3:
				// 'FAIL'
			{
				this.match("FAIL");
			}
				break;
			case 2:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:144:5:
				// 'fail'
			{
				this.match("fail");
			}
				break;
			case 3:
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:145:5:
				// 'Fail'
			{
				this.match("Fail");
			}
				break;
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FAIL"
	// $ANTLR start "SET"
	public final void mSET() throws RecognitionException {
		try {
			int _type = SET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:149:2: (
			// ( 'S' | 's' ) ( 'E' | 'e' ) ( 'T' | 't' ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:150:3: (
			// 'S' | 's' ) ( 'E' | 'e' ) ( 'T' | 't' )
			{
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SET"
	// $ANTLR start "VALUES"
	public final void mVALUES() throws RecognitionException {
		try {
			int _type = VALUES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:154:3: (
			// 'VALUES' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:155:5:
			// 'VALUES'
			{
				this.match("VALUES");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VALUES"
	// $ANTLR start "RENDERING"
	public final void mRENDERING() throws RecognitionException {
		try {
			int _type = RENDERING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:160:3: (
			// 'RENDERING' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:161:5:
			// 'RENDERING'
			{
				this.match("RENDERING");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RENDERING"
	// $ANTLR start "GROUPS"
	public final void mGROUPS() throws RecognitionException {
		try {
			int _type = GROUPS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:166:3: (
			// 'GROUPS' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:167:5:
			// 'GROUPS'
			{
				this.match("GROUPS");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GROUPS"
	// $ANTLR start "IRI_ATTRIBUTE_NAME"
	public final void mIRI_ATTRIBUTE_NAME() throws RecognitionException {
		try {
			int _type = IRI_ATTRIBUTE_NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:171:2: (
			// 'IRI' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:172:3:
			// 'IRI'
			{
				this.match("IRI");
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IRI_ATTRIBUTE_NAME"
	// $ANTLR start "QUESTION_MARK"
	public final void mQUESTION_MARK() throws RecognitionException {
		try {
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:177:3: (
			// '?' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:178:5:
			// '?'
			{
				this.match('?');
			}
		} finally {
		}
	}

	// $ANTLR end "QUESTION_MARK"
	// $ANTLR start "ESCLAMATION_MARK"
	public final void mESCLAMATION_MARK() throws RecognitionException {
		try {
			int _type = ESCLAMATION_MARK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:182:3: (
			// '!' )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:183:5:
			// '!'
			{
				this.match('!');
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ESCLAMATION_MARK"
	// $ANTLR start "VARIABLE_NAME"
	public final void mVARIABLE_NAME() throws RecognitionException {
		try {
			int _type = VARIABLE_NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:187:3: (
			// QUESTION_MARK LETTER ( LETTER | DIGIT | '-' | '_' )* )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:188:5:
			// QUESTION_MARK LETTER ( LETTER | DIGIT | '-' | '_' )*
			{
				this.mQUESTION_MARK();
				this.gMOWLLexer.mLETTER();
				// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:188:26:
				// ( LETTER | DIGIT | '-' | '_' )*
				loop10: do {
					int alt10 = 2;
					int LA10_0 = this.input.LA(1);
					if (LA10_0 == '-' || LA10_0 >= '0' && LA10_0 <= '9' || LA10_0 >= 'A'
							&& LA10_0 <= 'Z' || LA10_0 == '_' || LA10_0 >= 'a' && LA10_0 <= 'z') {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
						// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:
					{
						if (this.input.LA(1) == '-' || this.input.LA(1) >= '0'
								&& this.input.LA(1) <= '9' || this.input.LA(1) >= 'A'
								&& this.input.LA(1) <= 'Z' || this.input.LA(1) == '_'
								|| this.input.LA(1) >= 'a' && this.input.LA(1) <= 'z') {
							this.input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(null,
									this.input);
							this.recover(mse);
							throw mse;
						}
					}
						break;
					default:
						break loop10;
					}
				} while (true);
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VARIABLE_NAME"
	// $ANTLR start "TO_LOWER_CASE"
	public final void mTO_LOWER_CASE() throws RecognitionException {
		try {
			int _type = TO_LOWER_CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:192:4: (
			// ( 'T' | 't' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' |
			// 'w' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'A' | 'a' ) (
			// 'S' | 's' ) ( 'E' | 'e' ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:193:5: (
			// 'T' | 't' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w'
			// ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' |
			// 's' ) ( 'E' | 'e' )
			{
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'L' || this.input.LA(1) == 'l') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'W' || this.input.LA(1) == 'w') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TO_LOWER_CASE"
	// $ANTLR start "TO_UPPER_CASE"
	public final void mTO_UPPER_CASE() throws RecognitionException {
		try {
			int _type = TO_UPPER_CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:196:2: (
			// ( 'T' | 't' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'P' |
			// 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'A' | 'a' ) (
			// 'S' | 's' ) ( 'E' | 'e' ) )
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:197:2: (
			// 'T' | 't' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'P' | 'p'
			// ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' |
			// 's' ) ( 'E' | 'e' )
			{
				if (this.input.LA(1) == 'T' || this.input.LA(1) == 't') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'O' || this.input.LA(1) == 'o') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'U' || this.input.LA(1) == 'u') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'P' || this.input.LA(1) == 'p') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'P' || this.input.LA(1) == 'p') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'R' || this.input.LA(1) == 'r') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'C' || this.input.LA(1) == 'c') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'A' || this.input.LA(1) == 'a') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'S' || this.input.LA(1) == 's') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
				if (this.input.LA(1) == 'E' || this.input.LA(1) == 'e') {
					this.input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, this.input);
					this.recover(mse);
					throw mse;
				}
			}
			this.state.type = _type;
			this.state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TO_UPPER_CASE"
	@Override
	public void mTokens() throws RecognitionException {
		// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:8: (
		// VARIABLE_TYPE | ADD | REMOVE | WHERE | NOT_EQUAL | IN | SELECT |
		// ASSERTED | COLON | DOT | PLUS | CREATE | CREATE_INTERSECTION |
		// CREATE_DISJUNCTION | BEGIN | END | DISJOINT_CLASSES |
		// DISJOINT_PROPERTIES | SAME_INDIVIDUAL | DIFFERENT_INDIVIDUALS |
		// SUPER_CLASS_OF | SUPER_PROPERTY_OF | MATCH | FAIL | SET | VALUES |
		// RENDERING | GROUPS | IRI_ATTRIBUTE_NAME | ESCLAMATION_MARK |
		// VARIABLE_NAME | TO_LOWER_CASE | TO_UPPER_CASE | MOWLLexer. Tokens )
		int alt11 = 34;
		alt11 = this.dfa11.predict(this.input);
		switch (alt11) {
		case 1:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:10:
			// VARIABLE_TYPE
		{
			this.mVARIABLE_TYPE();
		}
			break;
		case 2:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:24:
			// ADD
		{
			this.mADD();
		}
			break;
		case 3:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:28:
			// REMOVE
		{
			this.mREMOVE();
		}
			break;
		case 4:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:35:
			// WHERE
		{
			this.mWHERE();
		}
			break;
		case 5:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:41:
			// NOT_EQUAL
		{
			this.mNOT_EQUAL();
		}
			break;
		case 6:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:51: IN
		{
			this.mIN();
		}
			break;
		case 7:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:54:
			// SELECT
		{
			this.mSELECT();
		}
			break;
		case 8:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:61:
			// ASSERTED
		{
			this.mASSERTED();
		}
			break;
		case 9:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:70:
			// COLON
		{
			this.mCOLON();
		}
			break;
		case 10:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:76:
			// DOT
		{
			this.mDOT();
		}
			break;
		case 11:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:80:
			// PLUS
		{
			this.mPLUS();
		}
			break;
		case 12:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:85:
			// CREATE
		{
			this.mCREATE();
		}
			break;
		case 13:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:92:
			// CREATE_INTERSECTION
		{
			this.mCREATE_INTERSECTION();
		}
			break;
		case 14:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:112:
			// CREATE_DISJUNCTION
		{
			this.mCREATE_DISJUNCTION();
		}
			break;
		case 15:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:131:
			// BEGIN
		{
			this.mBEGIN();
		}
			break;
		case 16:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:137:
			// END
		{
			this.mEND();
		}
			break;
		case 17:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:141:
			// DISJOINT_CLASSES
		{
			this.mDISJOINT_CLASSES();
		}
			break;
		case 18:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:158:
			// DISJOINT_PROPERTIES
		{
			this.mDISJOINT_PROPERTIES();
		}
			break;
		case 19:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:178:
			// SAME_INDIVIDUAL
		{
			this.mSAME_INDIVIDUAL();
		}
			break;
		case 20:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:194:
			// DIFFERENT_INDIVIDUALS
		{
			this.mDIFFERENT_INDIVIDUALS();
		}
			break;
		case 21:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:216:
			// SUPER_CLASS_OF
		{
			this.mSUPER_CLASS_OF();
		}
			break;
		case 22:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:231:
			// SUPER_PROPERTY_OF
		{
			this.mSUPER_PROPERTY_OF();
		}
			break;
		case 23:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:249:
			// MATCH
		{
			this.mMATCH();
		}
			break;
		case 24:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:255:
			// FAIL
		{
			this.mFAIL();
		}
			break;
		case 25:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:260:
			// SET
		{
			this.mSET();
		}
			break;
		case 26:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:264:
			// VALUES
		{
			this.mVALUES();
		}
			break;
		case 27:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:271:
			// RENDERING
		{
			this.mRENDERING();
		}
			break;
		case 28:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:281:
			// GROUPS
		{
			this.mGROUPS();
		}
			break;
		case 29:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:288:
			// IRI_ATTRIBUTE_NAME
		{
			this.mIRI_ATTRIBUTE_NAME();
		}
			break;
		case 30:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:307:
			// ESCLAMATION_MARK
		{
			this.mESCLAMATION_MARK();
		}
			break;
		case 31:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:324:
			// VARIABLE_NAME
		{
			this.mVARIABLE_NAME();
		}
			break;
		case 32:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:338:
			// TO_LOWER_CASE
		{
			this.mTO_LOWER_CASE();
		}
			break;
		case 33:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:352:
			// TO_UPPER_CASE
		{
			this.mTO_UPPER_CASE();
		}
			break;
		case 34:
			// /Users/luigi/Documents/workspace/Parsers/src/OPPLLexer.g:1:366:
			// MOWLLexer. Tokens
		{
			this.gMOWLLexer.mTokens();
		}
			break;
		}
	}

	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS = "\1\uffff\7\31\1\50\1\31\3\uffff\12\31\1\uffff\1\31\1\uffff\11\31"
			+ "\1\103\3\31\2\uffff\27\31\1\140\2\31\1\uffff\1\143\4\31\1\150\26"
			+ "\31\1\uffff\2\31\1\uffff\4\31\1\uffff\3\31\1\uffff\3\31\3\u008b"
			+ "\4\31\1\u0090\13\31\1\u009c\3\31\1\u00a0\1\31\2\u00a3\1\uffff\4"
			+ "\31\1\uffff\11\31\1\u00b2\1\31\1\uffff\1\u00b4\1\31\1\u00b8\1\uffff"
			+ "\2\31\1\uffff\1\u00bb\1\u00bc\14\31\1\uffff\1\31\1\uffff\3\31\1"
			+ "\uffff\2\31\2\uffff\2\31\1\u0090\7\31\1\u00d9\21\31\1\uffff\1\31"
			+ "\1\u00ec\17\31\1\u0090\1\uffff\10\31\1\u0104\10\31\1\u0104\2\31"
			+ "\1\u010f\1\u0110\1\31\1\uffff\1\31\1\u0090\6\31\1\u0119\1\31\2\uffff"
			+ "\10\31\1\uffff\2\31\1\u0090\4\31\1\u0129\3\31\1\u012f\3\31\1\uffff"
			+ "\1\u0129\1\31\1\u0134\1\31\1\u012f\1\uffff\4\31\1\uffff\5\31\1\u013f"
			+ "\1\u0140\1\31\1\u0090\1\u013f\2\uffff\1\u0140\1\31\1\u0144\1\uffff" + "\1\u0144";
	static final String DFA11_eofS = "\u0146\uffff";
	static final String DFA11_minS = "\1\11\1\114\1\102\1\101\1\104\1\116\1\105\1\110\1\75\1\101\3\uffff"
			+ "\1\162\1\105\1\116\1\111\3\101\1\141\1\101\1\122\1\uffff\1\117\1"
			+ "\uffff\1\101\1\116\1\145\1\112\1\124\1\106\1\116\1\104\1\123\1\55"
			+ "\1\111\1\115\1\105\2\uffff\1\114\1\115\1\124\1\145\1\107\1\104\1"
			+ "\160\1\124\1\164\1\111\2\151\1\114\1\117\1\114\2\123\1\141\1\105"
			+ "\1\101\1\112\1\106\1\117\1\55\1\105\1\111\1\uffff\1\55\1\117\1\104"
			+ "\1\122\1\105\1\55\1\105\1\141\1\111\1\73\1\145\1\103\1\143\1\114"
			+ "\2\154\2\125\1\117\1\120\1\123\1\124\1\164\1\103\1\120\1\117\1\105"
			+ "\1\124\1\uffff\1\122\1\126\1\uffff\1\126\2\105\1\103\1\uffff\1\111"
			+ "\1\164\1\116\1\uffff\1\162\1\110\1\150\3\55\1\105\1\120\1\127\1"
			+ "\120\1\55\1\101\1\145\1\124\1\122\1\111\1\122\1\101\1\124\1\111"
			+ "\1\105\1\122\1\55\1\124\1\116\1\145\1\55\1\103\2\55\1\uffff\2\123"
			+ "\2\105\1\uffff\1\116\1\111\1\120\1\117\1\116\1\105\1\124\1\105\1"
			+ "\104\1\55\1\111\1\uffff\1\55\1\104\1\55\1\uffff\1\154\1\162\1\uffff"
			+ "\2\55\2\122\1\124\2\156\1\122\1\120\1\124\1\116\1\111\1\104\1\125"
			+ "\1\uffff\1\116\1\uffff\1\111\2\156\1\uffff\1\141\1\157\2\uffff\2"
			+ "\103\1\55\1\164\1\151\1\117\1\105\1\103\1\124\1\117\1\55\1\101\1"
			+ "\107\1\126\1\164\1\151\1\163\1\160\2\101\1\145\1\157\1\120\1\122"
			+ "\1\114\1\122\1\111\1\116\1\uffff\1\114\1\55\1\111\1\145\1\157\1"
			+ "\163\1\145\2\123\1\162\1\156\1\105\1\124\1\101\1\117\1\116\1\120"
			+ "\1\55\1\uffff\1\104\1\162\1\156\1\117\1\162\2\105\1\163\1\55\1\122"
			+ "\1\131\1\123\1\120\1\104\1\122\1\125\1\163\1\55\1\146\1\164\2\55"
			+ "\1\145\1\uffff\1\124\1\55\1\123\1\105\1\111\1\117\1\101\1\145\1"
			+ "\55\1\171\2\uffff\1\143\1\131\1\105\1\122\1\126\1\120\1\114\1\143"
			+ "\1\uffff\1\117\1\164\1\55\1\123\1\124\1\111\1\105\1\55\1\164\1\146"
			+ "\1\151\1\55\1\111\1\104\1\122\1\uffff\1\55\1\151\1\55\1\157\1\55"
			+ "\1\uffff\1\105\1\125\1\124\1\157\1\uffff\1\156\1\123\1\101\1\131"
			+ "\1\156\2\55\1\114\2\55\2\uffff\1\55\1\123\1\55\1\uffff\1\55";
	static final String DFA11_maxS = "\1\175\1\162\1\102\1\151\1\123\1\122\1\105\1\110\1\75\1\145\3\uffff"
			+ "\1\162\1\105\1\116\1\151\1\165\3\141\1\101\1\122\1\uffff\1\157\1"
			+ "\uffff\1\101\1\116\1\145\1\112\1\124\1\163\1\116\1\104\1\123\1\172"
			+ "\1\111\1\116\1\105\2\uffff\1\164\1\155\1\164\1\145\1\107\1\104\1"
			+ "\160\1\124\1\164\1\111\2\151\1\114\1\117\1\165\2\123\1\141\1\105"
			+ "\1\101\1\152\1\146\1\117\1\172\1\105\1\111\1\uffff\1\172\1\117\1"
			+ "\104\1\122\1\105\1\172\1\145\1\141\1\111\1\73\1\145\1\103\1\143"
			+ "\1\114\2\154\2\125\1\157\1\160\1\123\1\124\1\164\1\103\1\120\1\157"
			+ "\1\145\1\124\1\uffff\1\122\1\126\1\uffff\1\126\2\105\1\103\1\uffff"
			+ "\1\151\1\164\1\116\1\uffff\1\162\1\110\1\150\3\172\1\105\1\120\1"
			+ "\167\1\160\1\172\1\101\1\145\1\124\1\122\1\151\1\162\1\101\1\124"
			+ "\1\111\1\105\1\122\1\172\1\124\1\156\1\145\1\172\1\120\2\172\1\uffff"
			+ "\2\123\2\145\1\uffff\1\116\1\125\1\120\1\117\1\156\1\145\1\124\1"
			+ "\105\1\104\1\172\1\111\1\uffff\1\172\1\144\1\172\1\uffff\1\154\1"
			+ "\162\1\uffff\2\172\2\162\1\124\2\156\1\122\1\120\1\164\1\156\1\111"
			+ "\1\104\1\125\1\uffff\1\116\1\uffff\1\151\2\156\1\uffff\1\141\1\157"
			+ "\2\uffff\2\143\1\172\1\164\1\151\1\117\1\105\1\160\1\164\1\117\1"
			+ "\172\1\101\1\107\1\166\1\164\1\151\1\163\1\160\2\141\1\145\1\157"
			+ "\1\120\1\122\1\154\1\162\1\151\1\116\1\uffff\1\114\1\172\1\151\1"
			+ "\145\1\157\1\163\1\145\2\163\1\162\1\156\1\105\1\124\1\141\1\157"
			+ "\1\156\1\120\1\172\1\uffff\1\144\1\162\1\156\1\117\1\162\2\145\1"
			+ "\163\1\172\1\122\1\131\1\163\1\160\1\144\1\122\1\165\1\163\1\172"
			+ "\1\146\1\164\2\172\1\145\1\uffff\1\124\1\172\1\163\1\145\1\151\1"
			+ "\117\1\141\1\145\1\172\1\171\2\uffff\1\143\1\131\1\145\1\162\1\166"
			+ "\1\120\1\154\1\143\1\uffff\1\117\1\164\1\172\1\163\1\164\1\151\1"
			+ "\105\1\172\1\164\1\146\1\151\1\172\1\151\1\144\1\122\1\uffff\1\172"
			+ "\1\151\1\172\1\157\1\172\1\uffff\1\145\1\165\1\124\1\157\1\uffff"
			+ "\1\156\1\163\1\141\1\131\1\156\2\172\1\154\2\172\2\uffff\1\172\1"
			+ "\163\1\172\1\uffff\1\172";
	static final String DFA11_acceptS = "\12\uffff\1\11\1\12\1\13\12\uffff\1\37\1\uffff\1\42\15\uffff\1\5"
			+ "\1\36\32\uffff\1\6\34\uffff\1\2\2\uffff\1\35\4\uffff\1\31\3\uffff"
			+ "\1\20\36\uffff\1\30\4\uffff\1\1\13\uffff\1\4\3\uffff\1\17\2\uffff"
			+ "\1\27\16\uffff\1\3\1\uffff\1\7\3\uffff\1\14\2\uffff\1\32\1\34\34"
			+ "\uffff\1\10\22\uffff\1\33\27\uffff\1\16\12\uffff\1\40\1\41\10\uffff"
			+ "\1\25\17\uffff\1\23\5\uffff\1\21\4\uffff\1\26\12\uffff\1\15\1\22"
			+ "\3\uffff\1\24\1\uffff";
	static final String DFA11_specialS = "\u0146\uffff}>";
	static final String[] DFA11_transitionS = {
			"\2\31\2\uffff\1\31\22\uffff\1\31\1\10\1\31\4\uffff\3\31\1\uffff"
					+ "\1\14\1\31\1\uffff\1\13\1\uffff\12\31\1\12\1\uffff\3\31\1\27"
					+ "\1\31\1\4\1\16\1\1\1\3\1\17\1\23\1\26\1\31\1\5\3\31\1\22\1\31"
					+ "\1\2\2\31\1\6\1\11\1\30\1\31\1\25\1\7\4\31\1\uffff\2\31\2\uffff"
					+ "\2\31\1\15\1\20\1\31\1\24\14\31\1\21\1\30\7\31\1\uffff\1\31",
			"\1\32\2\uffff\1\33\42\uffff\1\34",
			"\1\35",
			"\1\36\7\uffff\1\37\37\uffff\1\37",
			"\1\41\11\uffff\1\40\4\uffff\1\42",
			"\1\43\3\uffff\1\44",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\52\3\uffff\1\51\33\uffff\1\52\3\uffff\1\53",
			"",
			"",
			"",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\37\37\uffff\1\37",
			"\1\52\3\uffff\1\53\33\uffff\1\52\3\uffff\1\53\17\uffff\1\57",
			"\1\60\37\uffff\1\61",
			"\1\62\37\uffff\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"",
			"\1\67\37\uffff\1\67",
			"",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\76\14\uffff\1\75\22\uffff\1\76\14\uffff\1\75",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\31\2\uffff\13\31\6\uffff\3\31\1\102\26\31\4\uffff\1\31\1" + "\uffff\32\31",
			"\1\104",
			"\1\105\1\106",
			"\1\107",
			"",
			"",
			"\1\110\7\uffff\1\111\37\uffff\1\111",
			"\1\112\37\uffff\1\112",
			"\1\111\37\uffff\1\111",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126\10\uffff\1\127\26\uffff\1\126\10\uffff\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135\37\uffff\1\135",
			"\1\136\37\uffff\1\136",
			"\1\137",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\141",
			"\1\142",
			"",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\151\37\uffff\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\165\37\uffff\1\165",
			"\1\166\37\uffff\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\174\37\uffff\1\174",
			"\1\175\37\uffff\1\175",
			"\1\176",
			"",
			"\1\177",
			"\1\u0080",
			"",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"",
			"\1\u0085\37\uffff\1\u0085",
			"\1\u0086",
			"\1\u0087",
			"",
			"\1\u0088",
			"\1\u0089",
			"\1\u008a",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e\37\uffff\1\u008e",
			"\1\u008f\37\uffff\1\u008f",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0094",
			"\1\u0095\37\uffff\1\u0095",
			"\1\u0096\37\uffff\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u009d",
			"\1\u009e\37\uffff\1\u009e",
			"\1\u009f",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u00a1\14\uffff\1\u00a2",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6\37\uffff\1\u00a6",
			"\1\u00a7\37\uffff\1\u00a7",
			"",
			"\1\u00a8",
			"\1\u00a9\13\uffff\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\1\u00ad\37\uffff\1\u00ad",
			"\1\u00ae\37\uffff\1\u00ae",
			"\1\u00af",
			"\1\u00b0",
			"\1\u00b1",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u00b3",
			"",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u00b5\37\uffff\1\u00b5",
			"\1\31\2\uffff\13\31\6\uffff\10\31\1\u00b6\13\31\1\u00b7\5\31"
					+ "\4\uffff\1\31\1\uffff\32\31", "", "\1\u00b9", "\1\u00ba", "",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u00bd\37\uffff\1\u00bd", "\1\u00be\37\uffff\1\u00be", "\1\u00bf", "\1\u00c0",
			"\1\u00c1", "\1\u00c2", "\1\u00c3", "\1\u00c4\37\uffff\1\u00c4",
			"\1\u00c5\37\uffff\1\u00c5", "\1\u00c6", "\1\u00c7", "\1\u00c8", "", "\1\u00c9", "",
			"\1\u00ca\37\uffff\1\u00ca", "\1\u00cb", "\1\u00cc", "", "\1\u00cd", "\1\u00ce", "",
			"", "\1\u00cf\37\uffff\1\u00cf", "\1\u00d0\37\uffff\1\u00d0",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "\1\u00d1", "\1\u00d2",
			"\1\u00d3", "\1\u00d4", "\1\u00d5\14\uffff\1\u00d6\22\uffff\1\u00d5\14\uffff\1\u00d6",
			"\1\u00d7\37\uffff\1\u00d7", "\1\u00d8",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "\1\u00da", "\1\u00db",
			"\1\u00dc\37\uffff\1\u00dc", "\1\u00dd", "\1\u00de", "\1\u00df", "\1\u00e0",
			"\1\u00e1\37\uffff\1\u00e1", "\1\u00e2\37\uffff\1\u00e2", "\1\u00e3", "\1\u00e4",
			"\1\u00e5", "\1\u00e6", "\1\u00e7\37\uffff\1\u00e7", "\1\u00e8\37\uffff\1\u00e8",
			"\1\u00e9\37\uffff\1\u00e9", "\1\u00ea", "", "\1\u00eb",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u00ed\37\uffff\1\u00ed", "\1\u00ee", "\1\u00ef", "\1\u00f0", "\1\u00f1",
			"\1\u00f2\37\uffff\1\u00f2", "\1\u00f3\37\uffff\1\u00f3", "\1\u00f4", "\1\u00f5",
			"\1\u00f6", "\1\u00f7", "\1\u00f8\37\uffff\1\u00f8", "\1\u00f9\37\uffff\1\u00f9",
			"\1\u00fa\37\uffff\1\u00fa", "\1\u00fb",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "",
			"\1\u00fc\37\uffff\1\u00fc", "\1\u00fd", "\1\u00fe", "\1\u00ff", "\1\u0100",
			"\1\u0101\37\uffff\1\u0101", "\1\u0102\37\uffff\1\u0102", "\1\u0103",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "\1\u0105", "\1\u0106",
			"\1\u0107\37\uffff\1\u0107", "\1\u0108\37\uffff\1\u0108", "\1\u0109\37\uffff\1\u0109",
			"\1\u010a", "\1\u010b\37\uffff\1\u010b", "\1\u010c",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "\1\u010d", "\1\u010e",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "\1\u0111", "",
			"\1\u0112", "\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u0113\37\uffff\1\u0113", "\1\u0114\37\uffff\1\u0114", "\1\u0115\37\uffff\1\u0115",
			"\1\u0116", "\1\u0117\37\uffff\1\u0117", "\1\u0118",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "\1\u011a", "", "",
			"\1\u011b", "\1\u011c", "\1\u011d\37\uffff\1\u011d", "\1\u011e\37\uffff\1\u011e",
			"\1\u011f\37\uffff\1\u011f", "\1\u0120", "\1\u0121\37\uffff\1\u0121", "\1\u0122", "",
			"\1\u0123", "\1\u0124", "\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u0125\37\uffff\1\u0125", "\1\u0126\37\uffff\1\u0126", "\1\u0127\37\uffff\1\u0127",
			"\1\u0128",
			"\1\31\2\uffff\12\31\1\u012a\6\uffff\32\31\4\uffff\1\31\1\uffff" + "\32\31",
			"\1\u012b", "\1\u012c", "\1\u012d",
			"\1\31\2\uffff\12\31\1\u012e\6\uffff\32\31\4\uffff\1\31\1\uffff" + "\32\31",
			"\1\u0130\37\uffff\1\u0130", "\1\u0131\37\uffff\1\u0131", "\1\u0132", "",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "\1\u0133",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "\1\u0135",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "",
			"\1\u0136\37\uffff\1\u0136", "\1\u0137\37\uffff\1\u0137", "\1\u0138", "\1\u0139", "",
			"\1\u013a", "\1\u013b\37\uffff\1\u013b", "\1\u013c\37\uffff\1\u013c", "\1\u013d",
			"\1\u013e", "\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\31\2\uffff\12\31\1\u0141\6\uffff\32\31\4\uffff\1\31\1\uffff" + "\32\31",
			"\1\u0142\37\uffff\1\u0142",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31", "", "",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\u0143\37\uffff\1\u0143",
			"\1\31\2\uffff\12\31\1\u0145\6\uffff\32\31\4\uffff\1\31\1\uffff" + "\32\31", "",
			"\1\31\2\uffff\13\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31" };
	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
	static final short[][] DFA11_transition;
	static {
		int numStates = DFA11_transitionS.length;
		DFA11_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	class DFA11 extends DFA {
		public DFA11(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 11;
			this.eot = DFA11_eot;
			this.eof = DFA11_eof;
			this.min = DFA11_min;
			this.max = DFA11_max;
			this.accept = DFA11_accept;
			this.special = DFA11_special;
			this.transition = DFA11_transition;
		}

		@Override
		public String getDescription() {
			return "1:1: Tokens : ( VARIABLE_TYPE | ADD | REMOVE | WHERE | NOT_EQUAL | IN | SELECT | ASSERTED | COLON | DOT | PLUS | CREATE | CREATE_INTERSECTION | CREATE_DISJUNCTION | BEGIN | END | DISJOINT_CLASSES | DISJOINT_PROPERTIES | SAME_INDIVIDUAL | DIFFERENT_INDIVIDUALS | SUPER_CLASS_OF | SUPER_PROPERTY_OF | MATCH | FAIL | SET | VALUES | RENDERING | GROUPS | IRI_ATTRIBUTE_NAME | ESCLAMATION_MARK | VARIABLE_NAME | TO_LOWER_CASE | TO_UPPER_CASE | MOWLLexer. Tokens );";
		}
	}
}