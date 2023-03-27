import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_11003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int[] list = IntStream.range(0, N).map(i -> Integer.parseInt(st.nextToken())).toArray();

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
