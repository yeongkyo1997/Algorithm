import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int X = Integer.parseInt(br.readLine());

        String str = Integer.toBinaryString(X);
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                result++;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
