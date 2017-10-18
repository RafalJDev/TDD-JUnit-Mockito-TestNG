package main.com.RJ.tddjava.tictactoe;

class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0', '\0'}, {'\0', '\0', '\0', '\0'}, {'\0', '\0', '\0', '\0'}, {'\0', '\0', '\0', '\0'}};
    private char lastPlayer;
    private int count = 0;
    private final int SIZE = 4;
    private String message;

    public void play(int x, int y) {
        CheckAxis(x);
        CheckAxis(y);
        SetMove(x, y);
        if (!IsWin().contains("No") || IsDraw()) {
            System.out.println(message);
        }

    }

    private void CheckAxis(int a) {
        if (a < 1 || a > SIZE) {
            throw new RuntimeException();
        }
    }

    private void SetMove(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException();
        } else {
            board[x - 1][y - 1] = NextPlayer();
        }
    }

    public char NextPlayer() {
        if (lastPlayer == 'X') {
            lastPlayer = 'O';
        } else {
            lastPlayer = 'X';
        }
        return lastPlayer;
    }

    public String IsWin() {
        boolean result = IsWinOnWholeRow() || IsWinOnWholeColumn() || IsWinOnWholeDiagonal();
        if (result) {
            message = lastPlayer + " Win!";
        } else {
            message = "No Win!";
        }
        return message;
    }

    public boolean IsWinOnWholeRow() {
        for (int i = 0; i < SIZE; i++) {
            String rowResult = "";
            for (int j = 0; j < SIZE; j++) {
                rowResult += board[j][i].toString();
            }
            if (rowResult.equals("XXXX") || rowResult.equals("OOOO")) {
                return true;
            }
        }
        return false;
    }

    public boolean IsWinOnWholeColumn() {
        for (int i = 0; i < SIZE; i++) {
            String rowResult = "";
            for (int j = 0; j < SIZE; j++) {
                rowResult += board[i][j].toString();
            }
            if (rowResult.equals("XXXX") || rowResult.equals("OOOO")) {
                return true;
            }
        }
        return false;
    }

    public boolean IsWinOnWholeDiagonal() {
        String diagonal1 ="";
        String diagonal2 ="";
        for (int i=0;i<SIZE;i++) {
            diagonal1 += board[i][i].toString();
            diagonal2 += board[i][SIZE-1-i].toString();
        }
        if (diagonal1 .equals("XXXX") || diagonal2.equals("XXXX")) {
            return true;
        }
        return false;
    }

    public boolean IsDraw() {
        count++;
        if (count == SIZE * SIZE) {
            message = "Draw!";
            count = 0;
            return true;
        }
        return false;
    }
}
