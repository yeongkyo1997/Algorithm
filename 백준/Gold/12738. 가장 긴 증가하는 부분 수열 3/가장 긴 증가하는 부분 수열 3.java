import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int[] idxArr;
    static int[] V;
    static int[] result;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        idxArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        IntStream.rangeClosed(1, N).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        V = new int[N + 1];
        result = new int[N + 1];

        int vSize = 0;

        for (int i = 1; i <= N; i++) {
            if (vSize == 0 || V[vSize] < arr[i]) {
                V[++vSize] = arr[i];
                idxArr[i] = vSize;
            } else {
                int left = 1;
                int right = vSize;
                while (left < right) {
                    int Mid = (left + right) / 2;
                    if (V[Mid] >= arr[i]) right = Mid;
                    else left = Mid + 1;
                }
                V[left] = arr[i];
                idxArr[i] = left;
            }
        }

        bw.write(vSize + "\n");

        bw.close();
    }
}