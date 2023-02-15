import java.io.*;
import java.util.StringTokenizer;

public class Main_1264 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = "aieou";

        while (true) {
            String tmp = br.readLine();
            if (tmp.equals("#")) break;
            int cnt = 0;
            for (int i = 0; i < tmp.length(); i++) {
                if (str.contains(String.valueOf(tmp.toLowerCase().charAt(i)))) cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }
}
