import java.io.*;
import java.util.StringTokenizer;

public class Main_5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < M - 2; i++) {
            if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
                cnt++;
                if (cnt == N) {
                    cnt--;
                    result++;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        bw.write(result + "\n");
        bw.close();
    }
}
