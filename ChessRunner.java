public class ChessRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
        Grid grid = world.getGrid();
        ChessBoard CB = new ChessBoard(grid, world);
        ChessBoard.defaultSetup();
        world.show();
    }
}
