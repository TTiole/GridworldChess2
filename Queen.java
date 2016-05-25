public class Queen extends ChessPiece
{
  public Queen(char c)
  {
  	super(c, 9);
  }
  
  public Location[] getLegalMoves(boolean check)
  {
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return new Location[0];
        
        return getLinearMoves(27, 0, 45, check);
  }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new Bishop(getColorType()));
  }
}
