import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2261_가장_가까운_두_점 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static long[][] point;
    static long minDist;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        point = new long[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Long.parseLong(st.nextToken());
            point[i][1] = Long.parseLong(st.nextToken());
        }

        minDist = Long.MAX_VALUE;

        dac(0, N - 1);

        bw.write(minDist + "\n");
        bw.close();
    }

    static long dac(int left, int right) {
        if (right - left == 0) return 0;
        if (right - left == 1) {
            long dist = (point[right][0] - point[left][0]) * (point[right][0] - point[left][0]) + (point[right][1] - point[left][1]) * (point[right][1] - point[left][1]);
            return dist;
        }

        int mid = (left + right) / 2;

        minDist = Math.min(dac(left, mid), dac(mid, right));

        long[][] targets = new long[right - left + 1][2];
        int tIdx = 0;
        for (int i = left; i <= right; i++) {
            if ((point[mid][0] - point[i][0]) * (point[mid][0] - point[i][0]) < minDist) {
                targets[tIdx][0] = point[i][0];
                targets[tIdx][1] = point[i][1];
                tIdx++;
            }
        }

        for (int i = 0; i < tIdx - 1; i++) {
            for (int j = i + 1; j < tIdx; j++) {
                if ((targets[i][1] - targets[j][1]) * (targets[i][1] - targets[j][1]) < minDist) {
                    minDist = Math.min(minDist, (targets[i][0] - targets[j][0]) * (targets[i][0] - targets[j][0]) + (targets[i][1] - targets[j][1]) * (targets[i][1] - targets[j][1]));
                } else {
                    break;
                }
            }
        }

        return minDist;
    }
}
