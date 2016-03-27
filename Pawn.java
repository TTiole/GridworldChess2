public class Pawn extends ChessPiece
{
  public Pawn(char c)
  {
  	super(c);
  }
  
  public Location[] getLegalMoves()
  {
  	return new Location[0];
  }
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Pawn(getColorType()))
  }
}
