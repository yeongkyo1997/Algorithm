//from collections import deque
//import sys
//
//input = sys.stdin.readline
//
//        # bfs
//        def graph(n):
//        queue = deque([n])
//        cnt = 0
//        visited = [0] * (N+1)
//        visited[n] = 1
//        while queue:
//        q = queue.popleft()
//        cnt += 1
//        # 해킹가능한 컴퓨터가 존재하지 않을 때 까지 탐색
//        for i in comArr[q]:
//        if not visited[i]:
//        queue.append(i)
//        visited[i] = 1
//        return cnt
//
//        N, M = map(int, input().split())
//        comArr = [[] for _ in range(N+1)]
//
//        # 컴퓨터의 A 와 B 관계를 2차원 배열로 정리
//        for _ in range(M):
//        A, B = map(int, input().split())
//        comArr[B].append(A)
//
//        # 각 컴퓨터마다 최대 해킹 가능한 컴퓨터의 수 저장
//        answer = [0 for _ in range(N+1)]
//        for i in range(1, N+1):
//        answer[i] = graph(i)
//
//        # 해킹 가능한 컴퓨터가 가장 많은 컴퓨터의 번호 출력
//        for i in range(1, N+1):
//        if answer[i] == max(answer):
//        print(i, end=' ')

//py3 to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325_효율적인_해킹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[][] arr;
    static int[] result;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[B][A] = 1;
        }

        for (int i = 1; i <= N; i++) result[i] = bfs(i);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                bw.write(i + " ");
            }
        }
        bw.flush();
    }


    static int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int cnt = 0;
        int[] visited = new int[N + 1];
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            cnt += 1;
            for (int i = 1; i <= N; i++) {
                if (arr[q][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        return cnt;
    }
}
