import java.util.List;
import java.util.ArrayList;

public class Rook extends ChessPiece
{
    public Rook(char c)
    {
        super(c);
    }

    public Location[] getLegalMoves()
    {
        //List<Location> legalMoves = new ArrayList<Location>(0);
        Location[] legalMovesArray = new Location[14];
        int i = 0;
        for(int d = 0; d < 360; d += 90)
        {
            Location sPos = getLocation();
            while(isLegal(sPos) || sPos.equals(getLocation()))
            {
                sPos = sPos.getAdjacentLocation(d);
                if(isLegal(sPos))
                {
                    legalMovesArray[i] = sPos;
                    i++;
                }
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
}
