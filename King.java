import java.util.ArrayList;

public class King extends ChessPiece
{
  private boolean check, cLaunched;
  private char targetColor;
  private ArrayList<Location> oppositeLocs = new ArrayList<Location>();
  private int moves;
  
  public King(char c)
  {
  	super(c);
  	cLaunched = false;
  	moves = 0;
    targetColor = 'w';
    if(c == 'w')
      targetColor = 'b';
  	check = false;
  }
  
  public boolean isInCheck() //looks if it's in check for king in current location
  {
    return isInCheck(getLocation());
  }
  
  public boolean isInCheck(Location loc) //looks if it's in check if the king was in the passed location
  {
    oppositeLocs = getLocations(targetColor);
    for(Location L : oppositeLocs)
    {
      ChessPiece C = (ChessPiece)(getGrid().get(L));
      Location[] enemyLegal = C.getAttackingMoves(false);
      for(Location L2 : enemyLegal)
        if(L2 != null && L2.equals(loc))
          return true;
    }
    return false;
  }
  
  public void moveTo(Location loc)
  {
    int dl = -3, dr = 4;
    if(getColorType() == 'b')
    {
    	int temp = dl;
    	dl = -dr;
    	dr = -temp;
    }

    moves++;
    if(((loc.getCol() == 1 && getColorType() == 'w') || (loc.getCol() == 2 && getColorType() == 'b')) && canCastle()) // left side
    {
      Location LRLoc = new Location(getLocation().getRow(),getLocation().getCol()+dl);

      Rook LR = null;
      if(getGrid().get(LRLoc) != null)
      {
          LR = (Rook)(getGrid().get(LRLoc));
      	  LR.cLaunched(true, dl, dr);
      	  cLaunched = true;
      }
    }
    else if(((loc.getCol() == 5 && getColorType() == 'w') || (loc.getCol() == 6 && getColorType() == 'b')) && canCastle()) // right side
    {
      Location RRLoc = new Location(getLocation().getRow(),getLocation().getCol()+dr);

      Rook RR = null;
      if(getGrid().get(RRLoc) != null)
      {
        RR = (Rook)(getGrid().get(RRLoc));
      	RR.cLaunched(false, dl, dr); //cLaunched stands for Castling Launched
      	cLaunched = true;
      }
    }
    super.moveTo(loc);
  }
  
  public boolean canCastle()
  {
    return moves == 0 && !isInCheck() && !cLaunched;
  }
  
  public Location[] getLegalMoves(boolean check)
  {
        Location[] legalMovesArray = new Location[10];
        
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return legalMovesArray;
        
        int i = 0;
        for(int d = 0; d < 360; d += 45)
        {
        	Location sPos = getLocation();
            sPos = sPos.getAdjacentLocation(d);
            if(isLegal(check, sPos))
            {
                legalMovesArray[i] = sPos;
                i++;
            }
        }
        
        //Castling
        //Gets rook locations
        int dl = -3, dr = 4;
        if(getColorType() == 'b')
        {
        	dl = -dl;
        	dr = -dr;
        }
        
        Location QRL = new Location(getLocation().getRow(), getLocation().getCol() + dr);
        Location KRL = new Location(getLocation().getRow(), getLocation().getCol() + dl);
        
        Rook QR = null, KR = null;
        if(QRL.isOnBoard() && getGrid().get(QRL) instanceof Rook)
          QR = (Rook)(getGrid().get(QRL));
        if(KRL.isOnBoard() && getGrid().get(KRL) instanceof Rook)
          KR = (Rook)(getGrid().get(KRL));
          
        //Kingside Castling
        if(check && KR != null && KR.canCastle() && canCastle())
        {
          Location l1 = new Location(getLocation().getRow(),getLocation().getCol()-1);
          Location l2 = new Location(getLocation().getRow(),getLocation().getCol()-2);
          if((getGrid().get(l1) == null && getGrid().get(l2) == null) && !(isInCheck(l1) || isInCheck(l2))) //First part makes sure that the locations are empty, second checks to see if check would be caused there
          {
            legalMovesArray[8] = l2;
          }
        }
        
        //Queenside Castling
        if(check && QR != null && QR.canCastle() && canCastle())
        {
          Location l3 = new Location(getLocation().getRow(),getLocation().getCol()+1);
          Location l4 = new Location(getLocation().getRow(),getLocation().getCol()+2);
          if((getGrid().get(l3) == null && getGrid().get(l4) == null) && !(isInCheck(l3) || isInCheck(l4))) //First part makes sure that the locations are empty, second checks to see if check would be caused there
          {
            legalMovesArray[9] = l4;
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
  
  public void copyTo(Location loc)
  {
    ChessBoard.add(loc, new King(getColorType()));
  }
}
