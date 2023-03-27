import java.io.*;
import java.util.StringTokenizer;

public class Main_11025 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 1; i < n + 1; i++) result = (result + k - 1) % i + 1;
        bw.write(result + "");
        bw.close();
    }
}
