package ru.job4j.puzzle;

public class Win {

    public static boolean check(int[][] board) {
        boolean rst = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (isMonoHorizontal(board, i) || isMonoVertical(board, i))) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    public static boolean isMonoHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isMonoVertical(int[][] board, int column) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
