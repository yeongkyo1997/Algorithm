import java.io.*;
import java.util.StringTokenizer;

// sw 1873 상호의 배틀필드
public class Solution_1873 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int H, W;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x, y, dir;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '<') {
                        x = i;
                        y = j;
                        dir = 3;
                    } else if (map[i][j] == '>') {
                        x = i;
                        y = j;
                        dir = 1;
                    } else if (map[i][j] == '^') {
                        x = i;
                        y = j;
                        dir = 0;
                    } else if (map[i][j] == 'v') {
                        x = i;
                        y = j;
                        dir = 2;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                char c = str.charAt(i);
                if (c == 'U') {
                    dir = 0;
                    if (x + dx[dir] >= 0 && x + dx[dir] < H && y + dy[dir] >= 0 && y + dy[dir] < W) {
                        if (map[x + dx[dir]][y + dy[dir]] == '.') {
                            map[x][y] = '.';
                            x += dx[dir];
                            y += dy[dir];
                        }
                    }
                    map[x][y] = '^';
                } else if (c == 'D') {
                    dir = 2;
                    if (x + dx[dir] >= 0 && x + dx[dir] < H && y + dy[dir] >= 0 && y + dy[dir] < W) {
                        if (map[x + dx[dir]][y + dy[dir]] == '.') {
                            map[x][y] = '.';
                            x += dx[dir];
                            y += dy[dir];
                        }
                    }
                    map[x][y] = 'v';
                } else if (c == 'L') {
                    dir = 3;
                    if (x + dx[dir] >= 0 && x + dx[dir] < H && y + dy[dir] >= 0 && y + dy[dir] < W) {
                        if (map[x + dx[dir]][y + dy[dir]] == '.') {
                            map[x][y] = '.';
                            x += dx[dir];
                            y += dy[dir];
                        }
                    }
                    map[x][y] = '<';
                } else if (c == 'R') {
                    dir = 1;
                    if (x + dx[dir] >= 0 && x + dx[dir] < H && y + dy[dir] >= 0 && y + dy[dir] < W) {
                        if (map[x + dx[dir]][y + dy[dir]] == '.') {
                            map[x][y] = '.';
                            x += dx[dir];
                            y += dy[dir];
                        }
                    }
                    map[x][y] = '>';
                } else if (c == 'S') {
                    int nx = x;
                    int ny = y;
                    while (true) {
                        nx += dx[dir];
                        ny += dy[dir];
                        if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                            if (map[nx][ny] == '*') {
                                map[nx][ny] = '.';
                                break;
                            } else if (map[nx][ny] == '#') {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            bw.write("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    bw.write(map[i][j]);
                }
                bw.write("\n");
            }
        }
        bw.close();
    }
}
