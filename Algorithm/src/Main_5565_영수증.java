//#include <stdio.h>
//
//        int main() {
//
//        int n,a;
//        int sum=0;
//        scanf("%d",&n);
//
//        for(int i=0; i<9; i++){
//        scanf("%d",&a);
//        sum+=a;
//        }
//
//        printf("%d",n-sum);
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5565_영수증 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        bw.write(String.valueOf(n - sum));
        bw.close();
    }
}