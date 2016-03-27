public class Knight extends ChessPiece
{
  public Knight(char c)
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
