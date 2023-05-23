import java.util.Scanner;
import java.util.stream.IntStream;

public class Main_1205_등수_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int score = sc.nextInt();
        int P = sc.nextInt();

        int[] rank = IntStream.range(0, N).map(i -> sc.nextInt()).toArray();

        int cnt = 0;
        int my_rank = 1;
        for (int i = 0; i < N; i++) {
            if (score < rank[i]) my_rank += 1;
            else if (score == rank[i]) {
            } else break;
            cnt++;
        }

        if (cnt == P) my_rank = -1;
        if (N == 0) my_rank = 1;

        System.out.println(my_rank);
        sc.close();
    }
}
