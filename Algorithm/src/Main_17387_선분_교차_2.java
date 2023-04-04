import java.io.*;
import java.util.StringTokenizer;

public class Main_17387_선분_교차_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int x1, y1, x2, y2, x3, y3, x4, y4;
    static int answer = 0;
    static boolean didanswer = false;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());
        x4 = Integer.parseInt(st.nextToken());
        y4 = Integer.parseInt(st.nextToken());

        if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) == 0 && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) == 0) {
            didanswer = true;
        }
        if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2) && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)) {
            answer = 1;
        }
        if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) <= 0 && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) <= 0) {
            if (!didanswer) {
                answer = 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        int tmp = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
        return Integer.compare(tmp, 0);
    }
}