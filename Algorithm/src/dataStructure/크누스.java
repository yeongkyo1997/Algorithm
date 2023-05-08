package dataStructure;

public class 크누스 {
    static int[][] puzzle;

    public 크누스(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    static boolean solve() {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (puzzle[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty) {
            return true;
        }
        for (int num = 1; num <= 16; num++) {
            if (isSafe(row, col, num)) {
                puzzle[row][col] = num;
                if (solve()) {
                    return true;
                } else {
                    puzzle[row][col] = 0;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < 16; i++) {
            if (puzzle[row][i] == num) {
                return false;
            }
            if (puzzle[i][col] == num) {
                return false;
            }
        }
        int boxRow = row - row % 4;
        int boxCol = col - col % 4;
        for (int i = boxRow; i < boxRow + 4; i++) {
            for (int j = boxCol; j < boxCol + 4; j++) {
                if (puzzle[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printSolution() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printSolution();
    }
}
