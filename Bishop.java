import java.util.List;
import java.util.ArrayList;

public class Bishop extends ChessPiece
{
  public Bishop(char c)
  {
    super(c);
    value = 3;
  }
  
  public Location[] getLegalMoves()
  {
    //cPos: current position being analyzed nPos: next position to be analyzed
    List<Location> legalMoves = new ArrayList<Location>(0);
    Location cPos = getLocation();
    Location nPos;
    for(int i = 1; i <= 4; i++)
    {
      switch(i) //NORTHEAST (1), SOUTHEAST (2), SOUTHWEST (3), NORTHWEST (4)
      {
        case 1:
          while(cPos != null)
            nPos = cPos.getAdjacentLocation(Location.NORTHEAST);
            ChessPiece adjPiece = getGrid().get(nPos);
            if(getColorType() == adjPiece.getColorType())
              break;
            legalMoves.add(nPos);
            cPos = nPos;
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
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Bishop(getColorType()));
  }
}
