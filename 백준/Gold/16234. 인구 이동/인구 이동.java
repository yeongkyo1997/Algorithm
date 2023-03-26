import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, L, R;
    static int[][] map;
    static int[][] open;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int day = 0;
    static int uni = 0;
    static ArrayList<Integer> avg_list;

    static boolean needMove() {
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                for (int d = 0; d < 4; ++d) {
                    int ni, nj;

                    ni = i + dr[d];
                    nj = j + dc[d];

                    int home = map[i][j];
                    int adj = map[ni][nj];
                    if (L <= Math.abs(home - adj) && Math.abs(home - adj) <= R) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    static void bfs(int r, int c) {
        int countries = 1;
        int population = map[r][c];

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(r, c));
        open[r][c] = uni;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();

            r = p.getKey();
            c = p.getValue();

            for (int d = 0; d < 4; ++d) {
                int nr, nc;
                nr = r + dr[d];
                nc = c + dc[d];

                if (open[nr][nc] != 0) {
                    continue;
                }

                int home = map[r][c];
                int adj = map[nr][nc];
                if (L <= Math.abs(home - adj) && Math.abs(home - adj) <= R) {
                    open[nr][nc] = uni;
                    countries++;
                    population += map[nr][nc];
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }

        avg_list.add(population / countries);

    }

    static void sol() {

        while (true) {
            open = new int[52][52];
            if (!needMove()) {
                break;
            }

            day++;
            uni = 0;
            avg_list = new ArrayList<>();
            avg_list.add(-1); // dummy value

            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (open[i][j] == 0) {
                        for (int d = 0; d < 4; ++d) {
                            int ni, nj;

                            ni = i + dr[d];
                            nj = j + dc[d];

                            int home = map[i][j];
                            int adj = map[ni][nj];
                            if (L <= Math.abs(home - adj) && Math.abs(home - adj) <= R) {
                                if (open[ni][nj] == 0) {
                                    uni++;  // increase the number of unions
                                    bfs(i, j);
                                }
                            }
                        }
                    }
                }
            }

            // average the population
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (open[i][j] != 0) {
                        int unionNum = open[i][j];
                        map[i][j] = avg_list.get(unionNum);
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[52][52];
        for (int i = 0; i < 52; ++i) {
            for (int j = 0; j < 52; ++j) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol();
        bw.write(day + "\n");
        bw.close();
    }
}