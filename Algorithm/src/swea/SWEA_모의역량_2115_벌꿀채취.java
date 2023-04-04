package swea;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_모의역량_2115_벌꿀채취 {
    static int N, M, C, ans; // N: 벌통의 크기, M: 연속된 벌통의 개수, C: 채취할 수 있는 꿀의 최대 양, ans: 최대 이익
    static int[][] map, profit; // map: 벌통의 정보, profit: 각 좌표에서의 최대 이익

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), t = 0;

        while (t++ < T) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();

            map = new int[N][N];
            profit = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            setProfit();   // 각 좌표에서의 최대 이익을 구함
            setPosition(); // 일꾼 1, 2의 위치를 정함
            System.out.println("#" + t + " " + ans);
            ans = 0;
        }
    }


    /*
     * 1. 일꾼 1, 2의 위치를 정함
     * 2. 같은 행일때
     * 3. 다른 행일때
     * 4. 최대 이익을 구함
     */
    static void setPosition() { // 일꾼 1, 2의 위치를 정함
        for (int i = 0; i < N; i++) {
            // M개의 연속된 벌통을 선택할 수 있으므로 N-M+1개의 벌통을 선택할 수 있음
            for (int j = 0; j <= N - M; j++) {
                for (int c = j + M; c <= N - M; c++) { // 같은행일때
                    ans = Math.max(ans, profit[i][j] + profit[i][c]);
                }

                // 같은 행일때는 이미 계산했으므로 다음 행부터 계산
                for (int r = i + 1; r < N; r++) { // 다른행일때
                    // M개의 연속된 벌통을 선택할 수 있으므로 N-M+1개의 벌통을 선택할 수 있음
                    for (int c = 0; c <= N - M; c++) { // 열
                        ans = Math.max(ans, profit[i][j] + profit[r][c]); // 다른행일때
                    }
                }
            }
        }
    }

    static void setProfit() { // 각 좌표에서의 최대 이익을 구함
        for (int i = 0; i < N; i++) { // 행
            for (int j = 0; j <= N - M; j++) { // 열
                setMaxProfit(i, j, 0, 0, 0);    // 최대 이익을 구함
            }
        }
    }

    /*
     * i: 행, j: 열, cnt: 선택한 벌통의 개수, cSum: 선택한 벌통의 꿀의 양, pSum: 선택한 벌통의 이익
     * 1. 선택한 벌통의 꿀의 양이 최대 양을 넘어가면 return
     * 2. 선택한 벌통의 개수가 M개가 되면 최대 이익을 저장하고 return
     * 3. 선택하지 않음
     * 4. 선택함, 이익은 꿀의 양의 제곱
     */
    static void setMaxProfit(int i, int j, int cnt, int cSum, int pSum) {
        if (cSum > C) return; // 선택한 벌통의 꿀의 양이 최대 양을 넘어가면 return
        if (cnt == M) { // 선택한 벌통의 개수가 M개가 되면
            profit[i][j - M] = Math.max(profit[i][j - M], pSum); // 최대 이익을 저장
            return;
        }
        setMaxProfit(i, j + 1, cnt + 1, cSum, pSum); // 선택하지 않음
        setMaxProfit(i, j + 1, cnt + 1, cSum + map[i][j], pSum + map[i][j] * map[i][j]);  // 선택함, 이익은 꿀의 양의 제곱
    }
}