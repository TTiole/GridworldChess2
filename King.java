import java.util.ArrayList;

public class King extends ChessPiece
{
  private boolean check;
  private ArrayList<Location> oppositeLocs;
  
  public King(char c)
  {
    char targetColor = 'w';
    if(c == 'w')
      targetColor = 'b';
    oppositeLocs = getLocations(targetColor);
  	check = false;
  	super(c);
  }
  
  public boolean isInCheck()
  {
    for(Location L : oppositeLocs)
    {
      ChessPiece C = (ChessPiece)(getGrid().get(L));
      Location[] enemyLegal = C.getLegalMoves();
      for(Location L2 : enemyLegal)
        if(enemyLegal[L2].equals(getLocation()))
          return true;
    }
    return false;
  }
  
  public Location[] getLegalMoves()
  {
  	return new Location[0];
  }
  
  public void copy(Location loc)
  {
    ChessRunner.add(loc, new King(getColorType()))
  }
}
