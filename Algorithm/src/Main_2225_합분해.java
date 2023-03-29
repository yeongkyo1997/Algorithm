//#include <stdio.h>
//
//        int main(void) {
//        int n, k;
//        int arr[201][201];
//        scanf("%d %d", &n, &k);
//        arr[1][1] = 1;
//        for(int i = 2; i < 201; i++) {
//        arr[i][1] = 1;
//        arr[1][i] = i;
//        }
//        for(int i = 2; i <= n; i++) {
//        for(int j = 2; j <= k; j++) {
//        arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000000;
//        }
//        }
//        printf("%d", arr[n][k]);
//        }

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//cpp to java
public class Main_2225_합분해 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, k;
    static int[][] arr = new int[201][201];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr[1][1] = 1;
        for (int i = 2; i < 201; i++) {
            arr[i][1] = 1;
            arr[1][i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000000;
            }
        }
        bw.write(arr[n][k] + "");
        bw.flush();
        bw.close();
    }
}