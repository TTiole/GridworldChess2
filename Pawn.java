public class Pawn extends ChessPiece
{
  private boolean isPassed, canPass;
  
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
  
  public void hasPassed()
  {
  	isPassed = false;
  }
  
  public boolean canPass()
  {
    return canPass;
  }
  
  public void moveTo(Location loc)
  {
    if(isPassed) //if it wants to move then it can no longer be passed
      hasPassed();
    else if(getLocation().getRow()-loc.getRow() == 2)
      isPassed = true;
  	super.moveTo(loc);
    if(canPass) //if it has moved by now then it can't pass anymore
      canPass = false;
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
    
        if(!ChessBoard.isTurn(getColorType()))
        	return legalMoves;

    if(nPosF.isOnBoard() && getGrid().get(nPosF) == null && isLegal(check, nPosF))
    {
    	legalMoves[0] = nPosF;
    	if(n2PosF.isOnBoard() && getGrid().get(n2PosF) == null && canPass && isLegal(check, n2PosF))
    		legalMoves[1] = n2PosF;
    }
    //Enpassant Pawn
    if(getPassedPawn() != null && isLegal(check, getPassedPawn().getLocation()))
    	legalMoves[1] = getPassedPawn().getLocation().getAdjacentLocation(0);
    //Taking other peices
    for(int i = -45; i < 135; i+=90)
    {
      Location cPos = getLocation();
      if(cPos.getAdjacentLocation(i).isOnBoard())
      {
        ChessPiece C = (ChessPiece)(getGrid().get(cPos.getAdjacentLocation(i)));
        if(C != null && isLegal(check, C.getLocation()))
          legalMoves[2+(i+45)/90] = C.getLocation(); //This is to make it such that it would put it on position 2 in the first iteration and position 3 on the second iteration
      }
    }
  	return legalMoves;
  }
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new Bishop(getColorType()));
  }
}