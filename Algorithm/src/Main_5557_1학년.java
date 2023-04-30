//#include <iostream>
//
//using namespace std;
//
//        int N;
//
//        int arr[101];
//        long long dp[101][21]; //N번째에 K값이 나오는 경우의 수
//
//
//        int main(){
//        long long ans; //답의 범위가 2^63-1임
//
//        cin >> N;
//        for(int i =1; i<=N; i++){
//        cin >> arr[i];
//        }
//
//        int target = arr[N];
//
//
//        //초기값
//        dp[1][arr[1]] = 1; //가장 처음의 수는 무조건 들어감 (1개)
//
//        for(int i = 2; i<=N-1; i++){
//        for(int j = 0; j<=20; j++){
//        if(dp[i-1][j] == 0)continue; //해당 값을 가지는 결과가 없으면 넘어감
//
//        //현재 위치의 값을 더해서 범위 안에 있다면 이전에 해당 값을 가지는 경우가 다 더해짐.
//        if(j + arr[i] <= 20){
//        dp[i][j+arr[i]] += dp[i-1][j];
//        }
//        //이하 동문 (빼서)
//        if(j - arr[i] >= 0){
//        dp[i][j-arr[i]] += dp[i-1][j];
//        }
//        }
//        }
//
//        ans = dp[N-1][target]; //target의 값과 같은 경우의 수
//
//        cout << ans;
//
//
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

public class Main_5557_1학년 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new long[N + 1][21];

        st = new StringTokenizer(br.readLine());
        IntStream.rangeClosed(1, N).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        int target = arr[N];

        dp[1][arr[1]] = 1;

        for (int i = 2; i <= N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] == 0) continue;

                if (j + arr[i] <= 20) dp[i][j + arr[i]] += dp[i - 1][j];

                if (j - arr[i] >= 0) dp[i][j - arr[i]] += dp[i - 1][j];
            }
        }

        long result = dp[N - 1][target];

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}