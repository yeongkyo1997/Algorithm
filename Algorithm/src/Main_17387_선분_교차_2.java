import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17387_선분_교차_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        int res1 = ccw(x1, y1, x2, y2, x3, y3);
        int res2 = ccw(x1, y1, x2, y2, x4, y4);
        int res3 = ccw(x3, y3, x4, y4, x1, y1);
        int res4 = ccw(x3, y3, x4, y4, x2, y2);

        if (res1 == res2 && res2 == res3 && res3 == res4 && res4 == 0) {
            if ((Math.max(x1, x2) < Math.min(x3, x4)) || (Math.max(x3, x4) < Math.min(x1, x2)) || (Math.max(y1, y2) < Math.min(y3, y4)) || (Math.max(y3, y4) < Math.min(y1, y2)))
                bw.write("0");
            else bw.write("1");

        } else if (res1 * res2 <= 0 && res3 * res4 <= 0) bw.write("1");
        else bw.write("0");

        bw.flush();
        bw.close();
    }

    static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x2 - x1) * (y3 - y2) - (x3 - x2) * (y2 - y1);
    }
}