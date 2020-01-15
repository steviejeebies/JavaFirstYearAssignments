public class Connect4Grid2DArray extends Connect4Grid {

    private char[][] grid = new char[6][7];
    private int lastPieceRow;
    private int lastPieceColumn;

    @Override
    public void emptyGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = ' ';
            }
        }
        lastPieceRow = 0; // as the board is being reset with this function, we also
        lastPieceColumn = 0; // need to clear these two variables.
    }

    @Override
    public String toString() {
        String boardPrint = "";

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char boardChar = grid[i][j];
                boardPrint += boardChar + "|";
            }
            boardPrint += "\n";
        }
        boardPrint += "1 2 3 4 5 6 7";

        return boardPrint;
    }

    @Override
    public boolean isValidColumn(int column) {
        if (column >= 0 && column <= 6)
            return true;
        return false;
    }

    @Override
    public boolean isColumnFull(int column) {
        if (grid[0][column] != ' ')
            return false;
        return true;
    }

    @Override
    public void dropPiece(Connect4Player player, int column) {
        boolean piecePlaced = false;
        for(int spaceIndex = 0; !piecePlaced && spaceIndex < grid.length ; spaceIndex++) {
            if(spaceIndex+1 < grid.length)
            {
                char pieceInNextSlot = grid[spaceIndex + 1][column];
                if (pieceInNextSlot != ' ') {
                    grid[spaceIndex][column] = player.getPlayerPiece();
                    piecePlaced = true;
                    lastPieceRow = spaceIndex;
                    lastPieceColumn = column;
                }
            }
            else
            {
                grid[spaceIndex][column] = player.getPlayerPiece();
                lastPieceRow = spaceIndex;
                lastPieceColumn = column;
            }
        }
    }

    @Override
    public boolean didLastPieceConnect4() {
        int winningStreak = 0;
        int rowFind = -1;
        int columnFind = -1;
        char pieceColor = grid[lastPieceRow][lastPieceColumn];

        if (pieceColor != ' ') {
            try {
                while (grid[lastPieceRow + rowFind][lastPieceColumn + columnFind] == pieceColor) {
                    winningStreak++;
                    rowFind--;
                    columnFind--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            rowFind = 1;
            columnFind = 1;
            try {
                while (grid[lastPieceRow + rowFind][lastPieceColumn + columnFind] == pieceColor) {
                    winningStreak++;
                    rowFind++;
                    columnFind++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            if (winningStreak >= 3)
                return true;
            else
                winningStreak = 0;

            rowFind = 0;
            columnFind = -1;
            try {
                while (grid[lastPieceRow + rowFind][lastPieceColumn + columnFind] == pieceColor) {
                    winningStreak++;
                    columnFind--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            rowFind = 0;
            columnFind = 1;
            try {
                while (grid[lastPieceRow + rowFind][lastPieceColumn + columnFind] == pieceColor) {
                    winningStreak++;
                    columnFind++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            if (winningStreak >= 3)
                return true;
            else
                winningStreak = 0;

            rowFind = 1;
            columnFind = -1;
            try {
                while (grid[lastPieceRow + rowFind][lastPieceColumn + columnFind] == pieceColor) {
                    winningStreak++;
                    rowFind++;
                    columnFind--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            rowFind = -1;
            columnFind = 1;
            try {
                while (grid[lastPieceRow + rowFind][lastPieceColumn + columnFind] == pieceColor) {
                    winningStreak++;
                    rowFind--;
                    columnFind++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            if (winningStreak >= 3)
                return true;
            else
                winningStreak = 0;

            rowFind = 1;
            columnFind = 0;
            try {
                while (grid[lastPieceRow + rowFind][lastPieceColumn + columnFind] == pieceColor) {
                    winningStreak++;
                    rowFind++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            rowFind = -1;
            columnFind = 0;
            try {
                while (grid[lastPieceRow + rowFind][lastPieceColumn + columnFind] == pieceColor) {
                    winningStreak++;
                    rowFind--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            if (winningStreak >= 3)
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public boolean isGridFull() {
        for (int columnIndex = 0; columnIndex < grid[0].length; columnIndex++) {
            if (grid[0][columnIndex] == ' ')
                return false;
        }

        return true;
    }
}
