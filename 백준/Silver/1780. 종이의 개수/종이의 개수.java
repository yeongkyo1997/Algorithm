import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] result = new int[3];
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, n);
        for (int cnt : result) 
            bw.write(cnt + "\n");
        bw.close();
    }

    static void solve(int x, int y, int size) {
        if (check(x, y, size)) {
            int num = paper[x][y] + 1;
            result[num]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(x + newSize * i, y + newSize * j, newSize);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        int num = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}