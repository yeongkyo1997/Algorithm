import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N][M];
        dp[0][0] = maze[0][0];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) continue;
                
                int max = 0;
                if (i > 0) max = Math.max(max, dp[i-1][j]);
                if (j > 0) max = Math.max(max, dp[i][j-1]);
                if (i > 0 && j > 0) max = Math.max(max, dp[i-1][j-1]);
                
                dp[i][j] = max + maze[i][j];
            }
        }
        
        bw.write(Integer.toString(dp[N-1][M-1]));
        bw.flush();
        bw.close();
    }
}