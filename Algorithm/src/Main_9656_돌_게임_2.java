//#include <iostream>
//
//#define endl "\n"
//        #define MAX 1010
//        using namespace std;
//
//        int N;
//        int DP[MAX];
//
//        void Input()
//        {
//        cin >> N;
//        }
//
//        void Solution()
//        {
//        DP[1] = 0;
//        DP[2] = 1;
//        DP[3] = 0;
//        for (int i = 4; i <= N; i++)
//        {
//        if (DP[i - 1] == 0 || DP[i - 3] == 0) DP[i] = 1;
//        else DP[i] = 0;
//        }
//
//        if (DP[N] == 1) cout << "SK" << endl;
//        else cout << "CY" << endl;
//        }
//
//        void Solve()
//        {
//        Input();
//        Solution();
//        }
//
//        int main(void)
//        {
//        ios::sync_with_stdio(false);
//        cin.tie(NULL);
//        cout.tie(NULL);
//
//        //freopen("Input.txt", "r", stdin);
//        Solve();
//
//        return 0;
//        }


//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9656_돌_게임_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] DP = new int[1010];


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        DP[1] = 0;
        DP[2] = 1;
        DP[3] = 0;

        for (int i = 4; i <= N; i++) DP[i] = DP[i - 1] == 0 || DP[i - 3] == 0 ? 1 : 0;

        bw.write(DP[N] == 1 ? "SK\n" : "CY\n");

        bw.close();
    }
}