import java.io.*;
import java.util.StringTokenizer;

public class Main_1297_TV_크기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());


        bw.write((int) (H * D / Math.sqrt((H * H) + (W * W))) + " " + (int) (W * D / Math.sqrt((H * H) + (W * W))));
        bw.close();
    }
}
