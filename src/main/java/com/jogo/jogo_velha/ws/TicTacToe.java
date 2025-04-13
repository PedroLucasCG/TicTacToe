package com.jogo.jogo_velha.ws;

public class TicTacToe {
    public static boolean hasGameEnded(String[] board) {
        return checkWin(board, "X") || checkWin(board, "O") || isBoardFull(board);
    }

    private static boolean checkWin(String[] board, String player) {
        // Rows
        for (int i = 0; i < 9; i += 3) {
            if (board[i].equals(player) && board[i + 1].equals(player) && board[i + 2].equals(player))
                return true;
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(player) && board[i + 3].equals(player) && board[i + 6].equals(player))
                return true;
        }

        // Diagonals
        return (board[0].equals(player) && board[4].equals(player) && board[8].equals(player)) ||
                (board[2].equals(player) && board[4].equals(player) && board[6].equals(player));
    }

    private static boolean isBoardFull(String[] board) {
        for (String cell : board) {
            if (cell.equals(" ")) return false;
        }
        return true;
    }
}
