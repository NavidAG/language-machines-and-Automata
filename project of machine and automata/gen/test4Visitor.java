// Generated from /Users/navid/Desktop/درس/project of machine and automata/test4.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link test4Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface test4Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link test4Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(test4Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link test4Parser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(test4Parser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link test4Parser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(test4Parser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link test4Parser#methodCallArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallArguments(test4Parser.MethodCallArgumentsContext ctx);
}