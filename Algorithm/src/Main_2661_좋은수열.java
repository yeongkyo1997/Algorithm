import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2661_좋은수열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[] a = new int[88];

    static void gogo(int cnt) {
        for (int i = 1; i <= cnt / 2; i++) {
            if (equal(a, cnt - i, cnt, cnt - i - i)) return;
        }
        if (cnt == n) {
            for (int i = 0; i < n; i++) System.out.print(a[i]);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            a[cnt] = i;
            gogo(cnt + 1);
        }
    }

    static boolean equal(int[] a, int s1, int e1, int s2) {
        for (int i = s1, j = s2; i < e1; i++, j++) {
            if (a[i] != a[j]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        gogo(0);
    }
}