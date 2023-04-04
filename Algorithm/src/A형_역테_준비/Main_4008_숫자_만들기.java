package A형_역테_준비;

import java.io.*;
import java.util.StringTokenizer;

public class Main_4008_숫자_만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;

    static int[] calc;
    static int[] numbers;
    static int MAX, MIN;


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            N = Integer.parseInt(br.readLine());

            calc = new int[4];
            numbers = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                calc[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            MAX = Integer.MIN_VALUE;
            MIN = Integer.MAX_VALUE;


            solve(0, numbers[0]);

            bw.write("#" + t + " " + (MAX - MIN) + "\n");
        }
        bw.close();
    }

    static void solve(int depth, int result) {
        if (depth == N - 1) {
            MAX = Math.max(result, MAX);
            MIN = Math.min(result, MIN);
        }

        for (int i = 0; i < 4; i++) {
            if (calc[i] <= 0) continue;

            calc[i]--;

            switch (i) {
                case 0:
                    solve(depth + 1, result + numbers[depth + 1]);
                    break;
                case 1:
                    solve(depth + 1, result - numbers[depth + 1]);
                    break;
                case 2:
                    solve(depth + 1, result * numbers[depth + 1]);
                    break;
                case 3:
                    solve(depth + 1, result / numbers[depth + 1]);
                    break;
            }
            calc[i]++;
        }
    }
}