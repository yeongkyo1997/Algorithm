import java.io.*;
import java.util.StringTokenizer;

public class Main_15873_공백_없는_AB {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int sum = 0;
        if (str.length() == 2) {
            sum = str.charAt(0) - '0' + str.charAt(1) - '0';
        } else if (str.length() == 3) {
            if (str.charAt(1) == '0') {
                sum = str.charAt(0) - '0' + str.charAt(2) - '0';
            } else {
                sum = 10 + str.charAt(2) - '0';
            }
        } else if (str.length() == 4) {
            sum = 20;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
