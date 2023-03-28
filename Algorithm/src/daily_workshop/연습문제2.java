package daily_workshop;

import java.io.*;
import java.util.StringTokenizer;

public class 연습문제2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

//        1cm 짜리 파란 막대와 1cm 짜리 노란 막대 그리고 2cm 짜리 빨간 막대가 있다.
//                이 막대들을 연결하여 길이가 ncm인 막대를 만드는 방법의 수를 f(n)이라 하자.
//        예를 들면 2cm 막대를 만드는 방법은
//        (파란 막대, 파란 막대),
//        (파란 막대, 노란 막대),
//        (노란 막대, 파란 막대),
//        (노란 막대, 노란 막대),
//        (빨간 막대)
//        5가지이므로 f(2) = 5이다.
//                f(6)의 값은?

        int N = 6;
        int[] blue = new int[N + 1];
        int[] yellow = new int[N + 1];
        int[] red = new int[N + 1];

        blue[1] = 1;
        yellow[1] = 1;
        red[2] = 1;
        blue[2] = 2;
        yellow[2] = 2;

        for (int i = 3; i <= N; i++) {
            blue[i] = blue[i - 1] + yellow[i - 1] + red[i - 1];
            yellow[i] = yellow[i - 1] + blue[i - 1] + red[i - 1];
            red[i] = yellow[i - 2] + blue[i - 2] + red[i - 2];
        }

        bw.write((blue[N] + yellow[N] + red[N]) + "");
        bw.close();
    }
}