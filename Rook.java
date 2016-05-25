import java.util.List;
import java.util.ArrayList;

public class Rook extends ChessPiece
{
    private int moves;
    
    public Rook(char c)
    {
        super(c, 5);
        moves = 0;
    }

    public Location[] getLegalMoves(boolean check)
    {
        Location[] legalMoves = new Location[14];
        
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return legalMoves;
        	
        appendLegalMoves(legalMoves, 0, 90);
        
        return legalMoves;
    }
    
    public void cLaunched(boolean left, int dl, int dr) //True = Kingside castle, False = Queenside castle
    {
        if(left)
            moveTo(new Location(getLocation().getRow(), getLocation().getCol() - dl - 1));
        else
            moveTo(new Location(getLocation().getRow(), getLocation().getCol() - dr + 1));
    }
    
    public void moveTo(Location loc)
    {
        moves++;
        super.moveTo(loc);
    }
    
    public boolean canCastle()
    {
        return moves == 0;
    }
  
  	public void copyTo(Location loc)
  	{
  	  	ChessBoard.add(loc, new Bishop(getColorType()));
  	}
}
