package edu.hw1;

public class Task8 {
    public boolean knightBoardCapture(int[][] a) {
        int[] dx = new int[] {2, 2, 1, -1, -2, -2, -1, 1};
        int[] dy = new int[] {1, -1, 2, 2, 1, -1, -2, -2};

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (a[row][column] == 0) {
                    continue;
                }

                for (int move = 0; move < 8; move++) {
                    int nextRow = row + dy[move];
                    int nextColumn = column + dx[move];

                    if (nextRow < 0 || nextRow >= 8
                            || nextColumn < 0 || nextColumn >= 8) {
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
