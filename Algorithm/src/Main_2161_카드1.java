import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2161_카드1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {
            deque.add(i);
        }

        while (deque.size() > 1) {
            bw.write(deque.poll() + " ");
            deque.addLast(deque.pollFirst());
        }
        bw.write(deque.poll() + " ");
        bw.flush();
        bw.close();
    }
}
