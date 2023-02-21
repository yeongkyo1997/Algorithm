import java.io.*;
import java.util.StringTokenizer;

public class Main_27324 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        if (str.charAt(0) == str.charAt(1)) bw.write(1 + "");
        else bw.write(0 + "");
        bw.close();
    }
}
