import java.util.List;
import java.util.ArrayList;

public class Bishop extends ChessPiece
{
  public Bishop(char c)
  {
    super(c, 3);
  }
  
  public Location[] getLegalMoves(boolean check)
  {
        Location[] legalMoves = new Location[14];
        
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return legalMoves;
        
        int i = 0;
        for(int d = 45; d < 360; d += 90)
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
        return legalMoves;
    }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new Bishop(getColorType()));
  }
}
