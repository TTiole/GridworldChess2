import java.util.List;
import java.util.ArrayList;

public class Bishop extends ChessPiece
{
  public Bishop(char c)
  {
    super(c, 3);
  }
  
  public Location[] getLegalMoves()
  {
    //cPos: current position being analyzed nPos: next position to be analyzed
    List<Location> legalMoves = new ArrayList<Location>(0);
    Location cPos = null;
    Location nPos = null;
    for(int i = 1; i <= 4; i++)
    {
      cPos = getLocation();
      switch(i) //NORTHEAST (1), SOUTHEAST (2), SOUTHWEST (3), NORTHWEST (4)
      {
        case 1:
          nPos = cPos.getAdjacentLocation(Location.NORTHEAST);
          if(isLegal(nPos) == true)
            legalMoves.add(nPos);
          cPos = nPos;
          break;
        case 2:
          nPos = cPos.getAdjacentLocation(Location.SOUTHEAST);
          if(isLegal(nPos) == true)
            legalMoves.add(nPos);
          cPos = nPos;
          break;
        case 3:
          nPos = cPos.getAdjacentLocation(Location.SOUTHWEST);
          if(isLegal(nPos) == true)
            legalMoves.add(nPos);
          cPos = nPos;
          break;
        case 4:
          nPos = cPos.getAdjacentLocation(Location.NORTHWEST);
          if(isLegal(nPos) == true)
            legalMoves.add(nPos);
          cPos = nPos;
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
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Bishop(getColorType()));
  }
}
