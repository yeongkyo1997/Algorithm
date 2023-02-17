import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] paper = new int[100][100];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int rMax = 0;
        int rMin = 101;
        int cMax = 0;
        int cMin = 101;

        while (N-- != 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            rMax = Math.max(rMax, r + 10);
            rMin = Math.min(rMin, r);
            cMax = Math.max(cMax, c + 10);
            cMin = Math.min(cMin, c);
        }

        int result = (rMax - rMin) * 2 + (cMax - cMin) * 2;
        bw.write(result + "\n");
        bw.close();
    }
}
