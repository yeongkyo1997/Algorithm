import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int W, H, X, Y, P;

    static boolean isSquare(int x, int y) {
        return x >= X && x <= X + W && y >= Y && y <= Y + H;
    }

    static double getDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    static boolean isCircle(int x, int y) {

        return getDist(X, Y + H / 2, x, y) <= H / 2 || getDist(X + W, Y + H / 2, x, y) <= H / 2;
    }

    public static void main(String[] args) throws Exception {
        int result = 0;
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < P; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (isSquare(x, y)) result++;
            else if (isCircle(x, y)) result++;
        }
        bw.write(result + "\n");
        bw.close();
    }
}