import java.io.*;
import java.util.StringTokenizer;

public class Main_1100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String[] board1 = {"F.F.F.F.", "F.F.F.F.", "F.F.F.F.", "F.F.F.F.", "F.F.F.F.", "F.F.F.F.", "F.F.F.F.", "F.F.F.F."};

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (str.charAt(j) == board1[i].charAt(j) && str.charAt(j) == 'F') cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.close();
    }
}
