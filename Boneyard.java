import java.util.ArrayList;

public class Boneyard
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
    
    public static void takePiece(ChessPiece C)
    {
        if(takenPieces.size() == 0)
            takenPieces.add(C);
        else if(takenPieces.size() == 1)
            if(C.value > takenPieces.get(0).value)
                takenPieces.add(0, C);
            else
                takenPieces.add(C);
        else
            for(int i = 0; i < takenPieces.size(); i++)
            {
                if(C.value > takenPieces.get(i).value)
                    takenPieces.add(i, C);
                else if(C.value == takenPieces.get(i).value && C.value == takenPieces.get(i+1).value)
                    takenPieces.add(i+1, C);
            }
    }
}
