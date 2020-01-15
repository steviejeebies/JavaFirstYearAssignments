public abstract class Connect4Player {
    private char playerPiece;

    public Connect4Player(char piece) {
        playerPiece = piece;
    }

    public abstract int selectColumn();

    public char getPlayerPiece()
    {
        return playerPiece;
    }
}
