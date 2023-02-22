import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] list = new int[16];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        list[0] = 1;
        for (int i = 1; i < 16; i++) {
            list[i] = list[i - 1] * 2;
        }
        bw.write(Z(N, r, c) - 1 + "");
        bw.close();
    }

    static int Z(int N, int r, int c) {
        if (N == 0) return 1;

        // 상단에 위치
        if (r < list[N - 1]) {
            // 왼쪽에 위치
            if (c < list[N - 1]) return Z(N - 1, r, c);
                // 오른쪽에 위치
            else return list[N - 1] * list[N - 1] + Z(N - 1, r, c - list[N - 1]);
        }
        // 하단에 위치
        else {
            // 왼쪽에 위치
            if (c < list[N - 1]) return list[N - 1] * list[N - 1] * 2 + Z(N - 1, r - list[N - 1], c);
                // 오른쪽에 위치
            else return list[N - 1] * list[N - 1] * 3 + Z(N - 1, r - list[N - 1], c - list[N - 1]);
        }
    }
}