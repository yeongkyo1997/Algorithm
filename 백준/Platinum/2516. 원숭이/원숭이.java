import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][] g;
    static int[] pos;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        g = new int[N + 1][];
        pos = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            g[i] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (!relax()) break;
        }

        int a = 0, b = 0;
        for (int i = 1; i <= N; i++) {
            if (pos[i] == 1) b++;
            else a++;
        }
        bw.write(a + " ");
        for (int i = 1; i <= N; i++) {
            if (pos[i] == 0) bw.write(i + " ");
        }
        bw.write("\n");
        bw.write(b + " ");
        for (int i = 1; i <= N; i++) {
            if (pos[i] == 1) bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
    }

    static boolean relax() {
        boolean ret = false;
        for (int i = 1; i <= N; i++) {
            if (pos[i] == 1) continue;
            int cnt = 0;
            for (int j = 0; j < g[i].length; j++) {
                if (pos[g[i][j]] == 0) cnt++;
            }
            if (cnt > 1) {
                pos[i] = 1;
                ret = true;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (pos[i] == 0) continue;
            int cnt = 0;
            for (int j = 0; j < g[i].length; j++) {
                if (pos[g[i][j]] == 1) cnt++;
            }
            if (cnt > 1) {
                pos[i] = 0;
                ret = true;
            }
        }
        return ret;
    }
}