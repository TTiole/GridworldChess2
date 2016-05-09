import java.util.ArrayList;

public class ChessBoard
{
	private static ActorWorld world;
	private static Grid grid;
	
	public ChessBoard(Grid g, ActorWorld w)
	{
		grid = g;
		world = w;
	}
	
    public static void flipBoard()
    {
        for(int y = 0; y < 4; y++)
    	    for(int x = 0; x < 8; x++)
    	    {
    		    ChessPiece C;
    		    Location loc0 = new Location(y, x);
    		    Location loc1 = new Location(7-y, 7-x);
    		    if(grid.get(loc0) != null)
  			    {
    			    C = (ChessPiece)(grid.get(loc0));
    			    C.swapTo(loc1);
    		    }
    		    else if(grid.get(loc1) != null)
    		    {
    			    C = (ChessPiece)(grid.get(loc1));
    			    C.swapTo(loc0);
  			    }
    	    } 
    	    /*
    	ArrayList<Location> locs = new ArrayList<Location>();
    	for(int i = 0; i < grid.getOccupiedLocations().size(); i++)
    		locs.add((Location)(grid.getOccupiedLocations().get(i)));
    	
    	
    	
    	for(int i = 0; i < locs.size(); i++)
        {
            if(!(grid.get(locs.get(i)) instanceof ChessPiece))
            	i++;
            ChessPiece c = (ChessPiece)grid.get(locs.get(i));
            Location oldLoc = c.getLocation();
            Location newLoc = new Location(7 - oldLoc.getRow(), 7 - oldLoc.getCol());
            
            
            
            
            
            if(grid.get(newLoc) != null && grid.get(newLoc) instanceof ChessPiece)
            {
                locs.remove(newLoc);
                ChessPiece d = (ChessPiece)grid.get(newLoc);
                grid.put(newLoc, c);
                grid.put(oldLoc, d);
            }
            else
                grid.put(newLoc, c);
        } */
    }
    
	public static void customSetup()
	{
		clearAll();
		char[] colors = new char[2];
		colors[0] = 'b';
		colors[1] = 'w';
		
		for(int i = 0; i < 2; i++)
		{
    		world.add(new Location(0, 8 + 2*i), new King(colors[i]));
    		world.add(new Location(1, 8 + 2*i), new Queen(colors[i]));
    		world.add(new Location(2, 8 + 2*i), new Rook(colors[i]));
    		world.add(new Location(3, 8 + 2*i), new Bishop(colors[i]));
    		world.add(new Location(4, 8 + 2*i), new Knight(colors[i]));
			world.add(new Location(5, 8 + 2*i), new Pawn(colors[i]));
		}
	}
    
	public static void defaultSetup()
	{
		clearAll();
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
    		world.add(new Location(i*7, 3), new King(colors[i]));
    		world.add(new Location(i*7, 4), new Queen(colors[i]));
    		world.add(new Location(i*7, 5), new Bishop(colors[i]));
    		world.add(new Location(i*7, 6), new Knight(colors[i]));
    		world.add(new Location(i*7, 7), new Rook(colors[i]));
		}
	}
	
	public static void clearAll()
	{
		for(int y = 0; y < 8; y++)
			for(int x = 0; x < 12; x++)
				world.remove(new Location(y, x));
	}
	
	public static void remove(Location loc)
	{
		world.remove(loc);
	}
	
	public static void add(Location loc, ChessPiece occupant)
	{
		world.add(loc, occupant);
	}
}
