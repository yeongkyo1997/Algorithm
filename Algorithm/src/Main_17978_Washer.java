//#include <stdio.h>
//        #include <vector>
//#include <algorithm>
//
//struct info {
//        long long x, y, z;
//        info(long long x = 0, long long y = 0, long long z = 0) : x(x), y(y), z(z) {}
//        };
//
//        info input[110];
//
//        double func(const std::vector<info> &v) {
//        long long xhap = 0, yhap = 0, zhap = 0;
//        double result = 0;
//
//        for (int i = 0; i < v.size(); i++) {
//        xhap += v[i].x;
//        yhap += v[i].y;
//        zhap += v[i].z;
//        }
//
//        for (int i = 0; i < v.size(); i++) {
//        double tmpx = v[i].x - (double)xhap / v.size(), tmpy = v[i].y - (double)yhap / v.size(), tmpz = v[i].z - (double)zhap / v.size();
//        result += tmpx * tmpx + tmpy * tmpy + tmpz * tmpz;
//        }
//        return result;
//        }
//
//        long long ccw(info tmp1, info tmp2) {
//        return tmp1.x * tmp2.x + tmp1.y * tmp2.y + tmp1.z * tmp2.z;
//        }
//
//        info external(info a, info b, info c) {
//        info tmp1, tmp2;
//        tmp1.x = b.x - a.x; tmp1.y = b.y - a.y; tmp1.z = b.z - a.z;
//        tmp2.x = c.x - a.x; tmp2.y = c.y - a.y; tmp2.z = c.z - a.z;
//
//        info result;
//        result.x = tmp1.y * tmp2.z - tmp1.z * tmp2.y;
//        result.y = tmp1.z * tmp2.x - tmp1.x * tmp2.z;
//        result.z = tmp1.x * tmp2.y - tmp1.y * tmp2.x;
//
//        return result;
//        }
//
//        int main(void) {
//        int n, ss;
//        scanf("%d %d", &n, &ss);
//
//        for (int i = 1; i <= n; i++)
//        scanf("%lld %lld %lld", &input[i].x, &input[i].y, &input[i].z);
//
//        if (n == 1 || (n == 2 && ss == 2)) {
//        printf("%lf\n", (double)0);
//        return 0;
//        }
//
//        double result = -1;
//        if (ss >= 1) {
//        std::vector<info> v;
//
//        for (int i = 1; i <= n; i++)
//        v.push_back(input[i]);
//        result = func(v);
//        }
//        if (ss >= 2) {
//        for (int i = 1; i <= n; i++) {
//        for (int j = i + 1; j <= n; j++) {
//        for (int k = j + 1; k <= n; k++) {
//        std::vector<info> a, b;
//        info ex = external(input[i], input[j], input[k]);
//
//        for (int t = 1; t <= n; t++) {
//        if (t == i || t == j || t == k)
//        continue;
//        info tmp;
//        tmp.x = input[t].x - input[i].x;
//        tmp.y = input[t].y - input[i].y;
//        tmp.z = input[t].z - input[i].z;
//
//        if (ccw(ex, tmp) < 0)
//        a.push_back(input[t]);
//        else
//        b.push_back(input[t]);
//        }
//
//        std::vector<info> ttmp;
//        ttmp.push_back(input[i]);
//        ttmp.push_back(input[j]);
//        ttmp.push_back(input[k]);
//
//        a.push_back(ttmp[0]);
//        a.push_back(ttmp[1]);
//        a.push_back(ttmp[2]);
//        result = std::min(result, func(a) + func(b));
//        a.pop_back();
//        a.pop_back();
//        a.pop_back();
//
//        a.push_back(ttmp[0]);
//        a.push_back(ttmp[1]);
//        b.push_back(ttmp[2]);
//        result = std::min(result, func(a) + func(b));
//        a.pop_back();
//        a.pop_back();
//        b.pop_back();
//
//        a.push_back(ttmp[0]);
//        b.push_back(ttmp[1]);
//        a.push_back(ttmp[2]);
//        result = std::min(result, func(a) + func(b));
//        a.pop_back();
//        b.pop_back();
//        a.pop_back();
//
//        b.push_back(ttmp[0]);
//        a.push_back(ttmp[1]);
//        a.push_back(ttmp[2]);
//        result = std::min(result, func(a) + func(b));
//        b.pop_back();
//        a.pop_back();
//        a.pop_back();
//
//        a.push_back(ttmp[0]);
//        b.push_back(ttmp[1]);
//        b.push_back(ttmp[2]);
//        result = std::min(result, func(a) + func(b));
//        a.pop_back();
//        b.pop_back();
//        b.pop_back();
//
//        b.push_back(ttmp[0]);
//        a.push_back(ttmp[1]);
//        b.push_back(ttmp[2]);
//        result = std::min(result, func(a) + func(b));
//        b.pop_back();
//        a.pop_back();
//        b.pop_back();
//
//        b.push_back(ttmp[0]);
//        b.push_back(ttmp[1]);
//        a.push_back(ttmp[2]);
//        result = std::min(result, func(a) + func(b));
//        b.pop_back();
//        b.pop_back();
//        a.pop_back();
//
//
//        b.push_back(ttmp[0]);
//        b.push_back(ttmp[1]);
//        b.push_back(ttmp[2]);
//        result = std::min(result, func(a) + func(b));
//        b.pop_back();
//        b.pop_back();
//        b.pop_back();
//        }
//        }
//        }
//
//        }
//
//        long long qas = result * 10000000;
//        if (qas % 10 >= 5)
//        result += 0.0000001;
//        printf("%.6lf\n", result);
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17978_Washer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Info {
        long x, y, z;

        public Info(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

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
                        aidx -= 1;

                        b[bidx++] = ttmp[0];
                        b[bidx++] = ttmp[1];
                        b[bidx++] = ttmp[2];
                        result = Math.min(result, func(a) + func(b));
                        bidx -= 3;
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
        double result = 0;
        double ab = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
        double bc = Math.sqrt(Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2) + Math.pow(b.z - c.z, 2));
        double ca = Math.sqrt(Math.pow(c.x - a.x, 2) + Math.pow(c.y - a.y, 2) + Math.pow(c.z - a.z, 2));

        double s = (ab + bc + ca) / 2;
        double area = Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
        double height = area * 2 / ab;

        result = height;

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
        long result = 0;

        result = a.x * b.y - a.y * b.x;

        return result;
    }
}
