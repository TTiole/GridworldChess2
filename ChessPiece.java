public abstract class ChessPiece extends Actor
{
    private char colorType;

    public ChessPiece(char c)
    {
        colorType = c;
    }
	
    public char getColorType()
    {
        return colorType;
    }
    
    public boolean isLegal(Location loc)
    {
    	ChessPiece C = (ChessPiece)getGrid().get(loc);
    	
    	if(loc == null)
    		return false;
    		
    	else if(getGrid().isValid(loc))
    		return false;
    		
    	else if(C.getColorType() == colorType)
    		return false;
    		
    	return true;
    }

    public abstract Location[] getLegalMoves();
}
