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
	
	public abstract void move();
	public Location[] legalMoves();
}
