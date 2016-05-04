import java.util.ArrayList;

public class King extends ChessPiece
{
  private boolean check;
  private char targetColor;
  private ArrayList<Location> oppositeLocs = new ArrayList<Location>();
  
  public King(char c)
  {
  	super(c);
    targetColor = 'w';
    if(c == 'w')
      targetColor = 'b';
  	check = false;
  }
  
  public boolean isInCheck()
  {
    oppositeLocs = getLocations(targetColor);
    System.out.println(oppositeLocs);
    for(Location L : oppositeLocs)
    {
      ChessPiece C = (ChessPiece)(getGrid().get(L));
      if(!(C instanceof King))
      {
        Location[] enemyLegal = C.getLegalMoves();
        for(Location L2 : enemyLegal)
          if(L2 != null && L2.equals(getLocation()))
            return true;
      }
    }
    return false;
  }
  
  public Location[] getLegalMoves()
  {
        //List<Location> legalMoves = new ArrayList<Location>(0);
        Location[] legalMovesArray = new Location[27];
        int i = 0;
        for(int d = 0; d < 360; d += 45)
        {
        	Location sPos = getLocation();
            sPos = sPos.getAdjacentLocation(d);
            if(isLegal(sPos))
            {
                legalMovesArray[i] = sPos;
                i++;
            }
        }
    
        /*
         * This converts ArrayLists into Arrays so that
         * we can have arrays that will always be
         * the right size.
         */
        //Location[] legalMovesArray = new Location[legalMoves.size()];
        //legalMovesArray = legalMoves.toArray(legalMovesArray);
        return legalMovesArray;
  }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new King(getColorType()));
  }
}
