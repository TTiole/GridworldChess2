public abstract class ChessPiece extends Actor
{
    private boolean isWhite;

    public ChessPiece(boolean white)
    {
        isWhite = white;
    }
	
    public boolean isWhite()
    {
        return isWhite;
    }
	
    public void move()
    {
        
    }

    public abstract Location[] getLegalMoves();
}
