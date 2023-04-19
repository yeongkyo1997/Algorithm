import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_20055_컨베이어_벨트_위의_로봇 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Integer> up;
    static List<Integer> down;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        up = new LinkedList<>();
        down = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, N).forEach(i -> up.add(Integer.parseInt(st.nextToken())));
        IntStream.range(0, N).forEach(i -> down.add(Integer.parseInt(st.nextToken())));

        int cnt = 0;
        while (!check()) {
            moveBelt();
            moveRobot();
            putRobot();
            cnt++;
        }

        bw.write(cnt + "\n");
    }


    static void moveRobot() {
        if (down.get(N - 1) > 0) {
            down.set(N - 1, down.get(N - 1) - 1);
            up.set(N - 1, up.get(N - 1) + 1);
        }
        for (int i = N - 2; i >= 0; i--) {
            if (down.get(i) > 0 && down.get(i + 1) == 0 && up.get(i + 1) > 0) {
                down.set(i, down.get(i) - 1);
                up.set(i, up.get(i) + 1);
                down.set(i + 1, down.get(i + 1) + 1);
                up.set(i + 1, up.get(i + 1) - 1);
            }
        }
    }

    static void moveBelt() {
        int temp = up.get(N - 1);
        up.remove(N - 1);
        up.add(0, temp);
        temp = down.get(N - 1);
        down.remove(N - 1);
        down.add(0, temp);
    }

    static void putRobot() {
        if (up.get(0) > 0) {
            up.set(0, up.get(0) - 1);
            down.set(0, down.get(0) + 1);
        }
    }

    static boolean check() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (up.get(i) == 0) cnt++;
            if (down.get(i) == 0) cnt++;
        }
        return cnt >= K;
    }
}


