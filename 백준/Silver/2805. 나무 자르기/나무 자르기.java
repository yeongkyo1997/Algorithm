import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N, M;
        int[] list;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int min = 0;

        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            max = Math.max(list[i], max);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < list.length; i++) {
                if (list[i] - mid > 0)
                    sum += list[i] - mid;
            }
            if (sum < M)
                max = mid;
            else
                min = mid + 1;
        }
        bw.write((min - 1) + "");
        bw.flush();
        bw.close();
    }
}
