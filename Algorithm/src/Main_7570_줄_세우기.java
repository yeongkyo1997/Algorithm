import java.io.*;
import java.util.StringTokenizer;

public class Main_7570_줄_세우기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            int no = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[no] = arr[no - 1] + 1);
        }

        bw.write(String.valueOf(n - max));
        bw.close();
    }
}

