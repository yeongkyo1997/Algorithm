import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_두_용액 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] arr;
        long result = Integer.MAX_VALUE;
        long a = 0, b = 0;
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (Math.abs(result) > Math.abs(arr[start] + arr[end])) {
                result = arr[start] + arr[end];
                a = arr[start];
                b = arr[end];
            }

            if (arr[start] >= 0) {
                if (arr[start] + arr[end] > 0) start++;
                else if (arr[start] + arr[end] < 0) end--;
                else {
                    a = arr[start];
                    b = arr[end];
                    break;
                }
            } else {
                end--;
            }
        }
        bw.write(a + " " + b);
        bw.close();
    }
}