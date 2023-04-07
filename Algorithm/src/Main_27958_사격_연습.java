import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_27958_사격_연습 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K;
    static int[][] board;
    static int[] dmg;
    static int ans;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        dmg = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, K).forEach(i -> dmg[i] = Integer.parseInt(st.nextToken()));

        dfs(0, 0, board);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static void dfs(int cnt, int score, int[][] current_board) {
        if (score > ans) ans = score;


        if (cnt < K) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (current_board[i][j] > 0) {
                        if (current_board[i][j] < 10) {
                            if (current_board[i][j] <= dmg[cnt]) {
                                int[][] before = new int[N][N];
                                for (int k = 0; k < 4; k++) {
                                    int ny = i + dy[k];
                                    int nx = j + dx[k];
                                    if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                                        if (current_board[ny][nx] == 0) {
                                            before[ny][nx] = current_board[ny][nx];
                                            current_board[ny][nx] = current_board[i][j] / 4;
                                            board[ny][nx] = current_board[i][j] / 4;
                                        }
                                    }
                                }

                                int s = current_board[i][j];
                                int b = board[i][j];
                                board[i][j] = 0;
                                current_board[i][j] = 0;
                                dfs(cnt + 1, score + b, current_board);

                                for (int y = 0; y < N; y++) {
                                    for (int x = 0; x < N; x++) {
                                        current_board[y][x] = before[y][x];
                                        board[y][x] = before[y][x];
                                    }
                                }

                                current_board[i][j] = s;
                                board[i][j] = b;
                            } else {
                                current_board[i][j] -= dmg[cnt];
                                dfs(cnt + 1, score, current_board);
                                current_board[i][j] += dmg[cnt];
                            }
                        } else {
                            int s = current_board[i][j];
                            current_board[i][j] = 0;
                            dfs(cnt + 1, score + s, current_board);
                            current_board[i][j] = s;
                        }
                        break;
                    }
                }
            }
        }
    }
}