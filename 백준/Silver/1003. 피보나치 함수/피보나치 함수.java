//#include <iostream>
//
//int fibonacci(int n) {
//static int mem[41] = { 0 };
//        if (mem[n] > 0) return mem[n];
//        if (n == 0) return 0;
//        if (n == 1 || n == 2) return 1;
//        return mem[n] = fibonacci(n - 2) + fibonacci(n - 1);
//        }
//
//
//        int main() {
//        int T, N;
//        scanf("%d", &T);
//
//        for (int i = 0; i < T; ++i) {
//        scanf("%d", &N);
//        if (N == 0) printf("1 0\n");
//        else printf("%d %d\n", fibonacci(N - 1), fibonacci(N));
//        }
//
//        return 0;
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        int[] mem = new int[41];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 1;

        IntStream.range(3, 41).forEach(i -> mem[i] = mem[i - 1] + mem[i - 2]);

        int t = 0;
        while (t < T) {
            int N = Integer.parseInt(br.readLine());
            bw.write(N == 0 ? "1 0\n" : mem[N - 1] + " " + mem[N] + "\n");
            t++;
        }
        bw.close();
    }
}