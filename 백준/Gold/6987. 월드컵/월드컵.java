import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BOJ 6987 월드컵
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] score = new int[6][3];
    static int[][] game = new int[6][3];
    static int result = 0;
    static List<int[]> teams = new ArrayList<>();

    static void go(int curR) {
        if (curR == 15) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (score[i][j] != game[i][j]) return;
                }
            }
            result = 1;
            return;
        }

        int t1 = teams.get(curR)[0], t2 = teams.get(curR)[1];
        game[t1][0]++;
        game[t2][2]++;

        go(curR + 1);
        game[t1][0]--;
        game[t2][2]--;
        game[t1][2]++;
        game[t2][0]++;

        go(curR + 1);
        game[t1][2]--;
        game[t2][0]--;
        game[t1][1]++;
        game[t2][1]++;

        go(curR + 1);
        game[t1][1]--;
        game[t2][1]--;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                teams.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    score[j][k] = Integer.parseInt(st.nextToken());
                    game[j][k] = 0;
                }
            }
            go(0);
            bw.write(result + " ");
            result = 0;
        }
        bw.close();
    }
}