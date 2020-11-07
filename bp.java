import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree*;
import org.antlr.v4.runtime.CharStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class bp {
	public static void main(String[] args ) throw Excpetion
	{
	String inputFile = null;
	if (args.length > 0)
		inputfile = args[0]
	InputStream is = System.in;
	if (inputfile != null) is = new FileInputStream (inputFile);
	bpLexer lexer = new bpLexer (CharStream.fromStream (is));
	CommonTokenStream tokens = new CommonTokenStream (lexer);
	bpParser parser = new bpParser (token);
	ParseTree tree = parser.prog()

	EvalVisitor eval = new EvalVisitor ();
	eval.visit(tree);
	}
}