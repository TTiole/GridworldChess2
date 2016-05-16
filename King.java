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
  	moves = 0;
  	cLaunched = false;
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
      if(!(C instanceof King))
      {
        Location[] enemyLegal = C.getLegalMoves(false);
        System.out.println("------");
        System.out.println(C);
        System.out.println();
        for(Location L2 : enemyLegal)
          //if(L2 != null && L2.equals(loc))
            System.out.println(L2);
      }
    }
    return false;
  }
  
  public void moveTo(Location loc)
  {
    moves++;
    if(getLocation().getCol() - loc.getCol() > 1) // kingside
    {
      Location KRL = new Location(getLocation().getRow(),getLocation().getCol()-3);
      Rook KR = null;
      if(getGrid().get(KRL) != null)
          KR = (Rook)(getGrid().get(KRL));
      KR.cLaunched(true);
    }
    else if(loc.getCol() - getLocation().getCol() > 1) //queenside
    {
      Location QRL = new Location(getLocation().getRow(),getLocation().getCol()+4);
      Rook QR = null;
      if(getGrid().get(QRL) != null)
        QR = (Rook)(getGrid().get(QRL));
      QR.cLaunched(false); //cLaunched stands for Castling Launched
    }
    super.moveTo(loc);
  }
  
  public boolean canCastle()
  {
    return moves == 0 && !isInCheck();
  }
  
  public Location[] getLegalMoves(boolean check)
  {
        //List<Location> legalMoves = new ArrayList<Location>(0);
        Location[] legalMovesArray = new Location[10];
        
        if(!ChessBoard.isTurn(getColorType()))
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
        Location QRL = new Location(getLocation().getRow(),getLocation().getCol()+4);
        Location KRL = new Location(getLocation().getRow(),getLocation().getCol()-3);
        
        Rook QR = null, KR = null;
        if(QRL.isOnBoard() && getGrid().get(QRL) instanceof Rook)
          QR = (Rook)(getGrid().get(QRL));
        if(KRL.isOnBoard() && getGrid().get(KRL) instanceof Rook)
          KR = (Rook)(getGrid().get(KRL));
        
        //Kingside Castling
        if(KR != null && KR.canCastle() && canCastle())
        {
          Location l1 = new Location(getLocation().getRow(),getLocation().getCol()-1);
          Location l2 = new Location(getLocation().getRow(),getLocation().getCol()-2);
          if((getGrid().get(l1) == null && getGrid().get(l2) == null) && !(isInCheck(l1) || isInCheck(l2))) //First part makes sure that the locations are empty, second checks to see if check would be caused there
          {
            legalMovesArray[8] = l2;
          }
        }
        
        //Queenside Castling
        if(QR != null && QR.canCastle() && canCastle())
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
