package edu.hw1;

public class Task8 {
    private static final int ROWS = 8;
    private static final int COLUMNS = 8;
    private static final int MOVES = 8;

    public boolean knightBoardCapture(int[][] a) {
        @SuppressWarnings("MagicNumber")
        int[] dx = new int[] {2, 2, 1, -1, -2, -2, -1, 1};

        @SuppressWarnings("MagicNumber")
        int[] dy = new int[] {1, -1, 2, 2, 1, -1, -2, -2};

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (a[row][column] == 0) {
                    continue;
                }

                for (int move = 0; move < MOVES; move++) {
                    int nextRow = row + dy[move];
                    int nextColumn = column + dx[move];

                    if (nextRow < 0 || nextRow >= ROWS
                            || nextColumn < 0 || nextColumn >= COLUMNS) {
                        continue;
                    }

                    if (a[nextRow][nextColumn] == 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
