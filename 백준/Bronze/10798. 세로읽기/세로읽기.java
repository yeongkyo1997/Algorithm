import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String[] arr = new String[5];
        int max = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
            max = Math.max(max, arr[i].length());
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length()) {
                    bw.write(arr[j].charAt(i));
                }
            }
        }
        bw.close();
    }
}