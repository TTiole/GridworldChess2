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
        
        appendLinearMoves(legalMoves, 45, 90);
        
        return legalMoves;
    }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new Bishop(getColorType()));
  }
}
