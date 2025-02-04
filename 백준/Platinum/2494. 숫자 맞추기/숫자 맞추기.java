import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000000; // 충분히 큰 수

    public static void main(String[] args) throws Exception {
        // BufferedReader와 BufferedWriter를 이용한 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력: 나사의 개수 N, 현재 상태, 목표 상태
        int N = Integer.parseInt(br.readLine().trim());
        String currentStr = br.readLine().trim();
        String targetStr = br.readLine().trim();
        
        // 각 나사의 숫자를 배열로 변환 (인덱스 0: 가장 위쪽 나사)
        int[] current = new int[N];
        int[] target = new int[N];
        for (int i = 0; i < N; i++) {
            current[i] = currentStr.charAt(i) - '0';
            target[i] = targetStr.charAt(i) - '0';
        }
        
        // dp[i][c]: 0번부터 i-1번 나사까지 맞추었을 때, 
        // (i번 나사에 누적되어 적용될 왼쪽 회전량이 c인 상태)일 때의 최소 총 회전 칸수
        // 상태 c는 0~9 (모듈로 10)
        int[][] dp = new int[N+1][10];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }
        // 복원용 parent와 move 기록
        int[][] parent = new int[N+1][10];   // 이전 상태(누적 회전량)
        int[][] moveUsed = new int[N+1][10];   // 해당 나사에서 적용한 회전량 (양수: 왼쪽, 음수: 오른쪽)
        
        dp[0][0] = 0; // 아무 나사도 회전시키지 않은 상태, 누적 회전 0
        
        // i번 나사를 처리 (i: 0 ~ N-1)
        for (int i = 0; i < N; i++) {
            for (int c = 0; c < 10; c++) {
                if(dp[i][c] == INF) continue;
                // 현재 나사 i의 실제 숫자 = (current[i] + 누적 회전량 c) mod 10
                int effective = (current[i] + c) % 10;
                // 목표와의 차이 (0~9)
                int diff = (target[i] - effective + 10) % 10;
                
                // 두 가지 방법를 고려
                // 1. 왼쪽으로 회전: 해당 나사와 아래 나사들이 모두 diff 만큼 회전
                //    단, diff가 0이면 회전할 필요가 없음.
                if(diff != 0) {
                    int newC = (c + diff) % 10; // 누적 회전량이 증가함
                    int cost = dp[i][c] + diff;  // 비용은 diff만큼 추가
                    if(cost < dp[i+1][newC]) {
                        dp[i+1][newC] = cost;
                        parent[i+1][newC] = c;
                        moveUsed[i+1][newC] = diff; // 왼쪽 회전은 양수
                    }
                } else {
                    // diff==0이면 아무 회전 없이 그대로 넘김
                    if(dp[i][c] < dp[i+1][c]) {
                        dp[i+1][c] = dp[i][c];
                        parent[i+1][c] = c;
                        moveUsed[i+1][c] = 0;
                    }
                }
                
                // 2. 오른쪽으로 회전: 해당 나사만 회전, 누적 회전량은 그대로
                //    오른쪽 회전으로 맞추려면, 오른쪽으로 (10 - diff) 칸 회전 (단, diff가 0이면 0)
                if(diff != 0) {
                    int cost = dp[i][c] + (10 - diff);
                    int newC = c; // 오른쪽 회전은 아래 나사에 영향을 주지 않음
                    if(cost < dp[i+1][newC]) {
                        dp[i+1][newC] = cost;
                        parent[i+1][newC] = c;
                        moveUsed[i+1][newC] = -(10 - diff); // 오른쪽 회전은 음수로 표시
                    }
                }
            }
        }
        
        // dp[N][c] (c는 0~9) 중 최소 비용을 찾는다.
        int bestCost = INF, bestState = -1;
        for (int c = 0; c < 10; c++) {
            if(dp[N][c] < bestCost) {
                bestCost = dp[N][c];
                bestState = c;
            }
        }
        
        // 복원: N번째 나사부터 1번째 나사까지 거슬러 올라가면서 moveUsed를 저장
        int[] moves = new int[N]; // moves[i]: i번 나사에서의 회전 (i: 0-indexed, 출력시 i+1)
        int curState = bestState;
        for (int i = N; i >= 1; i--) {
            moves[i-1] = moveUsed[i][curState];
            curState = parent[i][curState];
        }
        
        // 출력
        bw.write(String.valueOf(bestCost));
        bw.newLine();
        // 문제에서 "회전 순서대로"라 하였으므로 위에서부터(나사 1) 아래로 출력
        // 단, 회전 칸수가 0이면 출력하지 않아도 된다.
        for (int i = 0; i < N; i++) {
            if(moves[i] != 0) {
                bw.write((i+1) + " " + moves[i]);
                bw.newLine();
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}