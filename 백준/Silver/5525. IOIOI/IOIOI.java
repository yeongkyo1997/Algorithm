import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());

        StringBuilder IOI = new StringBuilder();
        for (int i = 0; i < N; i++)
            IOI.append("IO");

        IOI.append("I");
        int result = 0;

        for (int i = 0; i < M - (N * 2 - 1) - 1; i++) {
            if (sb.substring(i, i + N * 2 + 1).equals(IOI.toString())) result++;
        }
        bw.write(result + "");
        bw.close();
    }
}