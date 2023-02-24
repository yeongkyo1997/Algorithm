import java.io.*;
import java.util.StringTokenizer;

public class Main_20327 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int R;
    private static int[][] list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        list = new int[1 << N][1 << N];

        for (int i = 0; i < (1 << N); i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < (1 << N); j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotate(1, 1);
        print();
        bw.close();
    }

    static void print() throws IOException {
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < (1 << N); j++) {
                bw.write(list[i][j] + " ");
            }
            bw.write("\n" + "");
        }
    }

    static void rotate(int k, int l) {
        int[] tmp;
        // k = 1  상하반전
        if (k == 1) {
            for (int i = 0; i < (1 << l); i++) {
                for (int j = 0; j < (1 << l) / 2; j++) {
                    tmp = list[i];
                    list[i][j] = list[i][(1 << l) - j - 1];
                    list[i][(1 << l) - j - 1] = tmp[j];
                }
            }
        }

        // k = 2
        if (k == 2) {
            for (int i = 0; i < (1 << l) / 2; i++) {
                for (int j = 0; j < (1 << l); j++) {
                    tmp = list[i];
                    list[i][j] = list[(1 << l) - i - 1][j];
                    list[(1 << l) - i - 1][j] = tmp[j];
                }
            }
        }

        // k = 3 오른쪽 90도 회전
        if (k == 3) {
        }

        // k = 4 왼쪽으로 90도 회전
        if (k == 4) {
            for (int i = 0; i < (1 << l); i++) {
                for (int j = 0; j < (1 << l); j++) {
                    list[i][j] = list[(1 << l) - j - 1][i];
                }
            }
        }
    }
}
