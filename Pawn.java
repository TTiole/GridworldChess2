public class Pawn extends ChessPiece
{
  private boolean isPassed;
  private boolean canPass;
  public Pawn(char c)
  {
  	super(c, 1);
  }
  
  public Location[] getLegalMoves()
  {
  	return new Location[4];
  }
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Bishop(getColorType()));
  }
}
