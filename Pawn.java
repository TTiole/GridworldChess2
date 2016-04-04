public class Pawn extends ChessPiece
{
  public Pawn(char c)
  {
  	super(c);
  	value = 1;
  }
  
  public Location[] getLegalMoves()
  {
  	Location[] legalMoves = new Location[4];
  	
  }
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Pawn(getColorType()));
  }
}
