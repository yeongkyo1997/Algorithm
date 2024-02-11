import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n - 1;
        int result = 0;

        while (start < end) {
            int sum = a[start] + a[end];

            if (sum == x) {
                result++;
            }
            if (sum <= x)
                start++;
            else
                end--;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}