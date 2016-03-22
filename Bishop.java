

public class Bishop extends ChessPiece
{
  public Bishop(boolean isWhite)
  {
    super(isWhite);
  }
  
  public Location[] getLegalMoves()
  {
    Location[] legalMoves = new Location[13];
    int count = 0;
    int[] directions = {NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST};
    
  }
}
