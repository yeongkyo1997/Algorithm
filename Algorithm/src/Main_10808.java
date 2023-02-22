import java.io.*;
import java.util.StringTokenizer;

public class Main_10808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int[] list = new int['z' - 'a' + 1];

        for (int i = 0; i < str.length(); i++) {
            list[str.charAt(i) - 'a']++;
        }

        for (int i : list) {
            bw.write(i + " ");
        }
        bw.close();
    }
}
