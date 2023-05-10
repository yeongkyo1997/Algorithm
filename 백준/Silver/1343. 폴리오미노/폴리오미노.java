import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String board = br.readLine();
        StringBuilder result = new StringBuilder();
        int cnt = 0;

        board += ' ';

        for (int i = 0; i < board.length() - 1; i++) {

            if (board.charAt(i) == 'X') cnt++;

            if (board.charAt(i) == '.') {
                result.append(".");
                if (cnt % 2 != 0) break;
                else cnt = 0;
            }

            if (cnt == 2 && board.charAt(i + 1) != 'X') {
                result.append("BB");
                cnt = 0;
            } else if (cnt == 4) {
                result.append("AAAA");
                cnt = 0;
            }
        }

        bw.write(cnt % 2 == 1 ? "-1" : result.toString());
        bw.close();
    }
}