import java.io.*;
import java.util.StringTokenizer;

public class Main_1058_친구 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'Y') map[i][j] = 1;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || k == i || k == j) continue;
                    if (arr[i][k] == 'Y' && arr[k][j] == 'Y') {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }


        bw.write(String.valueOf(result));
        bw.close();
    }
}
