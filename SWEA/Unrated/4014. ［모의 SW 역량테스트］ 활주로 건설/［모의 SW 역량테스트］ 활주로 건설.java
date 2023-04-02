import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, N, L;
    static int[][] map = new int[100 + 20][100 + 20];
    static int[][] tMap = new int[100 + 20][100 + 20];
    static final int MAX = 100 + 20;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                tMap[c][r] = map[r][c];
            }
        }
    }

    static int distance(int a, int b) {
        return (a > b) ? a - b : b - a;
    }

    static int isFlat(int[] arr, int start, int end) {
        int val = arr[start];
        for (int i = start + 1; i <= end; i++)
            if (val != arr[i]) return 0;

        return 1;
    }

    static int check(int[] arr) {
        int[] inverse = new int[MAX];
        int[] visited = new int[MAX];
        int[] visitedInverse = new int[MAX];

        for (int i = 0; i < N; i++) inverse[i] = arr[N - i - 1];

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) continue;
            if (distance(arr[i], arr[i + 1]) > 1) return 0;
            if (arr[i] > arr[i + 1]) {
                if (i + L == N) return 0;
                if (isFlat(arr, i + 1, i + L) == 0) return 0;

                for (int k = i + 1; k <= i + L; k++) visited[k] = 1;
            }
        }


        for (int i = 0; i < N; i++) visitedInverse[i] = visited[N - i - 1];

        for (int i = 0; i < N - 1; i++) {

            if (inverse[i] == inverse[i + 1]) continue;
            if (distance(inverse[i], inverse[i + 1]) > 1) return 0;
            if (inverse[i] > inverse[i + 1]) {
                if (i + L == N) return 0;
                if (isFlat(inverse, i + 1, i + L) == 0) return 0;

                for (int k = i + 1; k <= i + L; k++)
                    if (visitedInverse[k] == 1) return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int sum;

            input();

            sum = 0;
            for (int i = 0; i < N; i++) {
                sum += check(map[i]);
                sum += check(tMap[i]);
            }

            bw.write("#" + tc + " " + sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}