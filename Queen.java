public class Queen extends ChessPiece
{
  public Queen(char c)
  {
  	super(c);
  	value = 10;
  }
  
  public Location[] getLegalMoves()
  {
  	return new Location[0];
  }
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Queen(getColorType()));
  }
}
