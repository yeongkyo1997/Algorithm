//#include<iostream>
//
//long long a[1500050];
//        int INF = 1000000;
//
//        void fibonacci() {
//        a[0] = 0;
//        a[1] = 1;
//        for (int i = 0; i < 1500000; i++) {
//        a[i + 2] = (a[i + 1] + a[i]) % INF;
//        }
//        }
//
//        int main() {
//        long long n;
//        std::cin >> n;
//        fibonacci();
//        std::cout << a[n%1500000] << "\n";
//
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2749_피보나치_수_3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int INF = 1000000;
    static long[] a = new long[1500050];

    static void fibonacci() {
        a[0] = 0;
        a[1] = 1;
        for (int i = 0; i < 1500000; i++) {
            a[i + 2] = (a[i + 1] + a[i]) % INF;
        }
    }

    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(br.readLine());
        fibonacci();
        bw.write(a[(int) (n % 1500000)] + "\n");
        bw.close();
    }
}