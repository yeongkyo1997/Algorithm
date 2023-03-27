import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] list1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list1);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreElements()) {
            int num = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(list1, num) >= 0) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }
        bw.close();
    }
}
