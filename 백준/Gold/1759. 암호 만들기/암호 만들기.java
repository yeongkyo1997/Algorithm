import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int L;
    private static int C;
    static char[] print;
    private static char[] list;
    static String vowel = "aeiou";

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        print = new char[L];
        list = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < C; i++) {
            for (int j = i + 1; j < C; j++) {
                if (list[i] > list[j]) {
                    char temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }

        combi(0, 0, 0, 0, 0);

        bw.close();
    }

    static void combi(int depth, int idx, int flag, int cnt1, int cnt2) throws IOException {
        if (depth == L) {
            if (cnt1 >= 1 && cnt2 >= 2) {
                for (int i = 0; i < L; i++) {
                    bw.write(print[i] + "");
                }
                bw.write("\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            if ((flag & 1 << i) != 0) continue;
            print[depth] = list[i];
            if (vowel.contains(String.valueOf(list[i]))) {
                combi(depth + 1, i, flag | 1 << i, cnt1 + 1, cnt2);
            } else {
                combi(depth + 1, i, flag | 1 << i, cnt1, cnt2 + 1);
            }
        }
    }
}