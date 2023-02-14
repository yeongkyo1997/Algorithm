import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_23316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] power = new long[50001];

        for (int i = 1; i < 50001; i++)
            power[i] = (long) Math.pow(i, 2);

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        Integer[] sum = new Integer[N];


        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
        }
    }
}
