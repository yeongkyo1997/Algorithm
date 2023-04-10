//#include <bits/stdc++.h>
//        using namespace std;
//        int main() {
//        ios::sync_with_stdio(0);
//        cin.tie(0);
//
//        int n, q;
//        cin >> n >> q;
//        vector<vector<vector<int>>> floyd(
//        n + 1, vector<vector<int>>(n + 1, vector<int>(n + 1, 0x3f3f3f3f)));
//        for (int i = 1; i <= n; i++) {
//        for (int j = 1; j <= n; j++) {
//        int v;
//        cin >> v;
//        floyd[0][i][j] = v == 0 ? 0x3f3f3f3f : v;
//        }
//        }
//        for (int i = 1; i <= n; i++)
//        floyd[0][i][i] = 0;
//
//        for (int k = 1; k <= n; k++) {
//        for (int i = 1; i <= n; i++) {
//        for (int j = 1; j <= n; j++) {
//        floyd[k][i][j] = min(floyd[k - 1][i][j], floyd[k - 1][i][k] + floyd[k - 1][k][j]);
//        }
//        }
//        }
//
//        while (q--) {
//        int c, s, e;
//        cin >> c >> s >> e;
//        if (floyd[c - 1][s][e] == 0x3f3f3f3f)
//        cout << "-1\n";
//        else
//        cout << floyd[c - 1][s][e] << "\n";
//        }
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, Q;
    static int[][][] floyd;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        floyd = new int[N + 1][N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int v = Integer.parseInt(st.nextToken());
                floyd[0][i][j] = v == 0 ? 0x3f3f3f3f : v;
            }
        }
        for (int i = 1; i <= N; i++)
            floyd[0][i][i] = 0;

        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    floyd[k][i][j] = Math.min(floyd[k - 1][i][j], floyd[k - 1][i][k] + floyd[k - 1][k][j]);

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(floyd[c - 1][s][e] == 0x3f3f3f3f ? "-1\n" : floyd[c - 1][s][e] + "\n");
        }

        bw.close();
    }
}