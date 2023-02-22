package 월평준비;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1289_원재의_메모리_복구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            // 바꾼횟수
            int cnt = 0;
            // 이전문자
            char pre = '0';

            for (int i = 0; i < str.length(); i++) {
                // 현재문자와 이전문자가 다르다면
                if (str.charAt(i) != pre) {
                    cnt++;
                    // 이전문자를 현재문자로 바꿈
                    pre = str.charAt(i);
                }
            }
            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
