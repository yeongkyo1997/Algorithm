import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1289 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            int cnt = 0;
            char pre = '0';
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != pre) {
                    cnt++;
                    pre = input.charAt(i);
                }
            }
            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
