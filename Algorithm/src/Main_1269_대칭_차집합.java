import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1269_대칭_차집합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int M = Integer.parseInt(st.nextToken());
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(A, B[i]) < 0)
                cnt++;
        }

        for (int i = 0; i < N; i++) {
            if (Arrays.binarySearch(B, A[i]) < 0)
                cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
