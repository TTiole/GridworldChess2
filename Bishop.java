import java.util.List;
import java.util.ArrayList;

public class Bishop extends ChessPiece
{
  public Bishop(char c)
  {
    super(c);
  }
  
  public Location[] getLegalMoves()
  {
    //cPos: current position being analyzed sPos: starting position nPos: next position to be analyzed
    List<Location> legalMoves = new ArrayList<Location>(0);
    Location sPos = getLocation();
    for(int i = 1; i <= 4; i++)
    {
      switch(i) //NORTHEAST (1), SOUTHEAST (2), SOUTHWEST (3), NORTHWEST (4)
      {
        case 1:
          if(sPos.getAdjacentLocation(Location.NORTHEAST) == null)
            break;
          
          break;
        case 2:
          //code
          break;
        case 3:
          //code
          break;
        case 4:
          //code
          break;
      }
    }
    
    /*
     * This converts ArrayLists into Arrays so that
     * we can have arrays that will always be
     * the right size.
     */
    Location[] legalMovesArray = new Location[legalMoves.size()];
    legalMovesArray = legalMoves.toArray(legalMovesArray);
    return legalMovesArray;
  }
  
  public void copy(Location loc)
  {
    ChessRunner.add(loc, new Bishop(getColorType()))
  }
}
