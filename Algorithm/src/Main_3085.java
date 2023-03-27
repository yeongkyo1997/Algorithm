import java.io.*;
import java.util.StringTokenizer;

public class Main_3085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static char[][] list;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        list = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) list[i][j] = str.charAt(j);
        }
    }
}
