import java.io.*;
import java.util.StringTokenizer;

public class Main_10971_외판원_순회_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] W = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = i;
        }

        int min = Integer.MAX_VALUE;

        do {
            if (P[0] != 0) break;
            int sum = 0;
            boolean ok = true;

            for (int i = 0; i < N - 1; i++) {
                if (W[P[i]][P[i + 1]] == 0) {
                    ok = false;
                    break;
                }
                sum += W[P[i]][P[i + 1]];
            }

            if (ok && W[P[N - 1]][P[0]] != 0) {
                sum += W[P[N - 1]][P[0]];
                if (min > sum) min = sum;
            }
        } while (next_permutation(P));
        bw.write(min + "\n");
        bw.close();
    }

    static boolean next_permutation(int[] P) {
        int i = P.length - 1;

        while (i > 0 && P[i - 1] >= P[i]) i--;
        if (i <= 0) return false;
        int j = P.length - 1;

        while (P[i - 1] >= P[j]) j--;
        int temp = P[i - 1];
        P[i - 1] = P[j];
        P[j] = temp;
        j = P.length - 1;

        while (i < j) {
            temp = P[i];
            P[i] = P[j];
            P[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
