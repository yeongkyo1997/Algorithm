import java.io.*;
import java.util.StringTokenizer;

public class Main_5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringBuilder s = new StringBuilder(str);
        StringBuilder io = new StringBuilder("IO");

        for (int i = 0; i < N - 1; i++)
            io.append("IO");

        io.append("I");
        int result = 0;
        for (int i = 0; i < S - (N * 2 + 1) - 1; i++) {
            if (s.substring(i, i + (N * 2 + 1)).equals(io.toString())) result++;
        }
        bw.write(result + "");
        bw.close();
    }
}
