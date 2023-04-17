import java.io.*;
import java.util.StringTokenizer;

public class Main_20437_문자열_게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            String W = st.nextToken();
            int K = Integer.parseInt(br.readLine());

            int[] cnt = new int[26];
            for (int i = 0; i < W.length(); i++) {
                cnt[W.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] < K) continue;

                int start = 0;
                int end = 0;
                int cntK = 0;
                while (end < W.length()) {
                    if (W.charAt(end) - 'a' == i) {
                        cntK++;
                    }

                    if (cntK == K) {
                        min = Math.min(min, end - start + 1);
                        max = Math.max(max, end - start + 1);
                        break;
                    }

                    if (end - start + 1 == K) {
                        if (W.charAt(start) - 'a' == i) {
                            cntK--;
                        }
                        start++;
                    }
                    end++;
                }
            }

            if (min == Integer.MAX_VALUE) {
                bw.write(-1 + "\n");
            } else {
                bw.write(min + " " + max + "\n");
            }
        }
        bw.close();
    }
}
