import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] row = new int[r];
        int[] col = new int[c];

        for (int i = 0; i < r - 1; i++) {
            row[i] = Integer.parseInt(br.readLine());
        }
        st = new StringTokenizer(br.readLine());
        row[r - 1] = Integer.parseInt(st.nextToken());

        col[0] = row[r - 1];
        for (int i = 1; i < c; i++) {
            col[i] = Integer.parseInt(st.nextToken());
        }

        int minR = row[0];
        int minC = col[0];
        int x = 0;
        int y = 0;

        for (int i = 0; i < r; i++) {
            if (minR > row[i]) {
                minR = row[i];
                x = i;
            }
        }

        for (int i = 0; i < c; i++) {
            if (minC > col[i]) {
                minC = col[i];
                y = i;
            }
        }
        bw.write((x + 1) + " " + (y + 1) + "");
        bw.flush();
        bw.close();
    }
}
