import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_7682_틱택토 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static char[][] map;
    static String str;

    static boolean checkX() {
        boolean ret = IntStream.range(0, 3).anyMatch(j -> map[0][j] == 'X' && map[0][j] == map[1][j] && map[1][j] == map[2][j]) || IntStream.range(0, 3).anyMatch(i -> map[i][0] == 'X' && map[i][0] == map[i][1] && map[i][1] == map[i][2]);

        if (map[0][0] == 'X' && map[0][0] == map[1][1] && map[1][1] == map[2][2]) ret = true;

        if (map[0][2] == 'X' && map[0][2] == map[1][1] && map[1][1] == map[2][0]) ret = true;

        return ret;
    }

    static boolean checkO() {
        boolean ret = false;
        for (int i = 0; i < 3; ++i)
            if (map[i][0] == 'O' && map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                ret = true;
                break;
            }
        for (int j = 0; j < 3; ++j)
            if (map[0][j] == 'O' && map[0][j] == map[1][j] && map[1][j] == map[2][j]) {
                ret = true;
                break;
            }

        if (map[0][0] == 'O' && map[0][0] == map[1][1] && map[1][1] == map[2][2]) ret = true;

        if (map[0][2] == 'O' && map[0][2] == map[1][1] && map[1][1] == map[2][0]) ret = true;

        return ret;
    }

    public static void main(String[] args) throws Exception {
        str = br.readLine();

        while (!str.equals("end")) {
            int onum = 0, xnum = 0;
            boolean owin, xwin;

            map = new char[3][3];

            for (int i = 0; i < 9; ++i) {
                map[i / 3][i % 3] = str.charAt(i);
                if (str.charAt(i) == 'O') ++onum;
                else if (str.charAt(i) == 'X') ++xnum;
            }

            owin = checkO();
            xwin = checkX();

            bw.write((xwin && !owin && xnum - onum == 1 || !xwin && owin && onum == xnum) || !xwin && !owin && xnum == 5 && onum == 4 ? "valid\n" : "invalid\n");

            str = br.readLine();
        }

        bw.close();
    }
}
