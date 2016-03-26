import java.util.HashMap;
import java.util.ArrayList;

public class ChessRunner
{
	private static ActorWorld world;
	private static ArrayList<HashMap> history;
		
	public static void main(String[] args)
	{
        world = new ActorWorld();
       	history = new ArrayList<HashMap>();
       	defaultSetup();
       	world.show();
	}
	
	public static void setState(int k)
	{
		for(Location loc : history.get(k).keySet())
			world.add(loc, history.get(k).get(loc));
	}
	
	public static void recordState(Grid grid)
	{
		HashMap<Location, ChessPiece> places = new HashMap<Location, ChessPiece>(1);
		for(Location loc : grid.getOccupiedLocations())
			places.put(loc, (ChessPiece)(grid.get(loc))
		history.add(0, places);
	}
	
	public static ArrayList getHistory()
	{
		return history;
	}
    
    	public static void defaultSetup()
    	{
    		char[] colors = new char[2];
    		colors[0] = 'b';
    		colors[1] = 'w';
    		
    		for(int i = 0; i < colors.length; i++)
    		{
    			for(int j = 0; j < 8; j++)
    				world.add(new Location(6 - i*5, j), new Pawn(colors[i]));
        		
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
}
