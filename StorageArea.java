import java.util.ArrayList;

public class StorageArea
{
    private static ArrayList<ChessPiece> takenPieces;
    private static Location[] whitePlaces, blackPlaces;
    
    static
    {
        takenPieces = new ArrayList<ChessPiece>();
        whitePlaces = new Location[16];
        blackPlaces = new Location[16];
        for(int i = 0; i < 16; i++)
        {
            whitePlaces[i] = new Location(8 + i/8, i % 8);
            blackPlaces[i] = new Location(9 + i/8, i % 8);
        }
    }
    
    public static void insertPiece(ChessPiece C)
    {
        int index;
        if(takenPieces.isEmpty())
        {
            takenPieces.add(C);
            index = 0;
        }
        else
            for(int i = 0; i < takenPieces.size(); i++)
                if(C.compareTo(takenPiece.get(i) > 0)
                {
                    takenPieces.add(i, C);
                    index = i;
                }
                else if(i == takenPieces.size() - 1)
                {
                    takenPieces.add(C);
                    index = i;
                }
    }
    
    public static void sort()
    {
        for(int i = takenPieces.size() - 1; i >= 0; i--)
        {
            if(takenPieces.get(i).getColorType() == 'w')
                takenPieces.get(i).moveTo(whitePlaces[i]);
            else if(takenPieces.get(i).getColorType() == 'b')
                takenPieces.get(i).moveTo(blackPlaces[i]);
        }
    }
    
    public static void takePiece(ChessPiece C)
    {
        insertPiece(C);
        sort();
    }
}
