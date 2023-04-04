import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1088_케이크 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Info implements Comparable<Info> {
        double val;
        int idx;
        int cnt;

        public Info(double val, int idx, int cnt) {
            this.val = val;
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            return Double.compare(o.val, this.val);
        }
    }

    static double sol(double[] v, int m) {
        int n = v.length;
        Info[] infos = IntStream.range(0, n).mapToObj(i -> new Info(v[i], i, 1)).toArray(Info[]::new);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (infos[i].val < infos[j].val) {
                    Info tmp = infos[i];
                    infos[i] = infos[j];
                    infos[j] = tmp;
                }
            }
        }

        double dMax = Double.MAX_VALUE;

        for (double value : v) dMax = Math.min(dMax, value);

        double res = infos[0].val - dMax;

        for (int i = 0; i < m; i++) {
            double val;
            int idx = infos[0].idx;
            int cnt = infos[0].cnt;

            infos[0] = null;
            val = v[idx] / (cnt + 1);
            infos[0] = new Info(val, idx, cnt + 1);

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (infos[j].val < infos[k].val) {
                        Info tmp = infos[j];
                        infos[j] = infos[k];
                        infos[k] = tmp;
                    }
                }
            }

            dMax = Double.MAX_VALUE;

            for (int j = 0; j < n; j++) dMax = Math.min(dMax, infos[j].val);
            res = Math.min(res, infos[0].val - dMax);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        double[] v = IntStream.range(0, N).mapToDouble(i -> Double.parseDouble(st.nextToken())).toArray();

        int M = Integer.parseInt(br.readLine());
        bw.write(String.format("%.12f", sol(v, M)));
        bw.close();
    }
}