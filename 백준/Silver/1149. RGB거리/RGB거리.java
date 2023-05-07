import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] red = new int[1001];
        int[] green = new int[1001];
        int[] blue = new int[1001];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            red[i] += Math.min(green[i - 1], blue[i - 1]);
            green[i] += Math.min(red[i - 1], blue[i - 1]);
            blue[i] += Math.min(red[i - 1], green[i - 1]);
        }

        bw.write(Math.min(Math.min(red[n - 1], green[n - 1]), blue[n - 1]) + "\n");
        bw.close();
    }
}