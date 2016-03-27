public class Queen extends ChessPiece
{
  public Queen(char c)
  {
  	super(c);
  }
  
  public Location[] getLegalMoves()
  {
  	return new Location[0];
  }
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Knight(getColorType()))
  }
}
