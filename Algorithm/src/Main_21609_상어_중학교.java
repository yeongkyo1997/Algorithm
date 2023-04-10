import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_21609_상어_중학교 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer;

    static class Block {
        int size;
        int rainbowCnt;
        int x;
        int y;
        int[][] blockPos;
    }

    static void Input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static Block BFS(int x, int y, int color) {
        Block block = new Block();
        block.size = 1;
        block.rainbowCnt = 0;
        block.x = x;
        block.y = y;
        block.blockPos = new int[N * N][2];
        block.blockPos[0][0] = x;
        block.blockPos[0][1] = y;
        visited[x][y] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int idx = 1;

        for (int i = 0; i < idx; i++) {
            int cx = block.blockPos[i][0];
            int cy = block.blockPos[i][1];

            for (int j = 0; j < 4; j++) {
                int nx = cx + dx[j];
                int ny = cy + dy[j];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == -1) continue;

                if (map[nx][ny] == 0) {
                    block.rainbowCnt++;
                    block.blockPos[idx][0] = nx;
                    block.blockPos[idx][1] = ny;
                    visited[nx][ny] = true;
                    idx++;
                    continue;
                }

                if (map[nx][ny] == color) {
                    block.size++;
                    block.blockPos[idx][0] = nx;
                    block.blockPos[idx][1] = ny;
                    visited[nx][ny] = true;
                    idx++;
                }
            }
        }
        return block;
    }

    static Block findBiggestBlock() {
        Block result = new Block();
        result.size = 0;
        result.rainbowCnt = 0;
        result.x = 0;
        result.y = 0;
        result.blockPos = new int[N * N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == -1) continue;
                if (map[i][j] == -2) continue;
                if (map[i][j] == 0) continue;
                if (visited[i][j]) continue;
                Block Temp = BFS(i, j, map[i][j]);
                if (result.size < Temp.size) {
                    result = Temp;
                } else if (result.size == Temp.size) {
                    if (result.rainbowCnt < Temp.rainbowCnt) {
                        result = Temp;
                    } else if (result.rainbowCnt == Temp.rainbowCnt) {
                        if (result.x < Temp.x) {
                            result = Temp;
                        } else if (result.x == Temp.x) {
                            if (result.y < Temp.y) {
                                result = Temp;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    static void Delete_Block(Block Block) {
        for (int i = 0; i < Block.size; i++) {
            map[Block.blockPos[i][0]][Block.blockPos[i][1]] = -2;
        }
        answer += Block.size * Block.size;
    }

    static void Gravity() {
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (map[j][i] == -1) continue;
                if (map[j][i] == -2) continue;
                int x = j;
                while (x + 1 < N) {
                    if (map[x + 1][i] == -1) break;
                    if (map[x + 1][i] == -2) {
                        map[x + 1][i] = map[x][i];
                        map[x][i] = -2;
                        x++;
                    } else break;
                }
            }
        }
    }

    static void Rotate() {
        int[][] Temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, Temp[i], 0, N);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = Temp[N - 1 - j][i];
            }
        }
    }

    static void Solve() {
        while (true) {
            visited = new boolean[N][N];
            Block Temp = findBiggestBlock();
            if (Temp.size < 2) break;
            Delete_Block(Temp);
            Gravity();
            Rotate();
            Gravity();
        }
    }

    public static void main(String[] args) throws Exception {
        Input();
        Solve();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}