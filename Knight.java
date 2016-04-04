public class Knight extends ChessPiece
{
  public Knight(char c)
  {
  	super(c);
  }
  
  public Location[] getLegalMoves()
  {
  	    //List<Location> legalMoves = new ArrayList<Location>(0);
        Location[] legalMovesArray = new Location[8];
        int i = 0;
        
        for(int dy = 1; dy <= 2; dy++)
        {
            int dx = 3 - dy;
            for(int n = 0; n < 4; n++)
            {
                dx = -dx;
                if(n == 2)
                    dy = -dy;
                Location loc = getLocation().getRelativeLocation(dy, dx);
                if(isLegal(loc))
                {
                    legalMovesArray[i] = loc;
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
