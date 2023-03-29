import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_13323_BOJ_수열_1 {
    static StringTokenizer st;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int num;
        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            num = sc.nextInt();
            num -= i;
            pq.add(num);

            if (!pq.isEmpty() && pq.peek() > num) {
                result += pq.peek() - num;
                pq.poll();
                pq.add(num);
            }
        }
        System.out.println(result);
    }
}