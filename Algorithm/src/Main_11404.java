import java.io.*;
import java.util.StringTokenizer;

public class Main_11404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] list = new int[n + 1][n + 1];


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) list[i][j] = i == j ? 0 : 987654321;
        }

        for (int i = 0; i < m; i++) {
            int a, b, c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list[a][b] = Math.min(list[a][b], c);
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) list[i][j] = Math.min(list[i][j], list[i][k] + list[k][j]);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (list[i][j] >= 987654321) list[i][j] = 0;
                bw.write(list[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
