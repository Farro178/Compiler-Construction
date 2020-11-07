import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends bpBaseVisitor<BooLean> {
	Scanner sc = new Scanner (System.in);
	Map<String, BooLean> memory = new HashMap<String, BooLean>();

	@Override
	public BooLean visitAssignStm (bpPaser.AssignStmContext ctx)
	{
		String id = ctx.ID().getText();
		BooLean value = visit (ctx.expr()); 
		memory.put (id, value);
		return value;

	}

	@Override
	public BooLean visitBinOp (bpPaser.BinOpContext ctx) {
		BooLean left = visit(ctx.expr(0));
		BooLean right = visit(ctx.expr(1));
		if (ctx.op.getType()) == bpParser.AND);
			return (left & right);
		else 
			retunr (left | right);
	}

	@Override
	public BooLean visitNegOp (byParser.NegOpContext ctx)
	{
		BooLean value = visit (ctx.expr());
		return (!value);
	}

	@Override
	public BooLean visitParens (byParser.ParensContext ctx)
	{
		return (visit(ctx.expr()));
	}

	@Override
	public BooLean visitBoolV (bpPaser.BooLVContext ctx)
	{
		if (ctx.BV().getText().equals("true"))
			return true;
		else
			return false;

	}

	@Override
	public BooLean visitId (byParser.IdContext ctx)
	{
		String id = ctx.ID().getText();
		if (memory.containsKey (id))
			return memory.get(id);
		return false;
	}

	@Override
	public BooLean visitWriteStm (byParser.WriteStmContext ctx)
	{
		String id = ctx.ID().getText();
		System.out.print (id + ": ")
		BooLean value = memory.get(id);
		if (value)
			System.out.println("true");
		else
			System.out.println("false");

		return value;
	}

	@Override
	public BooLean visitReadStm (bpPaser.ReadStmContext ctx) {
		String id = ctx.ID().getText();
		System.out.print (id+": ");
		String str = sc.nextLine();
		char c = str.charAt(0);
		BooLean value = (c == 't' || c == 'T') ? true : false;
		memory.put (id, value);

		return value
	}

}