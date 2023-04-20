//#include <stdio.h>
//        #define N 8
//
//        int is_valid(int i, int j, int sol[N+1][N+1]) {
//        if (i>=1 && i<=N && j>=1 && j<=N && sol[i][j]==-1)
//        return 1;
//        return 0;
//        }
//
//        int knight_tour(int sol[N+1][N+1], int i, int j, int step_count, int x_move[], int y_move[]) {
//        if (step_count == N*N)
//        return 1;
//
//        int k;
//        for(k=0; k<8; k++) {
//        int next_i = i+x_move[k];
//        int next_j = j+y_move[k];
//
//        if(is_valid(i+x_move[k], j+y_move[k], sol)) {
//        sol[next_i][next_j] = step_count;
//        if (knight_tour(sol, next_i, next_j, step_count+1, x_move, y_move))
//        return 1;
//        sol[i+x_move[k]][j+y_move[k]] = -1; // backtracking
//        }
//        }
//
//        return 0;
//        }
//
//        int start_knight_tour() {
//        int sol[N+1][N+1];
//
//        int i, j;
//        for(i=1; i<=N; i++) {
//        for(j=1; j<=N; j++) {
//        sol[i][j] = -1;
//        }
//        }
//
//        int x_move[] = {2, 1, -1, -2, -2, -1, 1, 2};
//        int y_move[] = {1, 2, 2, 1, -1, -2, -2, -1};
//
//        sol[1][1] = 0; // placing knight at cell(1, 1)
//
//        if (knight_tour(sol, 1, 1, 1, x_move, y_move)) {
//        for(i=1; i<=N; i++) {
//        for(j=1; j<=N; j++) {
//        printf("%d\t",sol[i][j]);
//        }
//        printf("\n");
//        }
//        return 1;
//        }
//        return 0;
//        }
//
//        int main() {
//        printf("%d\n",start_knight_tour());
//        return 0;
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15698_Uncrossed_Knights_Tour {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    private static int N = 8;
    private static int[][] result = new int[N + 1][N + 1];
    private static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result[i][j] = -1;
            }
        }

        result[1][1] = 0;
        if (solve(1, 1, 1)) {
            bw.write(result[6][6] + "\n");
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    bw.write(String.valueOf(result[i][j]));
                    bw.write("\t");
                }
                bw.write("\n");
            }
        }
        bw.close();
    }

    private static boolean solve(int x, int y, int cnt) {
        if (cnt == N * N) return true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (check(x + dx[i], y + dy[i])) {
                result[nx][ny] = cnt;

                if (solve(nx, ny, cnt + 1)) return true;
                result[x + dx[i]][y + dy[i]] = -1;
            }
        }
        return false;
    }


    private static boolean check(int i, int j) {
        return i >= 1 && i <= N && j >= 1 && j <= N && result[i][j] == -1;
    }
}