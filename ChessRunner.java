public class ChessRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(3, 3), new Rook('w'));
        world.show();
    }
}
