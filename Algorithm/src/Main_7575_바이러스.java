import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_7575_바이러스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, k;
    static String[] text;
    static int[] table;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        text = new String[n];

        for (int i = 0; i < n; i++) {
            br.readLine();
            text[i] = br.readLine();
        }

        for (int i = 0; i < text[0].length() - k + 1; i++) {
            table = getPi(text[0].substring(i, i + k));
            for (int j = 1; j < n; j++) {
                if (KMP(text[j], text[0].substring(i, i + k), table) == 0) {
                    if (KMP(new StringBuilder(text[j]).reverse().toString(), text[0].substring(i, i + k), table) == 0) {
                        break;
                    }
                }
                if (j == n - 1) {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
        }
        System.out.println("NO");
    }

    static int[] getPi(String tmp) {
        int[] table = new int[k];
        int i = 0;
        for (int j = 1; j < k; j++) {
            while (i > 0 && tmp.charAt(i) != tmp.charAt(j)) {
                i = table[i - 1];
            }
            if (tmp.charAt(i) == tmp.charAt(j)) {
                i++;
            }
            table[j] = i;
        }
        return table;
    }

    static int KMP(String string, String find, int[] temp) {
        int i = 0;
        for (int j = 0; j < string.length(); j++) {
            while (i > 0 && string.charAt(j) != find.charAt(i)) {
                i = temp[i - 1];
            }
            if (string.charAt(j) == find.charAt(i)) {
                if (i == k - 1) {
                    return 1;
                } else {
                    i++;
                }
            }
        }
        return 0;
    }
}