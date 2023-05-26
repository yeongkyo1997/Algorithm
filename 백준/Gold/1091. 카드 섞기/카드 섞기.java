import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] idx = new int[50];
    static int[] copy = new int[50];
    static int[] init_state = new int[50];
    static int[] suffle = new int[50];
    static int num;

    public static boolean isSorted() {
        return IntStream.range(0, num).noneMatch(i -> idx[i] != (i % 3));
    }

    public static void solve() throws IOException {
        int count = 0;
        while (!isSorted()) {
            count++;

            // 카드 섞기
            if (num >= 0) System.arraycopy(idx, 0, copy, 0, num);

            IntStream.range(0, num).forEach(i -> idx[suffle[i]] = copy[i]);

            // 카드가 섞기 전 맨 처음 상태인지 확인
            for (int i = 0; i < num; i++) {
                if (init_state[i] != idx[i]) break;

                if (i == num - 1) {
                    bw.write("-1");
                    return;
                }
            }
        }
        bw.write(String.valueOf(count));
    }

    public static void main(String[] args) throws IOException {
        num = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            idx[i] = Integer.parseInt(st.nextToken());
            init_state[i] = idx[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            suffle[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        bw.close();
    }
}