import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17386_선분_교차_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long x1, y1, x2, y2, x3, y3, x4, y4;

    static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long temp = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (temp < 0) return -1;
        else if (temp > 0) return 1;
        return 0;
    }

    static int isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        if (CCW(x1, y1, x2, y2, x3, y3) * CCW(x1, y1, x2, y2, x4, y4) <= 0 && CCW(x3, y3, x4, y4, x1, y1) * CCW(x3, y3, x4, y4, x2, y2) <= 0) {
            if ((x1 > x3 && x1 > x4 && x2 > x3 && x2 > x4) || (x3 > x1 && x3 > x2 && x4 > x1 && x4 > x2)) return 0;
            else if ((y1 > y3 && y1 > y4 && y2 > y3 && y2 > y4) || (y3 > y1 && y3 > y2 && y4 > y1 && y4 > y2)) return 0;
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x3 = Long.parseLong(st.nextToken());
        y3 = Long.parseLong(st.nextToken());
        x4 = Long.parseLong(st.nextToken());
        y4 = Long.parseLong(st.nextToken());

        bw.write(isCross(x1, y1, x2, y2, x3, y3, x4, y4) + "\n");
        bw.close();
    }
}