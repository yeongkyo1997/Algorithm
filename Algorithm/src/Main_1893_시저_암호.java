import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1893_시저_암호 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String A = br.readLine();
            String W = br.readLine();
            String S = br.readLine();
            int w = W.length();
            int s = S.length();
            int[] fail = new int[w];

            for (int i = 1, j = 0; i < w; i++) {
                while (j > 0 && W.charAt(i) != W.charAt(j)) j = fail[j - 1];
                if (W.charAt(i) == W.charAt(j)) fail[i] = ++j;
            }

            boolean find = false;
            for (int i = 0, j = 0; i < s; i++) {
                while (j > 0 && S.charAt(i) != W.charAt(j)) j = fail[j - 1];
                if (S.charAt(i) == W.charAt(j)) {
                    if (j == w - 1) {
                        if (!find) {
                            find = true;
                            j = fail[j];
                        } else {
                            find = false;
                            break;
                        }
                    } else ++j;
                }
            }
            if (!find) bw.write("no solution\n");
            else bw.write("unique: " + 0 + "\n");
        }
        bw.flush();
        bw.close();
    }
}