import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        	sort(true);
    	}
	    else
	    {
	        blackPieces.add(C);
        	sort(false);
	    }
        organize();
    }
    
    public static void sort(boolean isWhite)
    {
    	Collections.sort(whitePieces, new Comparator<ChessPiece>() {
        	@Override public int compare(ChessPiece p1, ChessPiece p2) {
            	return p1.compareTo(p2); // Ascending
        	}

    	});
    	
    	/*
    	int val1;
    	int val2;
		ArrayList<ChessPiece> sorted = new ArrayList();
		
		if(isWhite)
		{
			for(int i = 0; i < whitePieces.size(); i++)
			{
				val1 = whitePieces.get(i).value;
				for(int j = i+1; j < whitePieces.size(); j++)
				{
					if(whitePieces.get(j) == null)
						val2 = 0;
					else
						val2 = whitePieces.get(j).value;
					if(val2 <= val1)
					{
						sorted.add(whitePieces.get(i));
					}
				}
			}
			whitePieces = sorted;
		}
		else
		{
			for(int i = 0; i < blackPieces.size();i++)
			{
				val1 = blackPieces.get(i).value;
				for(int j = i+1; j < blackPieces.size(); j++)
				{
					if(blackPieces.get(j) == null)
						val2 = 0;
					else
						val2 = blackPieces.get(j).value;
					if(val2 <= val1)
					{
						sorted.add(blackPieces.get(i));
					}
				}
			}
			blackPieces = sorted;
		}
		*/
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