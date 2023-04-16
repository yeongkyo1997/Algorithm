import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long arr[] = new long[1000010];
    static long cost = 0;
    static long n, b, c;
    static long t;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        if (b < c) c = b;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

        for (int i = 0; i < n; i++) {
            if (arr[i + 1] > arr[i + 2]) {
                t = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                arr[i] -= t;
                arr[i + 1] -= t;
                cost += (b + c) * t;

                t = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                arr[i] -= t;
                arr[i + 1] -= t;
                arr[i + 2] -= t;
                cost += (b + c * 2) * t;
            } else {
                t = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                arr[i] -= t;
                arr[i + 1] -= t;
                arr[i + 2] -= t;
                cost += (b + c + c) * t;

                t = Math.min(arr[i], arr[i + 1]);
                arr[i] -= t;
                arr[i + 1] -= t;
                cost += (b + c) * t;
            }
            cost += b * arr[i];
            arr[i] = 0;
        }
        bw.write(String.valueOf(cost));
        bw.close();
    }
}