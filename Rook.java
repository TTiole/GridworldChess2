import java.util.List;
import java.util.ArrayList;

public class Rook extends ChessPiece
{
    public Rook(char c)
    {
        super(c);
        value = 5;
    }

    public Location[] getLegalMoves()
    {
        //List<Location> legalMoves = new ArrayList<Location>(0);
        Location[] legalMovesArray = new Location[14];
        int i = 0;
        for(int d = 0; d < 360; d += 90)
        {
            Location loc = getLocation();
            while(isLegal(loc) || loc.equals(getLocation()))
            {
                if(isLegal(loc))
                {
                    legalMovesArray[i] = loc;
                    i++;
                    if(getGrid().get(loc) != null)
                				break;
                }
                loc = loc.getAdjacentLocation(d);
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
    ChessRunner.add(loc, new Rook(getColorType()));
  }
}
