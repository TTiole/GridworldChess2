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
	    sort(C, C.getColorType());
        organize();
    }
    
    //Sorts the taken piece
    //C = the piece that just got taken
    public static void sort(ChessPiece C, char colorType)
    {
    	ArrayList<ChessPiece> sortedList = new ArrayList<ChessPiece>();
    	if(colorType == 'w')
    	{
    		for(ChessPiece C0 : whitePieces)
    			sortedList.add(C0);

    		for(int i = 0; i < whitePieces.size(); i++)
    		{
    			ChessPiece C2 = whitePieces.get(i);
    			if(C.compareTo(C2) > 0)
    			{
    				sortedList.add(i, C);
    				break;
    			}
    			else if(i == whitePieces.size()-1)
    			{
    				sortedList.add(C);
    				break;
    			}
    		}
    				
    		if(whitePieces.size() == 0)
    			sortedList.add(C);
    		whitePieces = sortedList;
    	}
    	else
    	{
    		for(ChessPiece C0 : blackPieces)
    			sortedList.add(C0);

    		for(int i = 0; i < blackPieces.size(); i++)
    		{
    			ChessPiece C2 = blackPieces.get(i);
    			if(C.compareTo(C2) > 0)
    			{
    				sortedList.add(i, C);
    				break;
    			}
    			else if(i == blackPieces.size()-1)
    			{
    				sortedList.add(C);
    				break;
    			}
    		}
    				
    		if(blackPieces.size() == 0)
    			sortedList.add(C);
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
