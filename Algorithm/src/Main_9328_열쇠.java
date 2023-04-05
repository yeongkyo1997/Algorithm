import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328_열쇠 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int H, W, Answer;
    static char[][] MAP;
    static boolean[][] Visit;
    static boolean[] Key;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static String First_Key;

    static void Initialize() {
        MAP = new char[111][111];
        Visit = new boolean[111][111];
        Key = new boolean[26];
        First_Key = "";
        Answer = 0;
    }

    static void Input() throws Exception {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= H; i++) {
            String str = br.readLine();
            for (int j = 1; j <= W; j++) {
                MAP[i][j] = str.charAt(j - 1);
            }
        }
        First_Key = br.readLine();
        for (int i = 0; i < First_Key.length(); i++) {
            if (First_Key.charAt(i) == '0') continue;
            Key[First_Key.charAt(i) - 'a'] = true;
        }
    }

    static void BFS() {
        Queue<Pair> Q = new LinkedList<>();
        Queue<Pair>[] Door = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            Door[i] = new LinkedList<>();
        }
        Q.add(new Pair(0, 0));
        Visit[0][0] = true;

        while (!Q.isEmpty()) {
            int x = Q.peek().x;
            int y = Q.peek().y;
            Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx <= H + 1 && ny <= W + 1) {
                    if (MAP[nx][ny] == '*' || Visit[nx][ny]) continue;
                    Visit[nx][ny] = true;

                    if ('A' <= MAP[nx][ny] && MAP[nx][ny] <= 'Z') {
                        if (Key[MAP[nx][ny] - 'A']) {
                            Q.add(new Pair(nx, ny));
                        } else {
                            Door[MAP[nx][ny] - 'A'].add(new Pair(nx, ny));
                        }
                    } else if ('a' <= MAP[nx][ny] && MAP[nx][ny] <= 'z') {
                        Q.add(new Pair(nx, ny));
                        if (!Key[MAP[nx][ny] - 'a']) {
                            Key[MAP[nx][ny] - 'a'] = true;

                            while (!Door[MAP[nx][ny] - 'a'].isEmpty()) {
                                Q.add(Door[MAP[nx][ny] - 'a'].peek());
                                Door[MAP[nx][ny] - 'a'].poll();
                            }
                        }
                    } else {
                        Q.add(new Pair(nx, ny));
                        if (MAP[nx][ny] == '$') Answer++;
                    }
                }
            }
        }
    }

    static void Solution() {
        BFS();
    }

    static void Solve() throws Exception {
        int Tc = Integer.parseInt(br.readLine());
        for (int T = 1; T <= Tc; T++) {
            Initialize();
            Input();
            Solution();
            bw.write(Answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        Solve();
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
