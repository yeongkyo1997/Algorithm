import java.io.*;
import java.util.StringTokenizer;

public class Main_1057_토너먼트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Lim, Kim, reuslt, round;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        round = Integer.parseInt(st.nextToken());
        Kim = Integer.parseInt(st.nextToken());
        Lim = Integer.parseInt(st.nextToken());

        while (Kim != Lim) {
            Kim = (Kim + 1) / 2;
            Lim = (Lim + 1) / 2;
            reuslt++;
        }

        bw.write(String.valueOf(reuslt));
        bw.close();
    }
}
