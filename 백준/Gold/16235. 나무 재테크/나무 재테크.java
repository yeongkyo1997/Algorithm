import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] A;
    static List<Tree>[][] trees;
    static int[][] land;
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        trees = new List[N][N];
        land = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                trees[i][j] = new ArrayList<>();
                land[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(new Tree(age));
        }

        for (int year = 0; year < K; year++) {
            springAndSummer();
            fall();
            winter();
        }

        bw.write(String.valueOf(solution()));
        bw.close();
    }

    static void springAndSummer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<Tree> live = new ArrayList<>();
                int dead = 0;

                trees[i][j].sort((tree1, tree2) -> Integer.compare(tree1.age, tree2.age));

                for (Tree tree : trees[i][j]) {
                    if (land[i][j] >= tree.age) {
                        land[i][j] -= tree.age;
                        tree.age++;
                        live.add(tree);
                    } else {
                        dead += tree.age / 2;
                    }
                }

                trees[i][j] = live;
                land[i][j] += dead;
            }
        }
    }

    static void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Tree tree : trees[i][j]) {
                    if (tree.age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                trees[nx][ny].add(0, new Tree(1));
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] += A[i][j];
            }
        }
    }

    static int solution() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += trees[i][j].size();
            }
        }
        return result;
    }

    static class Tree {
        int age;

        Tree(int age) {
            this.age = age;
        }
    }
}