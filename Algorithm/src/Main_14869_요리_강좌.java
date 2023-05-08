//#include <cstdio>
//#include <deque>
//#include <utility>
//#include <algorithm>
//using namespace std;
//        const int INF = 1e9;
//        typedef pair<int, int> P;
//
//        int main() {
//        int N, M, S, E, T, cost[3000][6000] = {0}, except[3000], pSum[3000][6001] = { 0 };
//        scanf("%d %d %d %d %d", &N, &M, &S, &E, &T);
//        for(int i = 0; i < N; i++) {
//        for(int j = 0; j < M; j++) {
//        scanf("%d", &cost[i][j]);
//        pSum[i][j+1] = pSum[i][j] + cost[i][j];
//        }
//        for(int j = M; j < M+S; j++)
//        pSum[i][j+1] = pSum[i][j];
//        }
//        for(int i = 0; i < N; i++) {
//        scanf("%d", except + i);
//        except[i]--;
//        }
//
//        int dp[3000][6000];
//        deque<P> DQ[3000];
//        for(int i = 0; i < N; i++)
//        fill(dp[i], dp[i] + M+S, INF);
//        for(int j = 0; j < M+S; j++) {
//
//        int j0 = j - S;
//        if(j0 >= 0) {
//        P temp[3000];
//        for(int i = 0; i < N; i++)
//        temp[i] = P(dp[i][j0], i);
//        sort(temp, temp + N);
//        for(int i = 0; i < N; i++) {
//        for(int k = 0; ; k++) {
//        int val = temp[k].first, vi = temp[k].second;
//        if(val == INF) break;
//        if(vi != i && vi != except[i]) {
//        val -= pSum[i][j0+1];
//        while (!DQ[i].empty() && DQ[i].back().first > val) DQ[i].pop_back();
//        DQ[i].push_back(P(val, j0));
//        break;
//        }
//        }
//        }
//        }
//
//        for(int i = 0; i < N; i++) {
//        if(j >= S-1 && j < E) dp[i][j] = pSum[i][j+1];
//        while(!DQ[i].empty() && DQ[i].front().second < j-E)
//        DQ[i].pop_front();
//        if(!DQ[i].empty())
//        dp[i][j] = min(DQ[i].front().first + pSum[i][j+1] + T, dp[i][j]);
//        }
//        }
//
//        int result = INF;
//        for(int i = 0; i < N; i++)
//        for(int j = M-1; j < M+S; j++)
//        result = min(dp[i][j], result);
//        printf("%d\n", result);
//        }

//cpp to java


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14869_요리_강좌 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static LinkedList<int[]>[] DQ = new LinkedList[3000];

    static {
        for (int i = 0; i < 3000; i++)
            DQ[i] = new LinkedList<>();
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] cost = new int[3000][6000];
        int[] except = new int[3000];
        int[][] pSum = new int[3000][6001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
                pSum[i][j + 1] = pSum[i][j] + cost[i][j];
            }
            for (int j = M; j < M + S; j++)
                pSum[i][j + 1] = pSum[i][j];
        }
        for (int i = 0; i < N; i++) {
            except[i] = Integer.parseInt(br.readLine()) - 1;
        }

        int[][] dp = new int[3000][6000];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M + S; j++)
                dp[i][j] = Integer.MAX_VALUE;
        for (int j = 0; j < M + S; j++) {

            int j0 = j - S;
            if (j0 >= 0) {
                int[][] temp = new int[3000][2];
                for (int i = 0; i < N; i++) {
                    temp[i][0] = dp[i][j0];
                    temp[i][1] = i;
                }
                for (int i = 0; i < N; i++) {
                    for (int k = 0; ; k++) {
                        int val = temp[k][0], vi = temp[k][1];
                        if (val == Integer.MAX_VALUE) break;
                        if (vi != i && vi != except[i]) {
                            val -= pSum[i][j0 + 1];
                            while (DQ[i].size() != 0 && DQ[i].getLast()[0] > val) DQ[i].removeLast();
                            DQ[i].add(new int[]{val, j0});
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (j >= S - 1 && j < E) dp[i][j] = pSum[i][j + 1];
                while (DQ[i].size() != 0 && DQ[i].getFirst()[1] < j - E) DQ[i].removeFirst();
                if (DQ[i].size() != 0) dp[i][j] = Math.min(DQ[i].getFirst()[0] + pSum[i][j + 1] + T, dp[i][j]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++)
            for (int j = M - 1; j < M + S; j++)
                result = Math.min(dp[i][j], result);
        bw.write(result + "\n");
        bw.close();
    }
}
