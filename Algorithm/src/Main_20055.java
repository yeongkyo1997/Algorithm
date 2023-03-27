import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_20055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int K;
    private static int[] belt;
    private static boolean[] robot;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        do {
            cnt++;
            rotate();
            move();
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }
        } while (!check());

        bw.write(cnt + "");
        bw.close();
    }

    public static void rotate() {
        int temp = belt[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) belt[i] = belt[i - 1];
        belt[0] = temp;

        for (int i = N - 1; i > 0; i--) robot[i] = robot[i - 1];
        robot[0] = false;

        robot[N - 1] = false;
    }

    public static void move() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                belt[i + 1]--;
            }
        }
    }

    public static boolean check() {
        int cnt = (int) IntStream.range(0, 2 * N).filter(i -> belt[i] == 0).count();
        return cnt >= K;
    }
}
