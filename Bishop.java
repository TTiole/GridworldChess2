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
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return new Location[0];
        
        return getLinearMoves(13, 45, 90, check);
    }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new Bishop(getColorType()));
  }
}
