import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] list = new int[7];

        for (int i = 0; i < 7; i++) {
            list[i] = Integer.parseInt(br.readLine());

        }
        int sum = Arrays.stream(list).filter(x -> x % 2 != 0).sum();
        if (sum == 0) bw.write(-1 + "");
        else {
            bw.write(sum + "\n");
            bw.write(Arrays.stream(list).filter(x -> x % 2 != 0).min().getAsInt() + "");
        }
        bw.close();
    }
}
