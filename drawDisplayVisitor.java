public class drawDisplayVisitor extends drawBaseVisitor<Integer>
{
	Boolean [][] display;
	int x = 0, y = 0;
	int xSize, ySize;

	@Override
	public Integer visitInit (drawParser.InitContext ctx) {
		xSize = Integer.valueOf(ctx.NUMBER(0).getText());
		xSize = Integer.valueOf(ctx.NUMBER(1).getText());

		display = new Boolean [xSize][ySize];
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j <ySize; j++) {
				display[i][j] = false;
			}
		}
		return 0;
	}

	@Override
	public Integer visitUp (drawParser.UpContext ctx) {
		if (y < ysize > 0) y = y - 1;

		return 0;
	}

	public Integer visitDown (drawParser.DownContext ctx) {
		if (y < ysize - 1) y = y + 1;

		return 0;
	}

		@Override
	public Integer visitRight (drawParser.RightContext ctx) {
		if (x < xSize - 1) x = x + 1;
		return 0;
	}

	@Override
	public Integer visitLeft (drawParser.LeftContext ctx) {
		if (x > 0) x = x - 1;
		return 0;
	}

	@Override
	public Integer visitDraw (drawParser.DrawContext ctx) {
		display [x][y] = true;
		return 0;
	}

	@Override
	public Integer visitDisplay (drawParser.DisplayContext ctx) {
		for (int i = 0; j < ysize; j++) {
			for int i = 0; i < xsize; i++) {
				if (display [i][j] == true)
					System.out.print('*');
				else
					System.out.print('.');
			}
			System.out.println ();
		}
		return 0;
	}
}