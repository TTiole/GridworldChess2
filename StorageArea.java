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
	        whitePieces.add(C);
	    else
	        blackPieces.add(C);
        //sort();
        organize();
    }
    
    public static void sort()
    {
    	int val1;
    	int val2;
		ArrayList<ChessPiece> sorted = new ArrayList();
		for(int i = 0; i < whitePieces.size();i++)
		{
			val1 = whitePieces.get(i).value
			for(int j = i+1; j < whitePieces.size(); j++)
			{
				if(whitePieces.get(j) == null)
					val2 = 0;
				else
					val2 = whitePieces.get(j).value;
				if(val2 <= val)
				{
					sorted.add(whitePieces.get(i));
				}
			}
			
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
