import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1038 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        if (N < 10) bw.write(N + "");
        else {
            int[] dp = new int[30];
            Arrays.fill(dp, 0, 10, 1);
            System.out.println(Arrays.toString(dp));
        }
    }
}
