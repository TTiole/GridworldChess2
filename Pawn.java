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
}
