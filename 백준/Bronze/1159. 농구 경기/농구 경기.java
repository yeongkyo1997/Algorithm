import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[27];
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            arr[name.charAt(0) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                bw.write((char) (i + 'a'));
                flag = true;
            }
        }
        if (!flag) bw.write("PREDAJA");
        bw.close();
    }
}