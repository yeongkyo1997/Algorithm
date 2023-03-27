import java.io.*;
import java.util.StringTokenizer;

public class Main_1100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int result = 0;

        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0 && str.charAt(j) == 'F') result++;
                if (i % 2 == 1 && j % 2 == 1 && str.charAt(j) == 'F') result++;
            }
        }
        bw.write(result + "");
        bw.close();
    }
}
