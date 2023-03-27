import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ 1655 가운데를 말해요
public class Main_1655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            minHeap.add(num);
            bw.write(minHeap.size() % 2 == 0 ? minHeap.poll() + "\n" : minHeap.peek() + "\n");
        }


    }
}