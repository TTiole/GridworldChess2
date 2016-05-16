import java.util.List;
import java.util.ArrayList;

public class Rook extends ChessPiece
{
    private int moves;
    
    public Rook(char c)
    {
        super(c, 5);
        moves = 0;
    }

    public Location[] getLegalMoves(boolean check)
    {
        //List<Location> legalMoves = new ArrayList<Location>(0);
        Location[] legalMovesArray = new Location[14];
        
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return legalMovesArray;
        	
        int i = 0;
        for(int d = 0; d < 360; d += 90)
        {
            Location sPos = getLocation();
            while(isLegal(check, sPos) || sPos.equals(getLocation()))
            {
                if(isLegal(check, sPos))
                {
                    legalMovesArray[i] = sPos;
                    i++;
                    if(getGrid().get(sPos) != null)
                				break;
                }
                sPos = sPos.getAdjacentLocation(d);
            }
        }
        
    
        /*
         * This converts ArrayLists into Arrays so that
         * we can have arrays that will always be
         * the right size.
         */
        //Location[] legalMovesArray = new Location[legalMoves.size()];
        //legalMovesArray = legalMoves.toArray(legalMovesArray);
        return legalMovesArray;
    }
    
    public void cLaunched(boolean b) //True = Kingside castle, False = Queenside castle
    {
        if(b)
            moveTo(new Location(getLocation().getRow(), getLocation().getCol()+2));
        else
            moveTo(new Location(getLocation().getRow(), getLocation().getCol()-3));
    }
    
    public void moveTo(Location loc)
    {
        moves++;
        super.moveTo(loc);
    }
    
    public boolean canCastle()
    {
        return moves == 0;
    }
  
  	public void copyTo(Location loc)
  	{
  	  	ChessBoard.add(loc, new Bishop(getColorType()));
  	}
}
