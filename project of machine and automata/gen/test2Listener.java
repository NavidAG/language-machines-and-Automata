// Generated from /Users/navid/Desktop/درس/project of machine and automata/test2.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link test2Parser}.
 */
public interface test2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link test2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(test2Parser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link test2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(test2Parser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link test2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(test2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link test2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(test2Parser.ExprContext ctx);
}