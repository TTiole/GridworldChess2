

public class Bishop extends ChessPiece
{
  private location = super.getLocation();
  
  public Bishop(boolean isWhite)
  {
    super(isWhite);
  }
  
  public abstract Location[] getLegalMoves()
  {
    Location[13] legalMoves;
    int count = 0;
    int[4] directions = {NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST};
    
  }
}
