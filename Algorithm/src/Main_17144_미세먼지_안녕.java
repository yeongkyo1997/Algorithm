
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17144_미세먼지_안녕 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int R, C, T, m1, m2, ni, nj, remain, val;
    static int result = 0;
    static int[][] list, newList;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        list = new int[R][C];
        newList = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
                newList[i][j] = 0;
            }
        }

        for (int i = 2; i < R - 2; i++) {
            if (list[i][0] == -1) {
                m1 = i;
                m2 = i + 1;
                list[m1][0] = 0;
                list[m2][0] = 0;
                break;
            }
        }

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    remain = list[i][j];
                    val = list[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        ni = i + dy[d];
                        nj = j + dx[d];
                        if (0 <= ni && ni < R && 0 <= nj && nj < C) {
                            if (nj != 0 || (ni != m1 && ni != m2)) {
                                newList[ni][nj] += val;
                                remain -= val;
                            }
                        }
                    }
                    newList[i][j] += remain;
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    list[i][j] = newList[i][j];
                    newList[i][j] = 0;
                }
            }

            for (int i = m1 - 2; i >= 0; i--) {
                list[i + 1][0] = list[i][0];
            }

            for (int j = 1; j < C; j++) {
                list[0][j - 1] = list[0][j];
            }

            for (int i = 1; i < m1 + 1; i++) {
                list[i - 1][C - 1] = list[i][C - 1];
            }

            for (int j = C - 2; j >= 0; j--) {
                list[m1][j + 1] = list[m1][j];
            }

            for (int i = m2 + 2; i < R; i++) {
                list[i - 1][0] = list[i][0];
            }

            for (int j = 1; j < C; j++) {
                list[R - 1][j - 1] = list[R - 1][j];
            }

            for (int i = R - 2; i >= m2; i--) {
                list[i + 1][C - 1] = list[i][C - 1];
            }

            for (int j = C - 2; j >= 0; j--) {
                list[m2][j + 1] = list[m2][j];
            }

        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += list[i][j];
            }
        }

        bw.write(result + "");
        bw.close();
    }
}
