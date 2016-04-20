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
    
    public void moveTo(Location loc)
    {
    	King king = getKing();
    	Location prevLoc = getLocation();
    	boolean alreadyInCheck = false;
    	
    	if(king != null && king.isInCheck())
    		alreadyInCheck = true;
    	
    	super.moveTo(loc);
    	if(king.isInCheck())
    		super.moveTo(prevLoc);
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
    
    public King getKing()
    {
    	for (Location loc : getLocations(getColorType()))
    	{
    		ChessPiece C = (ChessPiece)(getGrid().get(loc));
    		if (C instanceof King)
    			return (King)C;
    	}
    	System.out.println("KING NOT FOUND: " + getColorType());
    	return null;
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
    	for(int i = 0; i < Locs.size(); i++)
    	{
      	  	ChessPiece C = (ChessPiece)(getGrid().get(Locs.get(i)));
      	  	if(C.getColorType() != c)
      	  	{
	    		Locs.remove(i);
	    		i--;
      	  	}
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
    
    public String toString()
    {
        return getClass().getName() + "[" + getLocation() + ", " + getColorType() + "]";
    }

    public abstract Location[] getLegalMoves();
    public abstract void copyTo(Location loc);
}