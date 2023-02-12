import java.io.*;
import java.util.StringTokenizer;

public class Main_2530 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int second = Integer.parseInt(br.readLine());

        C += second;
        B += C / 60;
        C %= 60;
        A += B / 60;
        B %= 60;
        A %= 24;

        bw.write(A + " " + B + " " + C + "");
        bw.close();
    }
}
