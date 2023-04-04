import java.io.*;
import java.util.StringTokenizer;

public class Main_1292_쉽게_푸는_문제 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[b];
        int cnt = 1;
        int idx = 0;
        while (idx < b) {
            for (int i = 0; i < cnt; i++) {
                arr[idx] = cnt;
                idx++;
                if (idx == b) break;
            }
            cnt++;
        }
        int sum = 0;
        for (int i = a - 1; i < b; i++) {
            sum += arr[i];
        }
        bw.write(sum + "");
        bw.close();
    }
}
