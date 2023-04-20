import java.io.*;
import java.util.StringTokenizer;

public class Main_1074_Z {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        recur(r, c, (int) Math.pow(2, N));
        System.out.println(count);

    }

    private static void recur(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        if (r < half && c < half) {
            recur(r, c, half);
        } else if (r < half) {
            count += half * half;
            recur(r, c - half, half);
        } else if (c < half) {
            count += half * half * 2;
            recur(r - half, c, half);
        } else {
            count += half * half * 3;
            recur(r - half, c - half, half);
        }
    }
}