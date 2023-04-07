import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1055_끝이없음 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static final int MAX = 31;

    static String s, input;
    static int dollar, nonDollar;
    static int repeat, start, finish;

    static long[] cache = new long[MAX];
    static boolean find;

    static void searchChar(int level, int idx) throws Exception {
        long pos = 0;

        for (long i = 0; !find && i < input.length(); i++) {
            if (input.charAt((int) i) == '$') {

                if (level == 1) {
                    if (idx <= pos + cache[level] - 1) {
                        find = true;
                        bw.write(s.charAt(idx - (int) pos));
                    } else pos += cache[level];
                } else if (level > 1) {
                    if (idx <= pos + cache[level] - 1) searchChar(level - 1, idx - (int) pos);
                    else pos += cache[level];
                }
            } else {
                if (pos == idx) {
                    find = true;
                    bw.write(input.charAt((int) i));
                    return;
                } else pos++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        s = br.readLine();
        input = br.readLine();
        repeat = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        finish = Integer.parseInt(st.nextToken());

        for (long i = 0; i < input.length(); i++)
            if (input.charAt((int) i) == '$') dollar++;
            else nonDollar++;


        if (dollar < 2) {
            for (int i = start - 1; i < finish; i++) {
                if (i < s.length()) bw.write(s.charAt(i));
                else if (i >= s.length() + (input.length() - 1) * repeat) bw.write('-');
                else bw.write(input.charAt((i - s.length()) % (input.length() - 1) + 1));
            }
            bw.write("\n");
        } else {
            cache[1] = s.length();
            for (int i = 2; i <= repeat; i++) {
                cache[i] = cache[i - 1] * dollar + nonDollar;

                if (cache[i] > finish) {
                    repeat = i;
                    break;
                }
            }

            for (int i = start - 1; i < finish; i++) {
                int temp = repeat;

                if (i >= cache[temp] * dollar + nonDollar) {
                    bw.write('-');
                    continue;
                }

                while (temp > 1 && cache[temp] > i) temp--;

                find = false;
                searchChar(temp, i);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}