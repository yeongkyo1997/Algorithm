import java.io.*;
import java.util.StringTokenizer;

public class Main_5522_카드_게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int result = 0;

        for (int i = 0; i < 5; i++) {
            result += Integer.parseInt(br.readLine());
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
