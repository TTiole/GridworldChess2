import java.util.ArrayList;

public class StorageArea
{
    private static ArrayList<ChessPiece> whitePieces, blackPieces;
    private static Location[] whitePlaces, blackPlaces;
    
    static
    {
        whitePieces = new ArrayList<ChessPiece>();
        blackPieces = new ArrayList<ChessPiece>();
        whitePlaces = new Location[16];
        blackPlaces = new Location[16];
        for(int i = 0; i < 16; i++)
        {
            whitePlaces[i] = new Location(i % 8, 8 + i/8);
            blackPlaces[i] = new Location(i % 8, 8 + i/8);
        }
    }
    
    public static void insertPiece(ChessPiece C)
    {
    	if(C.getColorType() == 'w')
	    {
	        if(whitePieces.isEmpty())
	            whitePieces.add(C);
	        else
	        {
	        	int len = whitePieces.size();
	            for(int i = 0; i < len; i++)
	                if(C.compareTo(whitePieces.get(i)) > 0)
	                    whitePieces.add(i, C);
	                else if(i == whitePieces.size() - 1)
	                    whitePieces.add(C);
	        }
	    }
	    else
	    {
	        int index;
	        if(blackPieces.isEmpty())
	        {
	            blackPieces.add(C);
	        }
	        else
	        {
	        	int len = blackPieces.size();
	            for(int i = 0; i < len; i++)
	                if(C.compareTo(blackPieces.get(i)) > 0)
	                    blackPieces.add(i, C);
	                else if(i == blackPieces.size() - 1)
	                    blackPieces.add(C);
	        }
	    }
    }
	    
	public static void sort()
	{
	    for(int i = 0; i < whitePieces.size(); i++)
	        if(whitePieces.get(i).getColorType() == 'w')
	            whitePieces.get(i).swapTo(whitePlaces[i]);
	                
	    for(int i = 0; i < blackPieces.size(); i++)
	        if(blackPieces.get(i).getColorType() == 'b')
	            blackPieces.get(i).swapTo(blackPlaces[i]);
    }
    
    public static void takePiece(ChessPiece C)
    {
        insertPiece(C);
        sort();
    }
}
