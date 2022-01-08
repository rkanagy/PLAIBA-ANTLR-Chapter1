// Generated from BasicEvaluator.g4 by ANTLR 4.9.3
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
		DEFINE=11, IF=12, WHILE=13, SET=14, BEGIN=15, INTEGER=16, NAME=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ADD", "SUB", "MUL", "DIV", "EQ", "LT", "GT", "PRINT", "LPAREN", "RPAREN", 
			"DEFINE", "IF", "WHILE", "SET", "BEGIN", "INTEGER", "NAME", "WS"
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
			"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24m\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\5\21[\n\21\3\21\6\21^\n\21\r\21\16\21_\3\22\6"+
		"\22c\n\22\r\22\16\22d\3\23\6\23h\n\23\r\23\16\23i\3\23\3\23\2\2\24\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\3\2\6\3\2//\3\2\62;\7\2\13\f\17\17\"\"*+==\5\2\13\f\17\17"+
		"\"\"\2p\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13"+
		"/\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2\23;\3\2\2\2\25=\3\2"+
		"\2\2\27?\3\2\2\2\31F\3\2\2\2\33I\3\2\2\2\35O\3\2\2\2\37S\3\2\2\2!Z\3\2"+
		"\2\2#b\3\2\2\2%g\3\2\2\2\'(\7-\2\2(\4\3\2\2\2)*\7/\2\2*\6\3\2\2\2+,\7"+
		",\2\2,\b\3\2\2\2-.\7\61\2\2.\n\3\2\2\2/\60\7?\2\2\60\f\3\2\2\2\61\62\7"+
		">\2\2\62\16\3\2\2\2\63\64\7@\2\2\64\20\3\2\2\2\65\66\7r\2\2\66\67\7t\2"+
		"\2\678\7k\2\289\7p\2\29:\7v\2\2:\22\3\2\2\2;<\7*\2\2<\24\3\2\2\2=>\7+"+
		"\2\2>\26\3\2\2\2?@\7f\2\2@A\7g\2\2AB\7h\2\2BC\7k\2\2CD\7p\2\2DE\7g\2\2"+
		"E\30\3\2\2\2FG\7k\2\2GH\7h\2\2H\32\3\2\2\2IJ\7y\2\2JK\7j\2\2KL\7k\2\2"+
		"LM\7n\2\2MN\7g\2\2N\34\3\2\2\2OP\7u\2\2PQ\7g\2\2QR\7v\2\2R\36\3\2\2\2"+
		"ST\7d\2\2TU\7g\2\2UV\7i\2\2VW\7k\2\2WX\7p\2\2X \3\2\2\2Y[\t\2\2\2ZY\3"+
		"\2\2\2Z[\3\2\2\2[]\3\2\2\2\\^\t\3\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_"+
		"`\3\2\2\2`\"\3\2\2\2ac\n\4\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2"+
		"e$\3\2\2\2fh\t\5\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2"+
		"kl\b\23\2\2l&\3\2\2\2\7\2Z_di\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}