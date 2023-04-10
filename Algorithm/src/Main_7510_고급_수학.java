import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_7510_고급_수학 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = IntStream.range(0, 3).map(j -> Integer.parseInt(st.nextToken())).toArray();

            Arrays.sort(arr);

            bw.write("Scenario #" + (i + 1) + ":\n");
            bw.write((int) Math.pow(arr[0], 2) + (int) Math.pow(arr[1], 2) == (int) Math.pow(arr[2], 2) ? "yes\n\n" : "no\n\n");
        }
        bw.close();
    }
}
