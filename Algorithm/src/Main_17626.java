import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17626 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while (N != 0) {
            N -= (int) Math.pow(Math.floor(Math.sqrt(N)), 2);
            System.out.println(Math.pow(Math.floor(Math.sqrt(N)), 2));
            result++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
