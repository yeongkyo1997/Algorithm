import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        while (true) {
            String string = br.readLine();
            if (string.equals(".")) break;

            int[] table = getPi(string);

            if (string.length() % (string.length() - table[string.length() - 1]) != 0) {
                bw.write("1\n");
            } else {
                bw.write(string.length() / (string.length() - table[string.length() - 1]) + "\n");
            }
        }
        bw.close();
    }

    static int[] getPi(String p) {
        int[] tmp = new int[p.length()];

        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = tmp[j - 1];
            }

            if (p.charAt(i) == p.charAt(j)) {
                j += 1;
                tmp[i] = j;
            }
        }

        return tmp;
    }
}