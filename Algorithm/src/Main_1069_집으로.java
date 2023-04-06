//#include <cstdio>
//#include <cmath>
//#include <algorithm>
//
//using namespace std;
//
//        int main() {
//        int x, y, d, t; scanf("%d %d %d %d", &x, &y, &d, &t);
//        double dist = sqrt(x * x + y * y);
//        int jump = dist / d;
//        double remain = dist - jump * d;
//        //그냥 걷는 경우, 점프 하고 남은 거리 걷는 경우
//        double ans = min(dist, remain + jump * t);
//        //(0, 0) 넘어서까지 점프하고 뒤로 걷는 경우
//        ans = min(ans, (jump + 1) * d - dist + (jump + 1) * t);
//        if (jump > 0) {
//        //방향 꺾어서 점프만 하는 경우
//        ans = min(ans, double(jump + 1) * t);
//        } else {
//        //점프만 두번 하는 경우
//        if (dist < d) ans = min(ans, t * 2.0);
//        }
//        printf("%.9lf", ans);
//        }

//cpp to java

import java.io.*;
import java.util.StringTokenizer;

public class Main_1069_집으로 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int x, y, d, t;
    static double dist;
    static int jump;
    static double remain;
    static double result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        dist = Math.sqrt(x * x + y * y);
        jump = (int) (dist / d);
        remain = dist - jump * d;
        result = Math.min(dist, remain + jump * t);
        result = Math.min(result, (jump + 1) * d - dist + (jump + 1) * t);
        if (jump > 0) result = Math.min(result, (jump + 1) * t);
        else if (dist < d) result = Math.min(result, t * 2.0);

        bw.write(String.format("%.9f", result));
        bw.flush();
    }
}