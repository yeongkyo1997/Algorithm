import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_16238_독수리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        IntStream.range(0, N).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        Arrays.sort(arr);

        int day = 0;
        long res = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= day) continue;
            res += arr[i] - day;
            day++;
        }

        bw.write(String.valueOf(res));
        bw.close();
    }
}