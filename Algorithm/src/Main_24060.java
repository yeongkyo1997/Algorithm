import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_24060 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static int[] A;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        mergeSort(A, 0, N - 1);
        bw.write(Arrays.toString(A) + "\n");
        bw.flush();
        bw.close();
    }

    static void mergeSort(int[] A, int p, int r) {
        int q;

        if (p >= r)
            return;

        q = (p + r) / 2;
        mergeSort(A, p, q);
        mergeSort(A, q + 1, r);
        merge(A, p, q, r);
    }

    static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 1;

        while (i <= q && j <= r) {
            tmp[t++] = A[i] <= A[j] ? A[i++] : A[j++];
        }

        while (i <= q)
            tmp[t++] = A[i++];
        while (j <= r)
            tmp[t++] = A[j++];

        i = p;
        t = 1;

        while (i <= r)
            A[i++] = tmp[t++];
    }
}
