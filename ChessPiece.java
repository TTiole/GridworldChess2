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
