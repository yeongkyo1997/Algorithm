import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_24060_알고리즘_수업_병합_정렬_1 {
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
        bw.write(A + "\n");
        bw.flush();
        bw.close();
    }

    static void mergeSort(int[] A, int p, int r) {
        int q = 0;

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
            if (A[i] <= A[j])
                tmp[t++] = A[i++];
            else
                tmp[t++] = A[j++];
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
