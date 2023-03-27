import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_11003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && list[deque.peekLast()] > list[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() >= L) {
                deque.pollFirst();
            }
            bw.write(list[deque.peekFirst()] + " ");
        }

        bw.close();
    }
}
