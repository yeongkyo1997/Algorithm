import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_카드2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {

            q.poll();
            q.offer(q.poll());

        }
    }
}


