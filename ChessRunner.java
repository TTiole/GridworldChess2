public class ChessRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Bishop('w'));
        world.show();
    }
}
