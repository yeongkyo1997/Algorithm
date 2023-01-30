import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static PriorityQueue<Integer> minPQ = new PriorityQueue<>((o1, o2) -> o1 - o2);
    static PriorityQueue<Integer> maxPQ = new PriorityQueue<>(((o1, o2) -> o2 - o1));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int n = Integer.parseInt(br.readLine());
            maxPQ.clear();
            minPQ.clear();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num;
                switch (command) {
                    case "I":
                        num = Integer.parseInt(st.nextToken());
                        minPQ.add(num);
                        maxPQ.add(num);
                        break;
                    case "D":
                        num = Integer.parseInt(st.nextToken());
                        if (num == -1 && !minPQ.isEmpty())
                            minPQ.poll();
                        if (num == 1 && !maxPQ.isEmpty())
                            maxPQ.poll();
                }
            }
            if (minPQ.isEmpty() && maxPQ.isEmpty())
                bw.write("EMPTY" + "\n");
            else {
                bw.write(maxPQ.peek() + " " + minPQ.peek() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
