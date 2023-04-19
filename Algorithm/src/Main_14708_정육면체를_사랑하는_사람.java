import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14708_정육면체를_사랑하는_사람 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        long a = (long) Math.floor(Math.cbrt(n));
        long b = (long) Math.ceil(Math.cbrt(n));
        long MAX = 1_000_000_000_000_000_000L;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Node> empq = new PriorityQueue<>();

        for (long i = Math.max(1, a - 3000); i <= b + 2000; i++) {
            for (long k = i; k <= i + 4000; k++) {
                long j = n / (i * k);
                if (i * k * j < n) {
                    j++;
                }
                long data = 2 * (i * k + k * j + j * i);
                if (data < MAX) {
                    long[] arr = new long[3];
                    arr[0] = i;
                    arr[1] = k;
                    arr[2] = j;
                    Arrays.sort(arr);
                    pq = empq;
                    pq.add(new Node(arr[0], arr[1], arr[2]));
                    MAX = data;
                } else if (data == MAX) {
                    long[] arr = new long[3];
                    arr[0] = i;
                    arr[1] = k;
                    arr[2] = j;
                    Arrays.sort(arr);
                    pq.add(new Node(arr[0], arr[1], arr[2]));
                }
            }
        }

        Node node = pq.poll();
        bw.write(node.a + " " + node.b + " " + node.c);
        bw.close();
    }

    static class Node implements Comparable<Node> {
        long a, b, c;

        public Node(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            if (this.a == o.a) {
                if (this.b == o.b) {
                    return Long.compare(o.c, this.c);
                }
                return Long.compare(o.b, this.b);
            }
            return Long.compare(o.a, this.a);
        }
    }
}

