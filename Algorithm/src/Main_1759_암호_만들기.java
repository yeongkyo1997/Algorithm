import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호_만들기 {
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
        list = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++)
            list[i] = st.nextToken().charAt(0);

        print = new char[L];
        Arrays.sort(list);
        perm(0, 0, 0, 0);
        bw.close();
    }

    static void perm(int start, int depth, int cnt1, int cnt2) throws IOException {
        if (depth == L) {
            {
                if (cnt1 >= 1 && cnt2 >= 2) {
                    for (char c : print)
                        bw.write(c + "");
                    bw.write("\n");
                }
            }
            return;
        }

        for (int i = start; i < C; i++) {
            print[depth] = list[i];
            if (vowel.contains(String.valueOf(list[i]))) perm(i + 1, depth + 1, cnt1 + 1, cnt2);
            else perm(i + 1, depth + 1, cnt1, cnt2 + 1);
        }
    }
}
