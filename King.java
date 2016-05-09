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
        for(Location L2 : enemyLegal)
          if(L2 != null && L2.equals(loc))
            return true;
      }
    }
    return false;
  }
  /*
  public void moveTo(Location loc)
  {
    moves++;
    if(getLocation().getRow() - loc.getRow() > 1) // kingside
    {
      Location KRL = new Location(getLocation().getRow()-3,getLocation().getCol());
      Rook KR = null;
      if(getGrid().get(KRL) != null)
          KR = (Rook)(getGrid().get(KRL));
      KR.cLaunched(true);
    }
    else if(loc.getRow() - getLocation().getRow() > 1) //queenside
    {
      Location QRL = new Location(getLocation().getRow()+4,getLocation().getCol());
      Rook QR = null;
      if(getGrid().get(QRL) != null)
        QR = (Rook)(getGrid().get(QRL));
      QR.cLaunched(false); I need to make that method on the rook class. cLaunched stands for Castling Launched
    }
    super.moveTo(loc);
  }
  */
  public boolean canCastle()
  {
    return moves == 0 && !isInCheck();
  }
  
  public Location[] getLegalMoves(boolean check)
  {
        //List<Location> legalMoves = new ArrayList<Location>(0);
        Location[] legalMovesArray = new Location[10];
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
        /*
        //Castling
        Location QRL = new Location(getLocation().getRow()+4,getLocation().getCol());
        Location KRL = new Location(getLocation().getRow()-3,getLocation().getCol());
        //Gets rooks
        Rook QR = null, KR = null;
        if(getGrid().get(QRL) != null)
          QR = (Rook)(getGrid().get(QRL));
        if(getGrid().get(KRL) != null)
          KR = (Rook)(getGrid().get(KRL));
        
        //Kingside Castling
        if(KR.canCastle() && canCastle())
        {
          Location l1 = new Location(getLocation().getRow()-1,getLocation().getCol());
          Location l2 = new Location(getLocation().getRow()-2,getLocation().getCol());
          if((getGrid().get(l1) == null && getGrid().get(l2) == null) && (isInCheck(l1) && isInCheck(l2))) //First part makes sure that the locations are empty, second checks to see if check would be caused there
            legalMovesArray[8] = l2;
        }
        
        //Queenside Castling
        if(QR.canCastle() && canCastle())
        {
          Location l3 = new Location(getLocation().getRow()+1,getLocation().getCol());
          Location l4 = new Location(getLocation().getRow()+2,getLocation().getCol());
          if((getGrid().get(l3) == null && getGrid().get(l4) == null) && (isInCheck(l3) && isInCheck(l4))) //First part makes sure that the locations are empty, second checks to see if check would be caused there
            legalMovesArray[9] = l4;
        }
        */
        
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
