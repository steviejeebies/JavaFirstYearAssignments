
public abstract class Connect4Grid {

    public abstract void emptyGrid();
    public abstract String toString();
    public abstract boolean isValidColumn(int column);
    public abstract boolean isColumnFull(int column);
    public abstract void dropPiece(Connect4Player player, int column);
    public abstract boolean didLastPieceConnect4();
    public abstract boolean isGridFull();
}
