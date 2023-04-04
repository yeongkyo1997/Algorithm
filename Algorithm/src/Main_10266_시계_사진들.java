import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10266_시계_사진들 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        boolean[] clock1 = new boolean[360000];
        boolean[] clock2 = new boolean[360000];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            clock1[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            clock2[Integer.parseInt(st.nextToken())] = true;
        }

        boolean[] clock1_2 = new boolean[720000];
        for (int i = 0; i < 360000; i++) {
            clock1_2[i] = clock1[i];
            clock1_2[i + 360000] = clock1[i];
        }

        if (kmp(clock1_2, clock2)) {
            bw.write("possible");
        } else {
            bw.write("impossible");
        }

        bw.flush();
        bw.close();
    }

    static boolean kmp(boolean[] s, boolean[] p) {
        int[] table = getPi(p);

        int j = 0;
        for (boolean b : s) {
            while (j > 0 && b != p[j]) {
                j = table[j - 1];
            }

            if (b == p[j]) {
                if (j == p.length - 1) {
                    return true;
                } else {
                    j++;
                }
            }
        }

        return false;
    }

    static int[] getPi(boolean[] p) {
        int[] tmp = new int[p.length];

        int j = 0;
        for (int i = 1; i < p.length; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = tmp[j - 1];
            }

            if (p[i] == p[j]) {
                j++;
                tmp[i] = j;
            }
        }

        return tmp;
    }
}