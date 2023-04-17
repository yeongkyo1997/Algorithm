//#include<cstdio>
//int n, r;
//        int main() {
//        scanf("%d", &n);
//        for (int i = 1; i <= n; i *= 10)
//        r += n - i + 1;
//        printf("%d", r);
//        return 0;
//        }

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//cpp to java
public class Main_1748_수_이어_쓰기_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, r;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i *= 10)
            r += n - i + 1;
        bw.write(r + "\n");
        bw.close();
    }
}