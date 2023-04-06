import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_12738_가장_긴_증가하는_부분_수열_3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int[] idxArr;
    static int[] visited;
    static int[] result;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        idxArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        IntStream.rangeClosed(1, N).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        visited = new int[N + 1];
        result = new int[N + 1];

        int vSize = 0;

        for (int i = 1; i <= N; i++) {
            if (vSize == 0 || visited[vSize] < arr[i]) {
                visited[++vSize] = arr[i];
                idxArr[i] = vSize;
            } else {
                int left = 1;
                int right = vSize;

                while (left < right) {
                    int Mid = (left + right) / 2;
                    if (visited[Mid] >= arr[i]) right = Mid;
                    else left = Mid + 1;
                }
                visited[left] = arr[i];
                idxArr[i] = left;
            }
        }

        bw.write(vSize + "\n");

        int fIdx = vSize;
        for (int i = N; i > 0; i--) {
            if (idxArr[i] == fIdx) {
                fIdx--;
                result[fIdx + 1] = arr[i];
            }
        }
        for (int i = 1; i <= vSize; i++)
            bw.write(result[i] + " ");

        bw.write("\n");
        bw.close();
    }
}