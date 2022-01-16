// Generated from BasicEvaluator.g4 by ANTLR 4.9.3
package BasicEvaluatorParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BasicEvaluatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BasicEvaluatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BasicEvaluatorParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(BasicEvaluatorParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionInput}
	 * labeled alternative in {@link BasicEvaluatorParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInput(BasicEvaluatorParser.ExpressionInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDefInput}
	 * labeled alternative in {@link BasicEvaluatorParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDefInput(BasicEvaluatorParser.FunDefInputContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicEvaluatorParser#funDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDef(BasicEvaluatorParser.FunDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicEvaluatorParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(BasicEvaluatorParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(BasicEvaluatorParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(BasicEvaluatorParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(BasicEvaluatorParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpr(BasicEvaluatorParser.WhileExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExpr(BasicEvaluatorParser.SetExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code beginExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginExpr(BasicEvaluatorParser.BeginExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operatorExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorExpr(BasicEvaluatorParser.OperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpr(BasicEvaluatorParser.FunctionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueOpExpr}
	 * labeled alternative in {@link BasicEvaluatorParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueOpExpr(BasicEvaluatorParser.ValueOpExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicEvaluatorParser#valueOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueOp(BasicEvaluatorParser.ValueOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicEvaluatorParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(BasicEvaluatorParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicEvaluatorParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(BasicEvaluatorParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicEvaluatorParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(BasicEvaluatorParser.ValueContext ctx);
}