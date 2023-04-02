import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int D, W, K;
    static boolean[][] film = new boolean[13][20];
    static boolean[][] film_copy = new boolean[13][20];
    static ArrayList<Pair> change = new ArrayList<>();

    static class Pair {
        int first;
        boolean second;

        public Pair(int first, boolean second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean inspect() {
        for (int i = 0; i < W; i++) {
            int now = film[0][i] ? 1 : 0;
            int count = 1;
            for (int j = 1; j < D; j++) {
                if (count == K) break;
                if (now == (film[j][i] ? 1 : 0)) count++;
                else {
                    now = film[j][i] ? 1 : 0;
                    count = 1;
                }
            }
            if (count < K) return false;
        }
        return true;
    }

    static boolean DFS(int start, int k) {
        int len = change.size();
        if (len == k) {
            for (Pair i : change) {
                for (int j = 0; j < W; j++) {
                    film[i.first][j] = i.second;
                }
            }
            boolean check = inspect();
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                    film[i][j] = film_copy[i][j];
                }
            }
            return check;
        }
        for (int i = start; i < D; i++) {
            change.add(new Pair(i, false));
            if (DFS(i + 1, k)) return true;
            change.remove(change.size() - 1);
            change.add(new Pair(i, true));
            if (DFS(i + 1, k)) return true;
            change.remove(change.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        int test_case, answer;
        int T = Integer.parseInt(br.readLine());
        for (test_case = 1; test_case <= T; ++test_case) {
            // 입력받기
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                }
            }
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                    film_copy[i][j] = film[i][j];
                }
            }

            // 검사하기
            answer = K;
            for (int k = 0; k < K; k++) {
                change.clear();
                if (DFS(0, k)) {
                    answer = k;
                    break;
                }
            }

            bw.write("#" + test_case + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}