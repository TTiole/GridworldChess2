public class Pawn extends ChessPiece
{
  private boolean isPassed;
  private boolean canPass;
  private int moves;
  
  public Pawn(char c)
  {
  	super(c, 1);
  	isPassed = false;
  	canPass = true;
  }
  
  public boolean isPassed()
  {
    return isPassed;
  }
  
  public boolean canPass()
  {
    return canPass;
  }
  
  public void moveTo(Location loc)
  {
    if(getLocation().getCol()-loc.getCol() == 2)
      isPassed = true;
    Location prevLoc = getLocation();
    if(isPassed) //if it wants to move then it can no longer be passed
      isPassed = false;
  	super.moveTo(loc);
    if(canPass) //if it has moved by now then it can't pass anymore
      canPass = false;
  	moves++;
  }
  
  public Location[] getLegalMoves(boolean check)
  {
    //nPosF = next position in front, n2PosF = 2 positions in front
    //passedEnP = passed enemy pawn (this is for killing passing pawns)
    //diagP = piece in the diagonals
    Location nPosF = null;
    Location n2PosF = null;
    if(getLocation().getAdjacentLocation(0) != null)
      nPosF = getLocation().getAdjacentLocation(0);
    if(nPosF.getAdjacentLocation(0) != null)
      n2PosF = nPosF.getAdjacentLocation(0);
      
    Location[] legalMoves = new Location[6];
    

    if(nPosF.isOnBoard() && getGrid().get(nPosF) == null)
    {
    	legalMoves[0] = nPosF;
    	if(n2PosF.isOnBoard() && getGrid().get(n2PosF) == null && canPass)
    		legalMoves[1] = n2PosF;
    }
    //Enpassant Pawn
    for(int i = 0; i < 2; i++)
    {
      ChessPiece passedEnP = null;
      if(getLocation().getAdjacentLocation(90 + 180*i).isOnBoard())
      {
        passedEnP = (ChessPiece)(getGrid().get(getLocation().getAdjacentLocation(90 + 180*i)));
        if(passedEnP instanceof Pawn && passedEnP.getColorType() != getColorType() && ((Pawn)(passedEnP)).isPassed())
          legalMoves[1] = passedEnP.getLocation();
      }
    }
    //Taking other peices
    for(int i = -45; i < 135; i+=90)
    {
      Location cPos = getLocation();
      if(cPos.getAdjacentLocation(i).isOnBoard())
      {
        ChessPiece C = (ChessPiece)(getGrid().get(cPos.getAdjacentLocation(i)));
        if(C != null && C.getColorType() != getColorType())
          legalMoves[2+(i+45)/90]; //This is to make it such that it would put it on position 2 in the first iteration and position 3 on the second iteration
      }
    }
  	return legalMoves;
  }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new Bishop(getColorType()));
  }
}
