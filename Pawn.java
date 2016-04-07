public class Pawn extends ChessPiece
{
  private boolean isPassed;
  private boolean canPass;
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
  
  public Location[] getLegalMoves()
  {
    //nPosF = next position in front, n2PosF = 2 positions in front, passedEnP = passed enemy pawn (this is for killing passing pawns), diagP = piece in the diagonals
    Location nPosF = getLocation().getAdjacentLocation(0);
    Location n2PosF = nPosF.getAdjacentLocation(0);
    Location[] legalMoves = new Location[4];
    
    if(canPass())
    {
      if(getGrid().get(nPosF) == null)
      {
        legalMoves[0] = nPosF;
        if(getGrid().get(n2PosF) == null)
          legalMoves[1] = n2PosF;
      }
    }
    else
      if(getGrid().get(nPosF) == null)
        legalMoves[0] = nPosF;
    for(int i = 0; i <= 1; i++)
    {
      ChessPiece passedEnP = (ChessPiece)(getGrid().get(getLocation().getAdjacentLocation(90 + 180*i)));
      if(passedEnP.getColorType() != getColorType() && passedEnP.isPassed())
        legalMoves[1] = new Location(getLocation().getRow()+1 - 2*i, getLocation().getCol()-1);
    }
    for(int i = 0; i <= 1; i++)
    {
      ChessPiece diagP = (ChessPiece)(getGrid().get(getLocation().getAdjacentLocation(45 + 90*i)));
      if(diagP.getColorType() != getColorType())
        legalMoves[i+2] = diagP.getLocation();
    }
    
  	return legalMoves;
  }
  
  public void copyTo(Location loc)
  {
    ChessRunner.add(loc, new Bishop(getColorType()));
  }
}
