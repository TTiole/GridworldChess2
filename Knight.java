public class Knight extends ChessPiece
{
  public Knight(char c)
  {
  	super(c, 3);
  }
  
  public Location[] getLegalMoves(boolean check)
  {
        Location[] legalMovesArray = new Location[16];
        
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return legalMovesArray;
        	
        int i = 0;
        
        for(int dy = 1; dy <= 2; dy++)
        {
            int x = 3 - dy;
            int y = dy;
            for(int n = 0; n < 4; n++)
            {
                x = -x;
                if(n == 2)
                    y = -y;
                Location loc = getLocation().getRelativeLocation(y, x);
                if(isLegal(check, loc))
                {
                    legalMovesArray[i] = loc;
                    i++;
                }
            }
        }
        return legalMovesArray;
  }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new Bishop(getColorType()));
  }
}
