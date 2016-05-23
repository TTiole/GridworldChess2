import java.util.ArrayList;
import java.lang.Comparable;
import java.awt.Color;

public abstract class ChessPiece extends Actor implements Comparable
{
    private char colorType;
    private int value;

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
    
  //This method returns any passed pawns next to the current pawn
  public Pawn getPassedPawn()
  {
  	ChessPiece passedEnP = null;
    for(int i = 0; i < 2; i++)
      if(getLocation().getAdjacentLocation(90 + 180*i).isOnBoard())
      {
        passedEnP = (ChessPiece)(getGrid().get(getLocation().getAdjacentLocation(90 + 180*i)));
        if(passedEnP instanceof Pawn && passedEnP.getColorType() != getColorType() && ((Pawn)(passedEnP)).isPassed())
          break;
        else
        	passedEnP = null;
      }
    return (Pawn)passedEnP;
  }
    public void moveTo(Location loc)
    {
    	if(getPassedPawn() != null && getPassedPawn().getColorType() != getColorType())
    		getPassedPawn().removeSelfFromGrid();
    		
    	ArrayList<Location> enemyLocs;
    	if(getColorType() == 'w')
    		enemyLocs = getLocations('b');
    	else
    		enemyLocs = getLocations('w');
    	
    	for(Location L : enemyLocs)
    		if(getGrid().get(L) instanceof Pawn)
    		{
    			Pawn pawn = (Pawn)(getGrid().get(L));
    			pawn.hasPassed();
    		}
    		
    	ChessPiece occupant = (ChessPiece)(getGrid().get(loc));
        if(occupant != null)
            StorageArea.takePiece((ChessPiece)occupant);
    		
    	super.moveTo(loc);
    }
    
    public void swapTo(Location loc)
    {
    	if(loc == getLocation())
    		return;
    	
    	if(getGrid().get(loc) != null)
    	{
    		ChessPiece C = (ChessPiece)(getGrid().get(loc));
    		//if(C.compareTo(this) == 0)
    		//	return;
    		
    		Location loc0 = getLocation();
    		super.moveTo(C.getLocation());
    		C.putSelfInGrid(getGrid(), loc0);
    	}
    	else
    		super.moveTo(loc);
    }
    
    //This method returns the king of the same color as ChessPiece
    public King getKing()
    {
    	for (Location loc : getLocations(getColorType()))
    	{
    		ChessPiece C = (ChessPiece)(getGrid().get(loc));
    		if (C instanceof King)
    			return (King)C;
    	}
    	return null;
    }
    
    //Check to see if the move at Location loc is legal. 
    //The boolean check serves as a way to end the infinite loop: isInCheck() -> getLegalMoves() -> isLegal() -> isInCheck()...
    public boolean isLegal(boolean check, Location loc)
    {
    	
    	if(loc == null || !getGrid().isValid(loc))
    		return false;
    		
    	if(!loc.isOnBoard())
    		return false;
    		
    	if(loc.equals(getLocation()) || !getLocation().isOnBoard())
    		return false;

    	ChessPiece C = (ChessPiece)getGrid().get(loc);
    	King king = getKing();
    	Location prevLoc = getLocation();
    	
    		
    	if(C != null && C.getColorType() == colorType)
    		return false;
    	
    	if(check)
    	{
	    	ChessPiece other = tryMove(loc);
	    	if(king.isInCheck())
	    	{
	    		super.moveTo(prevLoc);
	    		if(other != null)
	    			ChessBoard.add(loc, other);
	    		return false;
	    	}
	    	super.moveTo(prevLoc);
	    	if(other != null)
	    		ChessBoard.add(loc, other);
    	}
    		
    	return true;
    }
    
    public ChessPiece tryMove(Location loc)
    {
    	ChessPiece other = (ChessPiece)(getGrid().get(loc));
    	
    	super.moveTo(loc);
    	return other;
    }
    
    //This method returns the locations of all the pieces of color c
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
    
    public int getValue()
    {
    	return value;
    }
    
    public int compareTo(Object obj)
    {
    	ChessPiece C = (ChessPiece)obj;
    	
    	if(this instanceof Knight && obj instanceof Bishop)
    		return -1;
    	else if(obj instanceof Knight && this instanceof Bishop)
    		return 1;
    	else
    		return getValue() - C.getValue();
    }
    
    public Location[] getAttackingMoves(boolean check)
    {
    	return getLegalMoves(check);
    }
    
    public String toString()
    {
        return getClass().getName() + "[Location: " + getLocation() + ", colorType: " + getColorType()
        							+ ", value: " + getValue() + "]";
    }

    public abstract Location[] getLegalMoves(boolean check);
    public abstract void copyTo(Location loc);
}
