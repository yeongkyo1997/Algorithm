import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1208_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    // sw 1208. Flatten
    public static void main(String[] args) throws IOException {
        int T = 10;
        int dump, max, min, diff;
        int[] box = new int[100];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (int tc = 1; tc < T + 1; tc++) {
            dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++) {
                box[i] = Integer.parseInt(st.nextToken());
                maxQueue.add(box[i]);
                minQueue.add(box[i]);
            }

            for (int i = 0; i < dump; i++) {
                if (maxQueue.size() > 1) {
                    max = maxQueue.poll();

                    while (minQueue.peek() == 0) {
                        minQueue.poll();
                    }
                    min = minQueue.poll();

                    maxQueue.remove(min);
                    minQueue.remove(max);

                    maxQueue.add(max - 1);
                    maxQueue.add(min + 1);
                    minQueue.add(max - 1);
                    minQueue.add(min + 1);
                }
            }
            max = maxQueue.poll();
            min = minQueue.poll();
            diff = max - min;
            bw.write("#" + tc + " " + diff + "\n");
        }
        bw.flush();
        bw.close();
    }
}
