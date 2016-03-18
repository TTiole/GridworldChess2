public abstract class ChessPiece extends Actor
{
	private boolean isWhite = false;
	
	public boolean isWhite()
	{
		return isWhite;
	}
	
	public abstract void move();
	public Location[] legalMoves();
}
