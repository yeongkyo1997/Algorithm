import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세_용액 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        int[] three = new int[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int tmp = arr[i] + arr[left] + arr[right];

                if (Math.abs(tmp) < result) {
                    result = Math.abs(tmp);
                    three[0] = arr[i];
                    three[1] = arr[left];
                    three[2] = arr[right];
                }

                if (tmp < 0) left++;
                else if (tmp > 0) right--;
                else break;
            }
        }
        Arrays.sort(three);
        bw.write(three[0] + " " + three[1] + " " + three[2]);
        bw.close();
    }
}