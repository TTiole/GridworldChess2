import java.util.ArrayList;
import java.lang.Comparable;

public abstract class ChessPiece extends Actor implements Comparable
{
    private char colorType;
    protected static int value;

    public ChessPiece(char c)
    {
        colorType = c;
        value = 0;
    }

    public ChessPiece(char c, int v)
    {
        colorType = c;
        value = v;
    }
	
    public char getColorType()
    {
        return colorType;
    }
    
    public void swapTo(Location loc)
    {
    	if(getGrid().get(loc) != null)
    	{
    		ChessPiece C = (ChessPiece)(getGrid().get(loc));
    		Location loc0 = getLocation();
    		moveTo(C.getLocation());
    		ChessRunner.remove(loc);
    		ChessRunner.add(loc0, C);
    	}
    	else
    		moveTo(loc);
    }
    
    public void moveTo(Location loc)
    {
    	ChessPiece kingInQuestion;
    	boolean alreadyInCheck = false;
    	if(getColorType() == 'w')
    		kingInQuestion = getKing('w');
    	else
    		kingInQuestion = getKing('b')
    	
    	Location prevLoc = getLocation();
    	
    	if(kingInQuestion.isInCheck())
    		alreadyInCheck = true;
    	super.moveTo(Loc);
    	if(kingInQuestion.isInCheck())
    		super.moveTo(prevLoc);
    }
    
    public ChessPiece getKing(char c)
    {
    	if(c == 'w')
    	{
    		ChessPiece wK = null; //white king
    		ArrayList<Location> Locs = getLocations('w');
    		for (Location l : Locs)
    		{
    			wK = (ChessPiece)(getGrid().get(l));
    			if (wK instanceof King)
    				break;
    		}
    		return wK;
    	}
    	else
    	{
    		ChessPiece bK = null; //black king
    		ArrayList<Location> Locs = getLocations('b');
    		for (Location l : Locs)
    		{
    			bK = (ChessPiece)(getGrid().get(l));
    			if (bK instanceof King)
    				break;
    		}
    		return bK;
    	}
    }
    
    public boolean isLegal(Location loc)
    {
    	if(loc == null || !getGrid().isValid(loc))
    		return false;
    		
    	if(!loc.isOnBoard())
    		return false;

    	ChessPiece C = (ChessPiece)getGrid().get(loc);
    		
    	if(C != null && C.getColorType() == colorType)
    		return false;
    		
    	return true;
    }
    public ArrayList<Location> getLocations(char c)
    {
    	ArrayList<Location> Locs = getGrid().getOccupiedLocations();
    	for(Location l : Locs)
    	{
      	  ChessPiece C = (ChessPiece)(getGrid().get(l));
      	  if(C.getColorType() != c)
	    Locs.remove(l);
			}
			return Locs;
    }
    
    public int compareTo(Object obj)
    {
    	ChessPiece C = (ChessPiece)obj;
    	if(getClass().equals(C.getClass()))
    		return value - C.value;
    	else
    		return -1;
    }

    public abstract Location[] getLegalMoves();
    public abstract void copyTo(Location loc);
}
