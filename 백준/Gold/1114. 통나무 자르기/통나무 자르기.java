import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int L, K, C, cut;
    static int[] cutPoint;

    static int cutWood(int cutLen) {
        int lastLen = L, cnt = 0, minPoint = 0;
        for (int i = K - 1; i >= 0; i--) {
            if (lastLen - cutPoint[i] > cutLen) {
                if (i == K - 1) return 0;
                lastLen = cutPoint[i + 1];
                if (lastLen - cutPoint[i] > cutLen) return 0;
                cnt++;
                minPoint = cutPoint[i + 1];
            }
            if (cnt >= C) break;
        }
        if (cnt < C) {
            minPoint = cutPoint[0];
        }
        if (minPoint > cutLen) return 0;
        return minPoint;
    }

    static int getLen() {
        int left = 1, right = L, ret = 0;
        for (int i = 0; i < 30; i++) {
            int minLen = (left + right) / 2;
            int minPoint = cutWood(minLen);
            if (minPoint == 0) left = minLen + 1;
            else {
                ret = minLen;
                cut = minPoint;
                right = minLen - 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cutPoint = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) cutPoint[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K - 1; i++) {
            for (int j = i + 1; j < K; j++) {
                if (cutPoint[i] > cutPoint[j]) {
                    int tmp = cutPoint[i];
                    cutPoint[i] = cutPoint[j];
                    cutPoint[j] = tmp;
                }
            }
        }
        bw.write(getLen() + " " + cut + "\n");
        bw.close();
    }
}