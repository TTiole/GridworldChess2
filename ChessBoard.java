public class ChessBoard
{
  public static void flipBoard()
  {
    for(int y = 0; y < 4; y++)
    	for(int x = 0; x < 8; x++)
    	{
    		ChessPiece C;
    		Location loc0 = new Location(y, x);
    		Location loc1 = new Location(7-y, 7-x);
    		if(grid.get(loc0) != null)
  			{
    			C = (ChessPiece)(grid.get(loc0));
    			System.out.println("1: "+C);
    			C.swapTo(loc1);
    		}
    		else if(grid.get(loc1) != null)
    		{
    			C = (ChessPiece)(grid.get(loc1));
    			System.out.println("2: "+C);
    			C.swapTo(loc0);
  			}
    		else
  				break;
    	 }
    }
  }
