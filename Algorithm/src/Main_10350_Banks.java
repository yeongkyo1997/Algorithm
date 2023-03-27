import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_10350_Banks {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20002];
        int tmp;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        IntStream.rangeClosed(1, n).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        IntStream.rangeClosed(2, n).forEach(i -> arr[i] += arr[i - 1]);

        IntStream.rangeClosed(1, n).forEach(i -> arr[i + n] += (arr[i] + arr[n]));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + n; j++) {
                tmp = arr[j] - arr[i];
                if (tmp < 0) sum += ((tmp * (-1)) - 1) / arr[n] + 1;
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}