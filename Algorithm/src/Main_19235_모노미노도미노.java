import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_19235_모노미노도미노 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, t, yy1, xx1, yy2, xx2;
    static int score = 0;
    static int[][][] boards = new int[2][10][4];
    static int[] my = {0, 0, 1};
    static int[] mx = {0, 1, 0};

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            yy1 = Integer.parseInt(st.nextToken());
            xx1 = Integer.parseInt(st.nextToken());

            yy2 = yy1 + my[t - 1];
            xx2 = xx1 + mx[t - 1];

            dropBlock(0, yy1, xx1, yy2, xx2, t == 3 ? 1 : t);
            deleteRowUntillAble(0);
            handleSoftCell(0);

            dropBlock(1, xx1, yy1, xx2, yy2, t == 3 ? 2 : 1);
            deleteRowUntillAble(1);
            handleSoftCell(1);
        }

        bw.write(score + "\n" + (getCellCount(0) + getCellCount(1)));
        bw.flush();
        bw.close();
    }

    static void dropBlock(int board, int y1, int x1, int y2, int x2, int type) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == y1 && j == x1) {
                    boards[board][i][j] = type;
                }
                if (i == y2 && j == x2) {
                    boards[board][i][j] = type;
                }
            }
        }
    }

    static void deleteRow(int board, int row) {
        for (int i = row; i > 0; i--) {
            System.arraycopy(boards[board][i - 1], 0, boards[board][i], 0, 4);
        }
    }

    static void downBlock(int board, int row) {
        for (int r = row; r >= 0; r--) {
            for (int c = 0; c < 4; c++) {
                if (boards[board][r][c] > 0) {
                    int nr = r + 1;
                    while (nr < 4 && boards[board][nr][c] == 0) {
                        nr++;
                    }
                    nr--;

                    if (nr != r) {
                        boards[board][nr][c] = boards[board][r][c];
                        boards[board][r][c] = 0;
                        dropBlock(board, r, c, r, c, 2);
                    }
                }
            }
        }
    }

    static void deleteRowUntillAble(int board) {
        while (true) {
            int maxDeletedRow = -1;

            for (int r = 0; r < 4; r++) {
                int isDelete = 1;

                for (int c = 0; c < 4; c++) {
                    if (boards[board][r][c] == 0) {
                        isDelete = 0;
                        break;
                    }
                }

                if (isDelete == 0) continue;

                deleteRow(board, r);
                score++;
                maxDeletedRow = r;
            }

            if (maxDeletedRow == -1) break;

            downBlock(board, maxDeletedRow - 1);
        }
    }

    static void handleSoftCell(int board) {
        while (true) {
            int count = 0;

            for (int r = 5; r >= 4; r--) {
                for (int c = 0; c < 4; c++) {
                    if (boards[board][r][c] > 0) {
                        count++;
                        break;
                    }
                }

                if (count == 0) return;
            }

            for (int r = 7; r > 7 - count; r--) {
                deleteRow(board, r);
            }

            downBlock(board, 7 - count);
        }
    }

    static int getCellCount(int board) {
        int ret = 0;

        for (int i = 6; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                if (boards[board][i][j] > 0) ret++;
            }
        }

        return ret;
    }
}