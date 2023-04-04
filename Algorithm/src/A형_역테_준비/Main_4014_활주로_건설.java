package A형_역테_준비;

import java.io.*;
import java.util.StringTokenizer;

public class Main_4014_활주로_건설 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, N, L;
    static int[][] map = new int[100 + 20][100 + 20]; // 0 ~ 100
    static int[][] tMap = new int[100 + 20][100 + 20]; // 0 ~ 100
    static final int MAX = 100 + 20;

    static int distance(int a, int b) { // 높이 차이
        return (a > b) ? a - b : b - a;
    }

    /*
     * start ~ end 까지의 높이가 모두 같은지 확인
     * 1 : 같음
     * 0 : 다름
     */
    static int isFlat(int[] arr, int start, int end) {
        int val = arr[start];
        for (int i = start + 1; i <= end; i++)
            if (val != arr[i]) return 0;

        return 1;
    }

    static int check(int[] arr) {
        int[] inverse = new int[MAX]; // 역순 배열
        int[] visited = new int[MAX]; // 방문 여부
        int[] visitedInverse = new int[MAX]; // 역순 배열의 방문 여부

        for (int i = 0; i < N; i++) inverse[i] = arr[N - i - 1];

        for (int i = 0; i < N - 1; i++) {
            // 높이가 같으면 패스
            if (arr[i] == arr[i + 1]) continue;

            // 높이 차이가 1 이상이면 안됨
            if (distance(arr[i], arr[i + 1]) > 1) return 0;

            // 높이 차이가 1이면, 높이가 높은 쪽으로 L만큼 연속된 곳이 있어야 함
            if (arr[i] > arr[i + 1]) {
                // L만큼 연속된 곳이 없으면 안됨
                if (i + L == N) return 0;
                if (isFlat(arr, i + 1, i + L) == 0) return 0; // 높이가 같은지 확인

                // L만큼 연속된 곳이 있으면, 높이가 높은 쪽으로 L만큼 연속된 곳이 있으면 안됨
                for (int k = i + 1; k <= i + L; k++) visited[k] = 1;
            }
        }


        // 역순 배열에 대해서도 같은 작업을 수행
        for (int i = 0; i < N; i++) visitedInverse[i] = visited[N - i - 1];

        for (int i = 0; i < N - 1; i++) {
            if (inverse[i] == inverse[i + 1]) continue; // 높이가 같으면 패스
            if (distance(inverse[i], inverse[i + 1]) > 1) return 0; // 높이 차이가 1 이상이면 안됨
            if (inverse[i] > inverse[i + 1]) { // 높이 차이가 1이면, 높이가 높은 쪽으로 L만큼 연속된 곳이 있어야 함
                if (i + L == N) return 0; // L만큼 연속된 곳이 없으면 안됨
                if (isFlat(inverse, i + 1, i + L) == 0) return 0; // 높이가 같은지 확인

                // L만큼 연속된 곳이 있으면, 높이가 높은 쪽으로 L만큼 연속된 곳이 있으면 안됨
                for (int k = i + 1; k <= i + L; k++)
                    if (visitedInverse[k] == 1) return 0; // 이미 방문한 곳이면 안됨
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int sum;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    tMap[c][r] = map[r][c]; // 행렬 전치, 행렬의 열을 행으로, 행을 열로
                }
            }
            sum = 0;

            /*
             * 행과 열을 따로 확인하지 않고, 행렬을 전치시켜서 열을 행으로, 행을 열로 바꾸어서
             * 행과 열을 동시에 확인할 수 있음
             * 행렬의 전치는 행렬의 행과 열을 바꾸는 것
             */
            for (int i = 0; i < N; i++) {
                sum += check(map[i]); // 행
                sum += check(tMap[i]); // 열
            }

            bw.write("#" + tc + " " + sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
