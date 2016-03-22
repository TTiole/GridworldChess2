

public class Bishop extends ChessPiece
{
  public Bishop(boolean isWhite)
  {
    super(isWhite);
  }
  
  public Location[] getLegalMoves()
  {
    //cPos: current position being analyzed sPos: starting position nPos: next position to be analyzed
    Location[] legalMoves = new Location[13];
    Location sPos = getLocation();
    for(int i = 1; i =< 4; i++)
    {
      switch(i) //NORTHEAST (1), SOUTHEAST (2), SOUTHWEST(3), NORTHWEST(4)
      {
        case 1:
          if(getAdjacentLocation(NORTHEAST) == null)
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
    
  }
}
