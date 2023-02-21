import java.io.*;
import java.util.StringTokenizer;

public class Main_20056 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] map;
    static int[][][] fireball;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        fireball = new int[M][4][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireball[i][0][0] = r;
            fireball[i][0][1] = c;
            fireball[i][1][0] = s;
            fireball[i][1][1] = d;
            fireball[i][2][0] = m;
            fireball[i][3][0] = 1;
            map[r][c]++;
        }

        for (int i = 0; i < K; i++) {
            move();
            merge();
        }

        int sum = 0;
        for (int i = 0; i < M; i++) {
            if (fireball[i][3][0] == 1) {
                sum += fireball[i][2][0];
            }
        }

        bw.write(sum + "");
        bw.close();
    }

    public static void move() {
        for (int i = 0; i < M; i++) {
            if (fireball[i][3][0] == 1) {
                int r = fireball[i][0][0];
                int c = fireball[i][0][1];
                int s = fireball[i][1][0];
                int d = fireball[i][1][1];
                int m = fireball[i][2][0];
                map[r][c]--;
                int nr = r + dx[d] * s;
                int nc = c + dy[d] * s;
                if (nr < 0) {
                    nr = N - (Math.abs(nr) % N);
                } else if (nr >= N) {
                    nr = nr % N;
                }
                if (nc < 0) {
                    nc = N - (Math.abs(nc) % N);
                } else if (nc >= N) {
                    nc = nc % N;
                }
                fireball[i][0][0] = nr;
                fireball[i][0][1] = nc;
                map[nr][nc]++;
            }
        }
    }

    public static void merge() {
        for (int i = 0; i < M; i++) {
            if (fireball[i][3][0] == 1) {
                int r = fireball[i][0][0];
                int c = fireball[i][0][1];
                int m = fireball[i][2][0];
                int s = fireball[i][1][0];
                int d = fireball[i][1][1];
                if (map[r][c] > 1) {
                    int cnt = 0;
                    int sumM = 0;
                    int sumS = 0;
                    int sumD = 0;
                    for (int j = 0; j < M; j++) {
                        if (fireball[j][3][0] == 1) {
                            int nr = fireball[j][0][0];
                            int nc = fireball[j][0][1];
                            if (r == nr && c == nc) {
                                cnt++;
                                sumM += fireball[j][2][0];
                                sumS += fireball[j][1][0];
                                sumD += fireball[j][1][1];
                                fireball[j][3][0] = 0;
                            }
                        }
                    }
                    int nm = sumM / 5;
                    int ns = sumS / cnt;
                    int nd = sumD / cnt;
                    if (nm == 0) continue;
                    if (nd % 2 == 0) {
                        for (int j = 0; j < 4; j++) {
                            int nr = r + dx[j * 2] * ns;
                            int nc = c + dy[j * 2] * ns;
                            if (nr < 0) {
                                nr = N - (Math.abs(nr) % N);
                            } else if (nr >= N) {
                                nr = nr % N;
                            }
                            if (nc < 0) {
                                nc = N - (Math.abs(nc) % N);
                            } else if (nc >= N) {
                                nc = nc % N;
                            }
                            fireball[i][0][0] = nr;
                            fireball[i][0][1] = nc;
                            fireball[i][1][0] = ns;
                            fireball[i][1][1] = j * 2;
                            fireball[i][2][0] = nm;
                            fireball[i][3][0] = 1;
                            map[nr][nc]++;
                            i++;
                        }
                    } else {
                        for (int j = 0; j < 4; j++) {
                            int nr = r + dx[j * 2 + 1] * ns;
                            int nc = c + dy[j * 2 + 1] * ns;
                            if (nr < 0) {
                                nr = N - (Math.abs(nr) % N);
                            } else if (nr >= N) {
                                nr = nr % N;
                            }
                            if (nc < 0) {
                                nc = N - (Math.abs(nc) % N);
                            } else if (nc >= N) {
                                nc = nc % N;
                            }
                            fireball[i][0][0] = nr;
                            fireball[i][0][1] = nc;
                            fireball[i][1][0] = ns;
                            fireball[i][1][1] = j * 2 + 1;
                            fireball[i][2][0] = nm;
                            fireball[i][3][0] = 1;
                            map[nr][nc]++;
                            i++;
                        }
                    }
                    i--;
                }
            }
        }
    }
}
