import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1128_피보나치_냅색 {
    static int N;
    static long[][] items;
    static long[] weight, cost;

    static long rec(int p, long C, boolean usedBig) {
        if (p < 0) return 0;
        if (weight[p] <= C) return cost[p];
        else if (items[p][0] <= C && (usedBig || items[p + 1][0] != items[p][0]))
            return Math.max(rec(p - 1, C - items[p][0], true) + items[p][1], rec(p - 1, C, false));
        else return rec(p - 1, C, false);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        items = new long[N][2];

        for (int i = 0; i < N; i++) {
            items[i][0] = sc.nextLong();
            items[i][1] = sc.nextLong();
        }

        Arrays.sort(items, Comparator.comparingLong(o -> o[0]));
        weight = new long[N];
        cost = new long[N];
        weight[0] = items[0][0];
        cost[0] = items[0][1];

        for (int i = 1; i < N; i++) {
            weight[i] = weight[i - 1] + items[i][0];
            cost[i] = cost[i - 1] + items[i][1];
        }

        long C = sc.nextLong();
        System.out.println(rec(N - 1, C, true));
    }
}