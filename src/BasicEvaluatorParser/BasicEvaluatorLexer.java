// Generated from BasicEvaluator.g4 by ANTLR 4.9.3
package BasicEvaluatorParser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicEvaluatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, SUB=2, MUL=3, DIV=4, EQ=5, LT=6, GT=7, PRINT=8, LPAREN=9, RPAREN=10, 
		DEFINE=11, IF=12, WHILE=13, SET=14, BEGIN=15, INTEGER=16, NAME=17, COMMENT=18, 
		WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ADD", "SUB", "MUL", "DIV", "EQ", "LT", "GT", "PRINT", "LPAREN", "RPAREN", 
			"DEFINE", "IF", "WHILE", "SET", "BEGIN", "INTEGER", "NAME", "COMMENT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'='", "'<'", "'>'", "'print'", "'('", 
			"')'", "'define'", "'if'", "'while'", "'set'", "'begin'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "SUB", "MUL", "DIV", "EQ", "LT", "GT", "PRINT", "LPAREN", 
			"RPAREN", "DEFINE", "IF", "WHILE", "SET", "BEGIN", "INTEGER", "NAME", 
			"COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public BasicEvaluatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicEvaluator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25x\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\5\21]\n\21\3\21\6\21`\n\21\r\21\16\21"+
		"a\3\22\6\22e\n\22\r\22\16\22f\3\23\3\23\7\23k\n\23\f\23\16\23n\13\23\3"+
		"\23\3\23\3\24\6\24s\n\24\r\24\16\24t\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25\3\2\7\3\2//\3\2\62;\7\2\13\f\17\17\"\"*+==\4\2\f\f\17\17\5\2\13"+
		"\f\17\17\"\"\2|\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3\2"+
		"\2\2\t/\3\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\17\65\3\2\2\2\21\67\3\2\2\2"+
		"\23=\3\2\2\2\25?\3\2\2\2\27A\3\2\2\2\31H\3\2\2\2\33K\3\2\2\2\35Q\3\2\2"+
		"\2\37U\3\2\2\2!\\\3\2\2\2#d\3\2\2\2%h\3\2\2\2\'r\3\2\2\2)*\7-\2\2*\4\3"+
		"\2\2\2+,\7/\2\2,\6\3\2\2\2-.\7,\2\2.\b\3\2\2\2/\60\7\61\2\2\60\n\3\2\2"+
		"\2\61\62\7?\2\2\62\f\3\2\2\2\63\64\7>\2\2\64\16\3\2\2\2\65\66\7@\2\2\66"+
		"\20\3\2\2\2\678\7r\2\289\7t\2\29:\7k\2\2:;\7p\2\2;<\7v\2\2<\22\3\2\2\2"+
		"=>\7*\2\2>\24\3\2\2\2?@\7+\2\2@\26\3\2\2\2AB\7f\2\2BC\7g\2\2CD\7h\2\2"+
		"DE\7k\2\2EF\7p\2\2FG\7g\2\2G\30\3\2\2\2HI\7k\2\2IJ\7h\2\2J\32\3\2\2\2"+
		"KL\7y\2\2LM\7j\2\2MN\7k\2\2NO\7n\2\2OP\7g\2\2P\34\3\2\2\2QR\7u\2\2RS\7"+
		"g\2\2ST\7v\2\2T\36\3\2\2\2UV\7d\2\2VW\7g\2\2WX\7i\2\2XY\7k\2\2YZ\7p\2"+
		"\2Z \3\2\2\2[]\t\2\2\2\\[\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^`\t\3\2\2_^\3\2"+
		"\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\"\3\2\2\2ce\n\4\2\2dc\3\2\2\2ef\3"+
		"\2\2\2fd\3\2\2\2fg\3\2\2\2g$\3\2\2\2hl\7=\2\2ik\n\5\2\2ji\3\2\2\2kn\3"+
		"\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\b\23\2\2p&\3\2\2\2qs"+
		"\t\6\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\b\24\2\2"+
		"w(\3\2\2\2\b\2\\aflt\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}