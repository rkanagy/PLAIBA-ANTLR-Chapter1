// Generated from BasicEvaluator.g4 by ANTLR 4.9.3
package BasicEvaluatorParser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicEvaluatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, SUB=2, MUL=3, DIV=4, EQ=5, LT=6, GT=7, PRINT=8, LPAREN=9, RPAREN=10, 
		DEFINE=11, IF=12, WHILE=13, SET=14, BEGIN=15, INTEGER=16, NAME=17, COMMENT=18, 
		WS=19;
	public static final int
		RULE_prog = 0, RULE_input = 1, RULE_funDef = 2, RULE_argList = 3, RULE_expression = 4, 
		RULE_operator = 5, RULE_valueOp = 6, RULE_function = 7, RULE_variable = 8, 
		RULE_value = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "input", "funDef", "argList", "expression", "operator", "valueOp", 
			"function", "variable", "value"
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

	@Override
	public String getGrammarFileName() { return "BasicEvaluator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicEvaluatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<InputContext> input() {
			return getRuleContexts(InputContext.class);
		}
		public InputContext input(int i) {
			return getRuleContext(InputContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				input();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << INTEGER) | (1L << NAME))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunDefInputContext extends InputContext {
		public FunDefContext funDef() {
			return getRuleContext(FunDefContext.class,0);
		}
		public FunDefInputContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitFunDefInput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionInputContext extends InputContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionInputContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitExpressionInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_input);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ExpressionInputContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				expression();
				}
				break;
			case 2:
				_localctx = new FunDefInputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				funDef();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunDefContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BasicEvaluatorParser.LPAREN, 0); }
		public TerminalNode DEFINE() { return getToken(BasicEvaluatorParser.DEFINE, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicEvaluatorParser.RPAREN, 0); }
		public FunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitFunDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDefContext funDef() throws RecognitionException {
		FunDefContext _localctx = new FunDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(LPAREN);
			setState(30);
			match(DEFINE);
			setState(31);
			function();
			setState(32);
			argList();
			setState(33);
			expression();
			setState(34);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BasicEvaluatorParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BasicEvaluatorParser.RPAREN, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(LPAREN);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(37);
				variable();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableExprContext extends ExpressionContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitVariableExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExprContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(BasicEvaluatorParser.LPAREN, 0); }
		public TerminalNode WHILE() { return getToken(BasicEvaluatorParser.WHILE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BasicEvaluatorParser.RPAREN, 0); }
		public WhileExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitWhileExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OperatorExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(BasicEvaluatorParser.LPAREN, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicEvaluatorParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OperatorExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(BasicEvaluatorParser.LPAREN, 0); }
		public TerminalNode IF() { return getToken(BasicEvaluatorParser.IF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BasicEvaluatorParser.RPAREN, 0); }
		public IfExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BeginExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(BasicEvaluatorParser.LPAREN, 0); }
		public TerminalNode BEGIN() { return getToken(BasicEvaluatorParser.BEGIN, 0); }
		public TerminalNode RPAREN() { return getToken(BasicEvaluatorParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BeginExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitBeginExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(BasicEvaluatorParser.LPAREN, 0); }
		public TerminalNode SET() { return getToken(BasicEvaluatorParser.SET, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicEvaluatorParser.RPAREN, 0); }
		public SetExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitSetExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new ValueExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				value();
				}
				break;
			case 2:
				_localctx = new VariableExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				variable();
				}
				break;
			case 3:
				_localctx = new IfExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(LPAREN);
				setState(48);
				match(IF);
				setState(49);
				expression();
				setState(50);
				expression();
				setState(51);
				expression();
				setState(52);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new WhileExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				match(LPAREN);
				setState(55);
				match(WHILE);
				setState(56);
				expression();
				setState(57);
				expression();
				setState(58);
				match(RPAREN);
				}
				break;
			case 5:
				_localctx = new SetExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				match(LPAREN);
				setState(61);
				match(SET);
				setState(62);
				variable();
				setState(63);
				expression();
				setState(64);
				match(RPAREN);
				}
				break;
			case 6:
				_localctx = new BeginExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(66);
				match(LPAREN);
				setState(67);
				match(BEGIN);
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(68);
					expression();
					}
					}
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << INTEGER) | (1L << NAME))) != 0) );
				setState(73);
				match(RPAREN);
				}
				break;
			case 7:
				_localctx = new OperatorExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(75);
				match(LPAREN);
				setState(76);
				operator();
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << INTEGER) | (1L << NAME))) != 0)) {
					{
					{
					setState(77);
					expression();
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	 
		public OperatorContext() { }
		public void copyFrom(OperatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueOpExprContext extends OperatorContext {
		public ValueOpContext valueOp() {
			return getRuleContext(ValueOpContext.class,0);
		}
		public ValueOpExprContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitValueOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionExprContext extends OperatorContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionExprContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitFunctionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operator);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				_localctx = new FunctionExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				function();
				}
				break;
			case ADD:
			case SUB:
			case MUL:
			case DIV:
			case EQ:
			case LT:
			case GT:
			case PRINT:
				_localctx = new ValueOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				valueOp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueOpContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(BasicEvaluatorParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(BasicEvaluatorParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(BasicEvaluatorParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(BasicEvaluatorParser.DIV, 0); }
		public TerminalNode EQ() { return getToken(BasicEvaluatorParser.EQ, 0); }
		public TerminalNode LT() { return getToken(BasicEvaluatorParser.LT, 0); }
		public TerminalNode GT() { return getToken(BasicEvaluatorParser.GT, 0); }
		public TerminalNode PRINT() { return getToken(BasicEvaluatorParser.PRINT, 0); }
		public ValueOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitValueOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueOpContext valueOp() throws RecognitionException {
		ValueOpContext _localctx = new ValueOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_valueOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << EQ) | (1L << LT) | (1L << GT) | (1L << PRINT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BasicEvaluatorParser.NAME, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BasicEvaluatorParser.NAME, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(BasicEvaluatorParser.INTEGER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicEvaluatorVisitor ) return ((BasicEvaluatorVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25f\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\6\2\30\n\2\r\2\16\2\31\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\7\5)\n\5\f\5\16\5,\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6"+
		"\6H\n\6\r\6\16\6I\3\6\3\6\3\6\3\6\3\6\7\6Q\n\6\f\6\16\6T\13\6\3\6\3\6"+
		"\5\6X\n\6\3\7\3\7\5\7\\\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\2\2"+
		"\f\2\4\6\b\n\f\16\20\22\24\2\3\3\2\3\n\2g\2\27\3\2\2\2\4\35\3\2\2\2\6"+
		"\37\3\2\2\2\b&\3\2\2\2\nW\3\2\2\2\f[\3\2\2\2\16]\3\2\2\2\20_\3\2\2\2\22"+
		"a\3\2\2\2\24c\3\2\2\2\26\30\5\4\3\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27"+
		"\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\36\5\n\6\2\34\36\5\6\4\2\35\33"+
		"\3\2\2\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \7\13\2\2 !\7\r\2\2!\"\5\20\t\2"+
		"\"#\5\b\5\2#$\5\n\6\2$%\7\f\2\2%\7\3\2\2\2&*\7\13\2\2\')\5\22\n\2(\'\3"+
		"\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\f\2\2.\t"+
		"\3\2\2\2/X\5\24\13\2\60X\5\22\n\2\61\62\7\13\2\2\62\63\7\16\2\2\63\64"+
		"\5\n\6\2\64\65\5\n\6\2\65\66\5\n\6\2\66\67\7\f\2\2\67X\3\2\2\289\7\13"+
		"\2\29:\7\17\2\2:;\5\n\6\2;<\5\n\6\2<=\7\f\2\2=X\3\2\2\2>?\7\13\2\2?@\7"+
		"\20\2\2@A\5\22\n\2AB\5\n\6\2BC\7\f\2\2CX\3\2\2\2DE\7\13\2\2EG\7\21\2\2"+
		"FH\5\n\6\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\f\2\2"+
		"LX\3\2\2\2MN\7\13\2\2NR\5\f\7\2OQ\5\n\6\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2"+
		"\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7\f\2\2VX\3\2\2\2W/\3\2\2\2W\60\3\2"+
		"\2\2W\61\3\2\2\2W8\3\2\2\2W>\3\2\2\2WD\3\2\2\2WM\3\2\2\2X\13\3\2\2\2Y"+
		"\\\5\20\t\2Z\\\5\16\b\2[Y\3\2\2\2[Z\3\2\2\2\\\r\3\2\2\2]^\t\2\2\2^\17"+
		"\3\2\2\2_`\7\23\2\2`\21\3\2\2\2ab\7\23\2\2b\23\3\2\2\2cd\7\22\2\2d\25"+
		"\3\2\2\2\t\31\35*IRW[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}