public class Knight extends ChessPiece
{
  public Knight(char c)
  {
  	super(c);
  }
  
  public Location[] getLegalMoves()
  {
  	    //List<Location> legalMoves = new ArrayList<Location>(0);
        Location[] legalMovesArray = new Location[14];
        int i = 0;
        
        for(int dy = 1; dy <= 2; y++)
        {
            int dx = 3 - dy;
            for(int n = 0; n < 4; n++)
            {
                dx = -dx;
                if(n == 2)
                    dy = -dy;
                Location loc = getLocation().getRelativeLocation(dy, dx);
            }
        }
        
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
}
