import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int N, M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] chicken = new int[13][2];

        int chickenCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    chicken[chickenCount][0] = i;
                    chicken[chickenCount][1] = j;
                    chickenCount++;
                }
            }
        }

        int[] chickenIndex = new int[M];

        for (int i = 0; i < M; i++) {
            chickenIndex[i] = i;
        }

        int min = Integer.MAX_VALUE;

        while (true) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        int minDistance = Integer.MAX_VALUE;

                        for (int k = 0; k < M; k++) {
                            int distance = getDistance(chicken, i, j, chickenIndex[k]);
                            if (minDistance > distance) minDistance = distance;
                        }
                        sum += minDistance;
                    }
                }
            }

            if (min > sum) min = sum;

            int i = M - 1;

            while (i >= 0 && chickenIndex[i] == chickenCount - M + i) i--;

            if (i < 0) break;

            chickenIndex[i]++;

            for (int j = i + 1; j < M; j++) {
                chickenIndex[j] = chickenIndex[j - 1] + 1;
            }
        }

        bw.write(min + "");
        bw.close();
    }

    static int getDistance(int[][] chicken, int i, int j, int chickenIndex) {
        return Math.abs(i - chicken[chickenIndex][0]) + Math.abs(j - chicken[chickenIndex][1]);
    }
}


