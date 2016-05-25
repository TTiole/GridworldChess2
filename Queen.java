public class Queen extends ChessPiece
{
  public Queen(char c)
  {
  	super(c, 9);
  }
  
  public Location[] getLegalMoves(boolean check)
  {
        Location[] legalMoves = new Location[27];
        
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return legalMoves;
        	
        appendLinearMoves(legalMoves, 0, 45);
        
        return legalMovesArray;
  }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new Bishop(getColorType()));
  }
}
