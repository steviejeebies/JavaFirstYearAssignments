public class C4RandomAIPlayer extends Connect4Player{

    public C4RandomAIPlayer() {
        super('R');
    }

    @Override
    public int selectColumn()
    {
        return (int) Math.round((Math.random() * 6));
    }
}
