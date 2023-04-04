import java.io.*;
import java.util.StringTokenizer;

public class Main_9782_Median {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int tc = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            if (size == 0) break;
            int[] list = new int[size];

            for (int i = 0; i < size; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            if (size % 2 == 0)
                bw.write(String.format("Case %d: %.1f\n", tc++, (double) (list[size / 2] + list[size / 2 - 1]) / 2));
            else bw.write(String.format("Case %d: %.1f\n", tc++, (double) (list[size / 2])));
        }
        bw.close();
    }
}
