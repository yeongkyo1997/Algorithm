import java.io.*;
import java.util.StringTokenizer;

public class Main_4589 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        bw.write("Gnomes:" + "\n");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a < b && b < c) bw.write("Ordered" + "\n");
            else if (a > b && b > c) bw.write("Ordered" + "\n");
            else bw.write("Unordered" + "\n");
        }
        bw.close();
    }
}
