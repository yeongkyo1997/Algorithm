import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1044_팀_선발 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] s1;
    static int[] s2;

    static int cntBit(int a) {
        int ret = 0;
        while (a > 0) {
            if ((a & 1) == 1) ret++;
            a >>= 1;
        }
        return ret;
    }


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        s1 = new int[N];
        s2 = new int[N];
        st = new StringTokenizer(br.readLine());

        IntStream.range(0, N).forEach(i -> s1[i] = Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, N).forEach(i -> s2[i] = Integer.parseInt(st.nextToken()));

        int len1 = N / 2;
        int len2 = N - len1;
        int[] M1 = new int[1 << len1];
        int[] M2 = new int[1 << len2];

        for (int i = 0; i < (1 << len1); i++) {
            int val = 0;

            for (int j = 0; j < len1; j++)
                val += (i & (1 << (len1 - 1 - j))) > 0 ? s2[j] : -s1[j];

            M1[i] = val;
        }

        for (int i = 0; i < (1 << len2); i++) {
            int val = 0;

            for (int j = 0; j < len2; j++)
                val += (i & (1 << (len2 - 1 - j))) > 0 ? s2[len1 + j] : -s1[len1 + j];

            M2[i] = val;
        }
        int diff = Integer.MAX_VALUE;
        int select = Integer.MAX_VALUE;

        for (int i = 0; i < (1 << len1); i++) {
            int val = M1[i];
            int cnt = cntBit(i);

            if (cnt > N / 2) continue;

            int idx = lowerBound(M2, N / 2 - cnt, val);
            int curDiff = Math.abs(val + M2[idx]);
            int curSelect = (i << len1) | idx;

            if (diff > curDiff || (diff == curDiff && select > curSelect)) {
                diff = curDiff;
                select = curSelect;
            }

            idx = lowerBound(M2, N / 2 - cnt, val) - 1;

            curDiff = Math.abs(val + M2[idx]);
            curSelect = (i << len1) | idx;

            if (diff > curDiff || (diff == curDiff && select > curSelect)) {
                diff = curDiff;
                select = curSelect;
            }
        }

        for (int i = 0; i < N; i++)
            bw.write((select & (1 << (N - 1 - i))) > 0 ? "2" : "1");

        bw.close();
    }

    static int lowerBound(int[] arr, int cnt, int val) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;

            if (cntBit(mid) == cnt && arr[mid] >= val) r = mid;
            else l = mid + 1;

        }
        return l;
    }
}
