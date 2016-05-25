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
        Location[] legalMovesArray = new Location[14];
        
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return legalMovesArray;
        	
        int i = 0;
        for(int d = 0; d < 360; d += 90)
        {
            Location sPos = getLocation();
            while((loc != null && loc.isOnBoard()) || sPos.equals(getLocation()))
            {
                if(loc != null && loc.isOnBoard())
                {
                    ChessPiece C = (ChessPiece)(getGrid().get(sPos));
                    if(C != null)
                    {
                      if(isLegal(check, sPos))
                        legalMoves[i] = sPos;
                      break;
                    }
                    else if(isLegal(check, sPos))
                      legalMoves[i] = sPos;
                    i++;
                }
                sPos = sPos.getAdjacentLocation(d);
            }
        }
        return legalMovesArray;
    }
    
    public void cLaunched(boolean left, int dl, int dr) //True = Kingside castle, False = Queenside castle
    {
        if(left)
            moveTo(new Location(getLocation().getRow(), getLocation().getCol() - dl - 1));
        else
            moveTo(new Location(getLocation().getRow(), getLocation().getCol() - dr + 1));
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
