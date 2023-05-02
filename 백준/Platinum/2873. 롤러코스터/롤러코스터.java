import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int R, C;
    static int[][] arr;

    public static void main (String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];

        StringBuilder result = new StringBuilder();
        if (R % 2 == 1) {
            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C - 1; x++) {
                    if (y % 2 == 0) result.append("R");
                    else result.append("L");
                }
                if (y != R - 1) result.append("D");
            }
        } else if (C % 2 == 1) {
            for (int x = 0; x < C; x++) {
                for (int y = 0; y < R - 1; y++) {
                    if (x % 2 == 0) result.append("D");
                    else result.append("U");
                }
                if (x != C - 1) result.append("R");
            }
        } else {
            int minScore = Integer.MAX_VALUE;
            int[] minHappy = new int[2];
            for (int y = 0; y < R; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < C; x++) {
                    arr[y][x] = Integer.parseInt(st.nextToken());
                    if ((y + x) % 2 == 1 && minScore > arr[y][x]) {
                        minScore = arr[y][x];
                        minHappy[0] = y;
                        minHappy[1] = x;
                    }
                }
            }

            int newR = minHappy[0] % 2 == 1 ? minHappy[0] - 1 : minHappy[0];
            for (int y = 0; y < newR; y++) {
                for (int x = 0; x < C - 1; x++) {
                    if (y % 2 == 0) result.append("R");
                    else result.append("L");
                }
                result.append("D");
            }

            int newC = minHappy[1];
            for (int x = 0; x < newC; x++)
                if (x % 2 == 0) result.append("DR");
                else result.append("UR");

            for (int x = newC; x < C - 1; x++)
                if (x % 2 == 0) result.append("RD");
                else result.append("RU");

            if (minHappy[0] % 2 == 0) newR = R - (minHappy[0] + 2);
            else newR = R - (minHappy[0] + 1);

            for (int y = 0; y < newR; y++) {
                result.append("D");
                for (int x = 0; x < C - 1; x++) {
                    if (y % 2 == 0) result.append("L");
                    else result.append("R");
                }
            }

        }

        bw.write(result + "\n");
        bw.close();
    }
}