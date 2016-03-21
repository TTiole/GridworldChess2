public abstract class ChessPiece extends Actor
{
    private boolean isWhite;

    public ChessPiece(boolean white)
    {
        isWhite = white;
    }
    
    public Location getLocation()
    {
    	return super.getLocation();
    }
	
    public boolean isWhite()
    {
        return isWhite;
    }
	
    //Actor.java already has moveTo(Location loc)

    public abstract Location[] getLegalMoves();
}
