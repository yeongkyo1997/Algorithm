import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main_2164 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        Queue<Integer> q = new ArrayDeque<>();

        IntStream.rangeClosed(1, N).forEach(q::offer);

        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }
    }
}


