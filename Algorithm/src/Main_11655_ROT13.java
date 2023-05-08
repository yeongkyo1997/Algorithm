import java.io.*;
import java.util.StringTokenizer;

public class Main_11655_ROT13 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                bw.write(str.charAt(i) - 'A' < 13 ? (char) (str.charAt(i) + 13) : (char) (str.charAt(i) - 13));
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                bw.write(str.charAt(i) - 'a' < 13 ? (char) (str.charAt(i) + 13) : (char) (str.charAt(i) - 13));
            else bw.write(str.charAt(i));
        }
        bw.close();
    }
}