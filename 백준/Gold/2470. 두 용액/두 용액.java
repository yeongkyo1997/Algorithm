import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);


        int left = 0;
        int right = n - 1;

        int result = Integer.MAX_VALUE;
        int[] ans = new int[2];


        while (left < right) {
            int s_left = arr[left];
            int s_right = arr[right];

            int mix = s_left + s_right;

            if (Math.abs(mix) < result) {
                result = Math.abs(mix);
                ans[0] = s_left;
                ans[1] = s_right;
            }


            if (mix < 0) left++;
            else right--;

        }

        bw.write(ans[0] + " " + ans[1]);
        bw.close();
    }
}