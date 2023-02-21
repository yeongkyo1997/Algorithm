import java.io.*;
import java.util.StringTokenizer;

public class Main_15726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int max = 0;

        max = Math.max(max, (int) Math.floor(A * B / C));
        max = Math.max(max, (int) Math.floor(A / B * C));

        bw.write(max + "");
        bw.close();
    }
}
