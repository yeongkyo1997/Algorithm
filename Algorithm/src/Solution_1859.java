import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1859 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] list = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o1 - o2));

            int result = 0;
            for (int i = 0; i < n; i++) {
                list[n - i] = Integer.parseInt(st.nextToken());
            }

            int left = 0;
            while (true) {
            }
        }
    }
}
