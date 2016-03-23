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
	
    //Actor.java already has moveTo(Location loc)

    public Location[] getLegalMoves()
    {
    	Location[] locs = new Location[2];
    	locs[0] = new Location(0, 0);
    	locs[1] = new Location(1, 1);
    	return locs;
    }
}
