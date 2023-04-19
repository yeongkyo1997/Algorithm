import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_2220_힙_정렬 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] heap = new int[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> heap[i] = i);

        for (int i = 2; i <= n; i++) {
            swap(heap, i - 1, i);
            for (int j = i - 1; j > 1; j /= 2) {
                swap(heap, j, j / 2);
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(heap[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
