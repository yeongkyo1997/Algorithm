package 월평준비;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1208 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            int dump = Integer.parseInt(br.readLine());
            int[] block = new int[101];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                int idx = Integer.parseInt(st.nextToken());
                block[idx]++;
            }

            int left = 1;
            int right = 100;

            while (true) {
                if (left == right) break;
                if (dump-- == 0) break;

                while (block[right] == 0) right--;
                while (block[left] == 0) left++;

                block[right]--;
                block[left]++;
            }
            bw.write(String.format("#%d %d\n", i + 1, right - left));
        }
        bw.close();
    }
}
