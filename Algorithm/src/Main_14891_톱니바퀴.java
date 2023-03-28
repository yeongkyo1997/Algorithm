//#include <iostream>
//#include <cstring>
//
//using namespace std;
//        string gear[4];
//        int isRotate[4];
//
//        void init() {
//        for (int i = 0; i < 4; i++)
//        isRotate[i] = 0;
//        }
//
//        void move(int idx, int clock) {
//        if (clock == 1)
//        gear[idx] = gear[idx].substr(7) + gear[idx].substr(0, 7);
//        else if(clock == -1)
//        gear[idx] = gear[idx].substr(1, 7) + gear[idx].substr(0, 1);
//        }
//
//        void left_check(int idx, int clock) {
//        if (idx <= 0) return;
//        if (gear[idx][6] != gear[idx - 1][2]) {
//        isRotate[idx - 1] = clock * -1;
//        left_check(idx - 1, clock * -1);
//        }
//        }
//
//        void right_check(int idx, int clock) {
//        if (idx >= 3) return;
//        if (gear[idx][2] != gear[idx + 1][6]) {
//        isRotate[idx + 1] = clock * -1;
//        right_check(idx + 1, clock * -1);
//        }
//        }
//
//        void check(int idx, int clock) {
//        isRotate[idx] = clock;
//        left_check(idx, clock);
//        right_check(idx, clock);
//
//        for(int i = 0; i < 4; i++)
//        move(i, isRotate[i]);
//        }
//
//
//        int main() {
//        int ans = 0;
//        for (int i = 0; i < 4; i++) {
//        cin >> gear[i];
//        }
//        int k;
//        int g; int r;
//        cin >> k;
//        for (int i = 0; i < k; i++) {
//        cin >> g >> r;
//        init();
//        check(g - 1, r);
//        }
//        int mul = 1;
//        for (int i = 0; i < 4; i++) {
//        ans += (gear[i][0] - '0') * mul;
//        mul *= 2;
//        }
//
//        cout << ans;
//        }

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//cpp to java
public class Main_14891_톱니바퀴 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String[] gear = new String[4];
    static int[] isRotate = new int[4];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 4; i++)
            gear[i] = br.readLine();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            init();
            check(g - 1, r);
        }
        int ans = 0;
        int mul = 1;
        for (int i = 0; i < 4; i++) {
            ans += (gear[i].charAt(0) - '0') * mul;
            mul *= 2;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    static void init() {
        for (int i = 0; i < 4; i++)
            isRotate[i] = 0;
    }

    static void move(int idx, int clock) {
        if (clock == 1)
            gear[idx] = gear[idx].substring(7) + gear[idx].substring(0, 7);
        else if (clock == -1)
            gear[idx] = gear[idx].substring(1, 7) + gear[idx].substring(0, 1);
    }

    static void left_check(int idx, int clock) {
        if (idx <= 0)
            return;
        if (gear[idx].charAt(6) != gear[idx - 1].charAt(2)) {
            isRotate[idx - 1] = clock * -1;
            left_check(idx - 1, clock * -1);
        }
    }

    static void right_check(int idx, int clock) {
        if (idx >= 3)
            return;
        if (gear[idx].charAt(2) != gear[idx + 1].charAt(6)) {
            isRotate[idx + 1] = clock * -1;
            right_check(idx + 1, clock * -1);
        }
    }

    static void check(int idx, int clock) {
        isRotate[idx] = clock;
        left_check(idx, clock);
        right_check(idx, clock);

        for (int i = 0; i < 4; i++)
            move(i, isRotate[i]);
    }
}