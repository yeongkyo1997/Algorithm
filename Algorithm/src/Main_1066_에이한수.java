//#include <bits/stdc++.h>
//        #define MEM 1006
//        #define sanic ios_base::sync_with_stdio(0)
//        #define x first
//        #define y second
//        using namespace std;
//        typedef long long ll;
//        typedef pair<ll, ll> pi;
//        const ll INF = 1e13;
//        const ll MOD = 1e9+7;
//        ll t,n,m,k,c,ans;
//        ll dp[MEM][11][11][11];
//        ll DP(ll a, ll b, ll c, ll d){
//        if(a==n) return !b;
//        ll& ret = dp[a][b][c][d];
//        if(ret!=-1) return ret;
//        ret = 0;
//        if(d<10){
//        for(int i=c; i<=9; i++){
//        if(c+d==i) ret += DP(a+1, b, c+d, d);
//        else ret += DP(a+1, b-1, i, 10);
//        ret %= MOD;
//        }
//        }
//        else{
//        for(int i=c; i<=9; i++){
//        ret += DP(a+1, b, i, i-c);
//        ret %= MOD;
//        }
//        }
//        return ret;
//        }
//        int main(){
//        sanic; cin.tie(0); cout.tie(0);
//        cin >> n >> k;
//        if(k>9){
//        cout << 0;
//        return 0;
//        }
//        memset(dp,-1,sizeof(dp));
//        for(int i=1; i<=9; i++){
//        ans += DP(1LL, k-1, i, 10);
//        ans %= MOD;
//        }
//        cout << ans;
//        }

//to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1066_에이한수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long t, n, m, k, c, ans;
    static long dp[][][][] = new long[1006][11][11][11];

    static long DP(long a, long b, long c, long d) {
        if (a == n) return b == 0 ? 1 : 0;
        long ret = dp[(int) a][(int) b][(int) c][(int) d];
        if (ret != -1) return ret;

        ret = 0;

        if (d < 10) {
            for (long i = c; i <= 9; i++) {
                if (c + d == i) ret += DP(a + 1, b, c + d, d);
                else ret += DP(a + 1, b - 1, i, 10);
                dp[(int) a][(int) b][(int) c][(int) d] = ret;
                ret %= 1000000007;
            }
        } else {
            for (long i = c; i <= 9; i++) {
                ret += DP(a + 1, b, i, i - c);
                ret %= 1000000007;
                dp[(int) a][(int) b][(int) c][(int) d] = ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (k > 9) {
            bw.write("0");
            bw.flush();
            return;
        }

        for (int i = 0; i < 1006; i++) {
            for (int j = 0; j < 11; j++) {
                for (int l = 0; l < 11; l++) {
                    Arrays.fill(dp[i][j][l], -1);
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            ans += DP(1L, k - 1, i, 10);
            ans %= 1000000007;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
