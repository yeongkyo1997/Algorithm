
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int R, C, ans = 0;
    static char[][] MAP;
    static int[] move_r = {-1, 0, 1};

    static boolean DFS(int r, int c) {
        MAP[r][c] = 'x';
        if (c == C - 1) return true;

        for (int k = 0; k < 3; ++k) {
            int dr = r + move_r[k];
            if (dr < 0 || dr >= R) continue;
            if (MAP[dr][c + 1] == '.' && DFS(dr, c + 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        MAP = new char[R][C];
        for (int i = 0; i < R; ++i) MAP[i] = br.readLine().toCharArray();

        for (int i = 0; i < R; ++i)
            if (DFS(i, 0)) ++ans;

        bw.write(ans + "\n");
        bw.close();
    }

}