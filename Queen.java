public class Queen extends ChessPiece
{
  public Queen(char c)
  {
  	super(c, 9);
  }
  
  public Location[] getLegalMoves()
  {
  	return new Location[0];
  }
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Bishop(getColorType()));
  }
}
