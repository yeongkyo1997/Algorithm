import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main_2161 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = IntStream.range(1, n + 1).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        while (deque.size() > 1) {
            bw.write(deque.poll() + " ");
            deque.addLast(deque.pollFirst());
        }
        bw.write(deque.poll() + " ");
        bw.flush();
        bw.close();
    }
}
