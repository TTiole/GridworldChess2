import java.util.List;
import java.util.ArrayList;

public class Bishop extends ChessPiece
{
  public Bishop(char c)
  {
    super(c, 3);
  }
  
  public List<Location> analyzeNextPos(List<Location> legalMoves, int dir, Location cPos, Location nPos)
  {
    while(cPos != null)
    {
      nPos = cPos.getAdjacentLocation(dir);
      if(isLegal(nPos) == true)
        legalMoves.add(nPos);
      cPos = nPos;
    }
    return legalMoves;
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
          analyzeNextPos(legalMoves, Location.NORTHEAST, cPos, nPos)
          break;
        case 2:
          analyzeNextPos(legalMoves, Location.SOUTHEAST, cPos, nPos)
          break;
        case 3:
          analyzeNextPos(legalMoves, Location.SOUTHWEST, cPos, nPos)
          break;
        case 4:
          analyzeNextPos(legalMoves, Location.NORTHWEST, cPos, nPos)
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
