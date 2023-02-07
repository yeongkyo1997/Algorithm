import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static char[][] list;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        list = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                list[i][j] = str.charAt(j);
                if (list[i][j] == 'J')
                    queue.add(new int[] { i, j, 0 });
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                int ndepth = tmp[2] + 1;

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && list[nx][ny] != '#') {
                    if (list[nx][ny] == 'F')
                        list[nx][ny] = '#';
                    queue.add(new int[] { nx, ny, ndepth });
                }
            }
        }
    }
}
