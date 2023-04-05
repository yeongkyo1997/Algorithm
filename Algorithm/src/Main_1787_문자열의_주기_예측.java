//#include <bits/stdc++.h>
//        #define rep(i,n) for(int i=0;i<n;++i)
//        #define REP(i,n) for(int i=1;i<=n;++i)
//        #define FAST cin.tie(NULL);cout.tie(NULL); ios::sync_with_stdio(false)
//        using namespace std;
//
//        int fail[1000000];
//        int cache[1000000];
//        int N;
//        string S;
//        long long ans;
//        int main() {
//        FAST;
//        cin >> N >> S;
//        for (int i = 1, j = 0;i < N;++i) {
//        while (j && S[i] != S[j]) j = fail[j - 1];
//        if (S[i] == S[j]) fail[i] = ++j;
//
//        int k = i + 1;
//        cache[i] = (fail[fail[k - 1] - 1] > 0 ? cache[fail[k - 1] - 1] : fail[k - 1]);
//        if (!cache[i]) continue;
//        if (i + 1 - cache[i] >= cache[i])
//        ans += i + 1 - cache[i];
//        }
//        cout << ans;
//        return 0;
//        }

import java.io.*;
import java.util.StringTokenizer;

//cpp to java
public class Main_1787_문자열의_주기_예측 {
    static int N;
    static String S;
    static int[] fail;
    static int[] cache;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = br.readLine();
        fail = new int[N];
        cache = new int[N];
        for (int i = 1, j = 0; i < N; ++i) {
            while (j > 0 && S.charAt(i) != S.charAt(j)) j = fail[j - 1];
            if (S.charAt(i) == S.charAt(j)) fail[i] = ++j;
            int k = i + 1;
            cache[i] = (fail[fail[k - 1] - 1] > 0 ? cache[fail[k - 1] - 1] : fail[k - 1]);
            if (cache[i] == 0) continue;
            if (i + 1 - cache[i] >= cache[i]) ans += i + 1 - cache[i];
        }
        bw.write(ans + "\n");
        bw.close();
    }
}