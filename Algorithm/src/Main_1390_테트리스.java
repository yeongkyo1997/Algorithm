import java.io.*;

public class Main_1390_테트리스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX = 305;
    static int[][][] dp = new int[MAX][MAX][MAX];
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        dp[0][0][0] = 1;
        for (int x = 0; x <= N; x++) {
            for (int y = 0; y <= N; y++) {
                for (int z = 0; z <= N; z++) {
                    dp[x][y][z] %= 1000000;
                    if (x == y) dp[x + 2][y + 2][z] += dp[x][y][z];
                    if (y == z) dp[x][y + 2][z + 2] += dp[x][y][z];
                    if (y == z + 1) dp[x][y + 2][z + 2] += dp[x][y][z];
                    if (x == y + 1) dp[x + 2][y + 2][z] += dp[x][y][z];
                    if (x == y && z == y + 1) dp[x + 1][y + 2][z + 1] += dp[x][y][z];
                    if (z == y + 1) dp[x][y + 2][z + 2] += dp[x][y][z];
                    if (y == x + 1) dp[x + 2][y + 2][z] += dp[x][y][z];
                    if (y == z && x == y + 1) dp[x + 1][y + 2][z + 1] += dp[x][y][z];
                    if (y == z + 1) dp[x][y + 1][z + 3] += dp[x][y][z];
                    if (x == y + 1) dp[x + 1][y + 3][z] += dp[x][y][z];
                    if (x == y && y == z) dp[x + 1][y + 2][z + 1] += dp[x][y][z];
                    if (z == y + 1) dp[x][y + 3][z + 1] += dp[x][y][z];
                    if (y == x + 1) dp[x + 3][y + 1][z] += dp[x][y][z];
                    if (x == z && y + 1 == x) dp[x + 1][y + 2][z + 1] += dp[x][y][z];
                    if (z + 2 == y) dp[x][y + 1][z + 3] += dp[x][y][z];
                    if (y + 2 == x) dp[x + 1][y + 3][z] += dp[x][y][z];
                    if (x + 1 == y && y == z) dp[x + 2][y + 1][z + 1] += dp[x][y][z];
                    if (x == y) dp[x + 3][y + 1][z] += dp[x][y][z];
                    if (y == z) dp[x][y + 3][z + 1] += dp[x][y][z];
                    if (x == y && y == z) dp[x + 1][y + 1][z + 2] += dp[x][y][z];
                    if (x + 2 == y) dp[x + 3][y + 1][z] += dp[x][y][z];
                    if (y + 2 == z) dp[x][y + 3][z + 1] += dp[x][y][z];
                    if (x == y && z + 1 == y) dp[x + 1][y + 1][z + 2] += dp[x][y][z];
                    if (y == z) dp[x][y + 1][z + 3] += dp[x][y][z];
                    if (x == y) dp[x + 1][y + 3][z] += dp[x][y][z];
                    if (x == y && y == z) dp[x + 2][y + 1][z + 1] += dp[x][y][z];
                }
            }
        }
        bw.write(dp[N][N][N] + "\n");
        bw.close();
    }
}
