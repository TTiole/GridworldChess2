public class ChessRunner
{
	private static ActorWorld world;
	private static Grid grid;
		
	public static void main(String[] args)
	{
		world = new ActorWorld();
        grid = world.getGrid();
        ChessBoard CB = new ChessBoard(grid, world);
        ChessBoard.defaultSetup();
        world.show();
    }
}
