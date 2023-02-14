import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// swea 1225. 암호생성기
public class Solution_1225 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int t = 1; t < 11; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            int cnt = 1;
            while (true) {
                if (deque.isEmpty()) break;
                int num = deque.poll() - cnt;
                if (num <= 0) {
                    deque.add(0);
                    break;
                }
                deque.add(num);
                cnt++;
                if (cnt == 6) cnt = 1;
            }
            bw.write("#" + t + " ");
            while (!deque.isEmpty()) {
                bw.write(deque.poll() + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
