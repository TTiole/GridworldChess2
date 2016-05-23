import java.util.ArrayList;
import java.util.Collections;

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
            blackPlaces[i] = new Location(i % 8, 10 + i/8);
        }
    }
    
    public static void takePiece(ChessPiece C)
    {
    	if(C.getColorType() == 'w')
    	{
	        whitePieces.add(C);
	        sort(C, 'w');
    	}
		else
		{
	        blackPieces.add(C);
	        sort(C, 'b');
		}
        //sort();
        organize();
    }
    
    public static void sort(C, colorType)
    {
    	ArrayList<ChessPiece> sortedList = new ArrayList<ChessPiece>();
    	if(colorType == 'w')
    	{
    		for(ChessPiece C2 : whitePieces)
    		{
    			if(C.compareTo(C2) >= 0)
    				sortedList.add(indexOf(C2), C);
    			else if(indexOf(C2) == whitePieces.size()-1)
    				sortedList.add(C);
    		}
    		if(whitePieces.size() == 0)
    			whitePieces.add(C);
    		whitePieces = sortedList;
    	}
    	else
    	{
    		for(ChessPiece C2 : blackPieces)
    		{
    			if(C.compareTo(C2) >= 0)
    				sortedList.add(indexOf(C2), C);
    			else if(indexOf(C2) == blackPieces.size()-1)
    				sortedList.add(C);
    		}
    		if(blackPieces.size() == 0)
    			blackPieces.add(C);
    		blackPieces = sortedList;
    	}
    }
	    
	public static void organize()
	{
		for(int i = 0; i < whitePieces.size(); i++)
		{
			ChessPiece W = whitePieces.get(i);
			if(W.getGrid() != null)
	        	W.swapTo(whitePlaces[i]);
	        else
	        	ChessBoard.add(whitePlaces[i], W);
		}
	                
	    for(int i = 0; i < blackPieces.size(); i++)
		{
			ChessPiece B = blackPieces.get(i);
			if(B.getGrid() != null)
	        	B.swapTo(blackPlaces[i]);
	        else
	        	ChessBoard.add(blackPlaces[i], B);
		}
    }
}
