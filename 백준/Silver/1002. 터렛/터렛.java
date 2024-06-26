//import math
//
//n = int(input())
//
//        for _ in range(n):
//        x1, y1, r1, x2, y2, r2 = map(int, input().split())
//        distance = math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
//
//        if distance == 0 and r1 == r2:
//        print(-1)
//        elif abs(r1 - r2) == distance or r1 + r2 == distance:
//        print(1)
//        elif abs(r1 - r2) < distance < (r1 + r2):
//        print(2)
//        else:
//        print(0)


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//py3 to java
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

            if (distance == 0 && r1 == r2) {
                bw.write("-1\n");
            } else if (Math.abs(r1 - r2) == distance || r1 + r2 == distance) {
                bw.write("1\n");
            } else if (Math.abs(r1 - r2) < distance && distance < (r1 + r2)) {
                bw.write("2\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.close();
    }
}