//import sys
//
//input = sys.stdin.readline
//
//        N = int(input())
//
//        adj = [[] for _ in range(N + 1)]
//
//        for i in range(1, N + 1):
//        adj[i].append(int(input()))
//
//
//        # DFS로 탐색하다가 사이클 발생한 것들을 다 더하면 된다 !!
//
//        def dfs(num):
//        if visited[num] == False:
//        visited[num] = True
//        for a in adj[num]:
//
//        tmp_up.add(num)
//        tmp_bottom.add(a)
//
//        if tmp_up == tmp_bottom:
//        ans.extend(list(tmp_bottom))
//        return
//
//        dfs(a)
//        visited[num] = False
//
//
//        ans = []
//
//        for i in range(1, N + 1):
//        visited = [False] * (N + 1)  # 위에 값 기준으로
//        tmp_up = set()
//        tmp_bottom = set()
//
//        dfs(i)
//
//        ans = list(set(ans))
//        ans.sort()
//
//        print(len(ans))
//        for a in ans:
//        print(a)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2668_숫자고르기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] ans;
    static int cnt;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        ans = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (ans[i]) {
                cnt++;
            }
        }
        bw.write(cnt + "\n");

        for (int i = 1; i <= N; i++) {
            if (ans[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int num) {
        visited[num] = true;
        int next = arr[num];
        if (!visited[next]) {
            dfs(next);
        } else {
            if (!ans[next]) {
                for (int i = next; i != num; i = arr[i]) {
                    ans[i] = true;
                }
                ans[num] = true;
            }
        }
    }
}