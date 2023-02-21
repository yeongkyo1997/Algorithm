import java.io.*;
import java.util.StringTokenizer;

public class Main_18301 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int a, b, c;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int result = (int) Math.floor((a + 1) * (b + 1) / (double) (c + 1) - 1);
        bw.write(result + "");
        bw.close();
    }
}
