package A형_역테_그리디;

import java.io.*;
import java.util.StringTokenizer;


public class Main_2839_설탕_배달 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while (N > 0) {
            if (N % 5 == 0) { // 5로 나누어 떨어지면
                result += N / 5;
                N = 0;
            } else { // 5로 나누어 떨어지지 않으면
                N -= 3;
                result++;
            }
        }

        if (N != 0) bw.write(-1 + " "); // 3과 5로 나누어 떨어지지 않는 경우
        else bw.write(String.valueOf(result)); // 3과 5로 나누어 떨어지는 경우
        bw.close();
    }
}
