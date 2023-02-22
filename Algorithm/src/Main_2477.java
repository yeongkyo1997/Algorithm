import java.io.*;
import java.util.StringTokenizer;

public class Main_2477 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
<<<<<<< HEAD
    static int K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());

        }
=======

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        int[] list = new int[6];
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            list[i] = Integer.parseInt(st.nextToken());
            if (max < list[i]) {
                max = list[i];
                maxIdx = i;
            }
        }
        int min = 0;
        if (maxIdx == 0) {
            min = Math.min(list[5], list[1]);
        } else if (maxIdx == 1) {
            min = Math.min(list[0], list[2]);
        } else if (maxIdx == 2) {
            min = Math.min(list[1], list[3]);
        } else if (maxIdx == 3) {
            min = Math.min(list[2], list[4]);
        } else if (maxIdx == 4) {
            min = Math.min(list[3], list[5]);
        } else {
            min = Math.min(list[4], list[0]);
        }
        bw.write((max * min - (list[(maxIdx + 1) % 6] * list[(maxIdx + 5) % 6])) * K + "");
        bw.close();
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
    }
}
