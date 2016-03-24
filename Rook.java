public class Rook extends ChessPiece
{
    public Rook(char c)
    {
        super(c);
    }

    public Location[] getLegalMoves()
    {
    List<Location> legalMoves = new ArrayList<Location>(0);
    Location sPos = getLocation();
    for(int i = 1; i <= 4; i++)
    {
        
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
}
