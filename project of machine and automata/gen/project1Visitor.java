// Generated from /Users/navid/Desktop/درس/project of machine and automata/project1.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link project1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface project1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link project1Parser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(project1Parser.RContext ctx);
}