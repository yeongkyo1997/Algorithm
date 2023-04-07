import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][] data;
    static int[][] tree;

    static int sum(int r, int c) {
        int result = 0;
        for (int i = r; i > 0; i -= (i & -i))
            for (int j = c; j > 0; j -= (j & -j))
                result += tree[i][j];

        return result;
    }

    static void update(int r, int c, int num) {
        for (int i = r; i <= N; i += (i & -i))
            for (int j = c; j <= N; j += (j & -j))
                tree[i][j] += num;

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int cmd = Integer.parseInt(st.nextToken());
        data = new int[N + 1][N + 1];
        tree = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; ++j) {
                data[i][j] = Integer.parseInt(st.nextToken());
                update(i, j, data[i][j]);
            }
        }

        int w, x1, y1, x2, y2, num;
        while (cmd-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());

            if (w == 0) {
                x1 = Integer.parseInt(st.nextToken());
                y1 = Integer.parseInt(st.nextToken());
                num = Integer.parseInt(st.nextToken());
                update(x1, y1, num - data[x1][y1]);
                data[x1][y1] = num;
            } else if (w == 1) {
                x1 = Integer.parseInt(st.nextToken());
                y1 = Integer.parseInt(st.nextToken());
                x2 = Integer.parseInt(st.nextToken());
                y2 = Integer.parseInt(st.nextToken());
                bw.write(sum(x2, y2) - sum(x2, y1 - 1) - sum(x1 - 1, y2) + sum(x1 - 1, y1 - 1) + "\n");
            }
        }
        bw.close();
    }
}