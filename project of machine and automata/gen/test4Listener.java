// Generated from /Users/navid/Desktop/درس/project of machine and automata/test4.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link test4Parser}.
 */
public interface test4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link test4Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(test4Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link test4Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(test4Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link test4Parser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(test4Parser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link test4Parser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(test4Parser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link test4Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(test4Parser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link test4Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(test4Parser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link test4Parser#methodCallArguments}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallArguments(test4Parser.MethodCallArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link test4Parser#methodCallArguments}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallArguments(test4Parser.MethodCallArgumentsContext ctx);
}