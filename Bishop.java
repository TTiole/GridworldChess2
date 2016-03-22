

public class Bishop extends ChessPiece
{
  public Bishop(boolean isWhite)
  {
    super(isWhite);
  }
  
  public abstract Location[] getLegalMoves()
  {
    Location[] legalMoves;
    int count = 0;
    int[] directions = {NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST};
    
  }
}
