import java.io.*;
import java.util.StringTokenizer;

public class Main_2670_연속부분최대곱 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Double.parseDouble(st.nextToken());
        }

        int left = 0;
        int right = 0;

        while (right < N) {
            if (arr[left] < arr[right]) {
                arr[right] = arr[left] * arr[right];
                left++;
            } else {
                left = right;
            }
            right++;
        }
        bw.write(String.format("%.3f", arr[0]));
        bw.close();
    }
}
