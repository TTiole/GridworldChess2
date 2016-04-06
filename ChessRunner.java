public class ChessRunner
{
	private static ActorWorld world;
		
	public static void main(String[] args)
	{
        	world = new ActorWorld();
        	defaultSetup();
        	world.show();
    	}
    
    	public static void defaultSetup()
    	{
    		char[] colors = new char[2];
    		colors[0] = 'b';
    		colors[1] = 'w';
    		
    		for(int i = 0; i < 2; i++)
    		{
    			for(int j = 0; j < 8; j++)
    				world.add(new Location(6 - i*5, j), new Pawn(colors[1-i]));
        		
        		world.add(new Location(i*7, 0), new Rook(colors[i]));
        		world.add(new Location(i*7, 1), new Knight(colors[i]));
        		world.add(new Location(i*7, 2), new Bishop(colors[i]));
        		world.add(new Location(i*7, 3), new Queen(colors[i]));
        		world.add(new Location(i*7, 4), new King(colors[i]));
        		world.add(new Location(i*7, 5), new Bishop(colors[i]));
        		world.add(new Location(i*7, 6), new Knight(colors[i]));
        		world.add(new Location(i*7, 7), new Rook(colors[i]));
    		}
    	}
	
	public static void add(Location loc, ChessPiece occupant)
	{
		world.add(loc, occupant);
	}
}
