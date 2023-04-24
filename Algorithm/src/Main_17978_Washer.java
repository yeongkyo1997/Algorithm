import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17978_Washer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Info[] input = new Info[1001];
    static int n, ss;
    static double result = -1;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ss = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = new Info(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        if (n == 1 || (n == 2 && ss == 2)) {
            System.out.println(0);
            return;
        }

        if (ss >= 1) {
            result = func(input);
        }
        if (ss >= 2) {
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    for (int k = j + 1; k <= n; k++) {
                        Info[] a = new Info[1001];
                        Info[] b = new Info[1001];
                        Info ex = external(input[i], input[j], input[k]);

                        int aidx = 0;
                        int bidx = 0;
                        for (int t = 1; t <= n; t++) {
                            if (t == i || t == j || t == k) continue;
                            Info tmp = new Info(input[t].x - input[i].x, input[t].y - input[i].y, input[t].z - input[i].z);

                            if (ccw(ex, tmp) < 0) a[aidx++] = input[t];
                            else b[bidx++] = input[t];
                        }

                        Info[] ttmp = new Info[3];
                        ttmp[0] = input[i];
                        ttmp[1] = input[j];
                        ttmp[2] = input[k];

                        a[aidx++] = ttmp[0];
                        a[aidx++] = ttmp[1];
                        a[aidx++] = ttmp[2];
                        result = Math.min(result, func(a) + func(b));
                        aidx -= 3;

                        a[aidx++] = ttmp[0];
                        a[aidx++] = ttmp[1];
                        b[bidx++] = ttmp[2];
                        result = Math.min(result, func(a) + func(b));
                        aidx -= 2;
                        bidx -= 1;

                        a[aidx++] = ttmp[0];
                        b[bidx++] = ttmp[1];
                        a[aidx++] = ttmp[2];
                        result = Math.min(result, func(a) + func(b));
                        aidx -= 1;
                        bidx -= 1;

                        b[bidx++] = ttmp[0];
                        a[aidx++] = ttmp[1];
                        a[aidx++] = ttmp[2];
                        result = Math.min(result, func(a) + func(b));
                        bidx -= 1;
                        aidx -= 2;

                        b[bidx++] = ttmp[0];
                        b[bidx++] = ttmp[1];
                        a[aidx++] = ttmp[2];
                        result = Math.min(result, func(a) + func(b));
                        bidx -= 2;

                        b[bidx++] = ttmp[0];
                        b[bidx++] = ttmp[1];
                        b[bidx++] = ttmp[2];
                        result = Math.min(result, func(a) + func(b));
                    }
                }
            }
        }

        long qas = (long) (result * 10000000);
        if (qas % 10 >= 5) result += 0.0000001;
        System.out.printf("%.6f\n", result);
    }

    static double func(Info[] arr) {
        double result = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == null) break;
            len++;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                for (int k = j + 1; k <= len; k++) {
                    result = Math.max(result, dist(arr[i], arr[j], arr[k]));
                }
            }
        }

        return result;
    }

    static double dist(Info a, Info b, Info c) {
        double result;
        double ab = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
        double bc = Math.sqrt(Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2) + Math.pow(b.z - c.z, 2));
        double ca = Math.sqrt(Math.pow(c.x - a.x, 2) + Math.pow(c.y - a.y, 2) + Math.pow(c.z - a.z, 2));

        double s = (ab + bc + ca) / 2;
        double area = Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));

        result = area * 2 / ab;

        return result;
    }

    static Info external(Info a, Info b, Info c) {
        Info result = new Info(0, 0, 0);

        result.x = (b.y - a.y) * (c.z - a.z) - (b.z - a.z) * (c.y - a.y);
        result.y = (b.z - a.z) * (c.x - a.x) - (b.x - a.x) * (c.z - a.z);
        result.z = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);

        return result;
    }

    static long ccw(Info a, Info b) {
        long result;

        result = a.x * b.y - a.y * b.x;

        return result;
    }

    static class Info {
        long x, y, z;

        public Info(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
