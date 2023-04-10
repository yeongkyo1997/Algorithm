import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1019_책_페이지 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10];

        solve(n, cnt);

        for (int i = 0; i < 10; i++) {
            bw.write(cnt[i] + " ");
        }
        bw.flush();
    }

    static void solve(int end, int[] count) {
        int start = 1;
        int tenPower = 1;

        while (start <= end) {
            while (start % 10 != 0 && start <= end) {
                subCounting(start, count, tenPower);
                start++;
            }

            if (end < start) return;

            while (end % 10 != 9 && start <= end) {
                subCounting(end, count, tenPower);
                end--;
            }

            start /= 10;
            end /= 10;

            for (int i = 0; i < 10; i++) {
                count[i] += (end - start + 1) * tenPower;
            }
            tenPower *= 10;
        }
    }

    static void subCounting(int num, int[] count, int tenPower) {
        while (num != 0) {
            count[num % 10] += tenPower;
            num /= 10;
        }
    }
}