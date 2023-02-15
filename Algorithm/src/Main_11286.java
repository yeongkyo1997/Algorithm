import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Data implements Comparable<Data> {
        int n;

        public Data(int n) {
            this.n = n;
        }

        @Override
        public int compareTo(Data o) {
            if (Math.abs(this.n) == Math.abs(o.n)) return this.n - o.n;
            return Math.abs(this.n) - Math.abs(o.n);
        }
    }


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Data> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) if (pq.isEmpty()) bw.write(0 + "\n");
            else bw.write(pq.poll().n + "\n");
            else pq.add(new Data(num));
        }
        bw.flush();
        bw.close();
    }
}
