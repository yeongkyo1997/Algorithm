import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1893_시저_암호 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String A, W, S;
    static int[] pi;
    static int[] cnt = new int[64];
    static int[] oa = new int[257];
    static int[] ma = new int[257];

    static int[] getPi(String s) {
        int[] pi = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j)) pi[i] = ++j;
        }
        return pi;
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            A = br.readLine();
            W = br.readLine();
            S = br.readLine();

            for (int i = 0; i < A.length(); i++)
                oa[A.charAt(i)] = i;

            pi = getPi(W);

            int as = A.length();
            for (int k = 0; k < as; k++) {
                for (int i = 0; i < as; i++)
                    ma[A.charAt(i)] = (oa[A.charAt(i)] + k) % as;

                int j = 0;
                for (int i = 0; i < S.length(); i++) {
                    while (j > 0 && oa[S.charAt(i)] != ma[W.charAt(j)]) j = pi[j - 1];
                    if (oa[S.charAt(i)] == ma[W.charAt(j)]) j++;
                    if (j == W.length()) {
                        cnt[k]++;
                        j = pi[j - 1];
                    }
                }
            }
            int[] ans = new int[64];
            int idx = 0;

            for (int i = 0; i < A.length(); i++)
                if (cnt[i] == 1) ans[idx++] = i;

            if (idx == 0) bw.write("no solution\n");
            else if (idx == 1) bw.write("unique: " + ans[0] + "\n");
            else {
                bw.write("ambiguous: ");
                for (int i = 0; i < idx; i++)
                    bw.write(ans[i] + " ");
                bw.write("\n");
            }
        }
        bw.close();
    }
}
