import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_11478 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        Set<String> set = new HashSet<>();

        StringBuilder sb;

        for (int i = 0; i < str.length(); i++) {
            sb = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                sb.append(str.charAt(j));
                set.add(sb.toString());
            }
        }
        bw.write(set.size() + "");
        bw.close();
    }
}
