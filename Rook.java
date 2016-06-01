import java.util.List;
import java.util.ArrayList;

public class Rook extends ChessPiece
{
    private int moves;
    private boolean isCastling;
    
    public Rook(char c)
    {
        super(c, 5);
        moves = 0;
        isCastling = false;
    }

    public Location[] getLegalMoves(boolean check)
    {
        if(!ChessBoard.isTurn(getColorType()) && check)
        	return new Location[0];
        	
        return getLinearMoves(50, 0, 90, check);
    }
    
    public String getNotation(Location loc)
    {
  		if(isCastling)
  			return "";
  		return super.getNotation(loc);
    }
    
    public void cLaunched(boolean left, int dl, int dr) //True = Kingside castle, False = Queenside castle
    {
    	isCastling = true;
        if(left)
            moveTo(new Location(getLocation().getRow(), getLocation().getCol() - dl - 1));
        else
            moveTo(new Location(getLocation().getRow(), getLocation().getCol() - dr + 1));
    }
    
    public void moveTo(Location loc)
    {
        moves++;
        super.moveTo(loc);
        isCastling = false;
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
