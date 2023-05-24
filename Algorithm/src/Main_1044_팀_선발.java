import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main_1044_팀_선발 {
    static long INF = Long.MAX_VALUE;
    static long[] s1 = new long[40];
    static long[] s2 = new long[40];
    static int N;
    static TreeMap<Long, Integer> M1 = new TreeMap<>();
    static TreeMap<Long, Integer> M2 = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        IntStream.range(0, N).forEach(i -> s1[i] = scanner.nextLong());
        IntStream.range(0, N).forEach(i -> s2[i] = scanner.nextLong());
        int len1 = N / 2;
        int len2 = N - len1;
        for (int i = 0; i < (1 << len1); i++) {
            long val = 0;
            for (int j = 0; j < len1; j++) {
                if ((i & (1 << (len1 - 1 - j))) != 0) {
                    val += s2[j];
                } else val -= s1[j];
            }
            if (M1.containsKey(val)) M1.put(val, Math.min(M1.get(val), i));
            else M1.put(val, i);
        }
        for (int i = 0; i < (1 << len2); i++) {
            long val = 0;
            for (int j = 0; j < len2; j++) {
                val += (i & (1 << (len2 - 1 - j))) != 0 ? s2[len1 + j] : -s1[len1 + j];
            }
            M2.put(val, M2.containsKey(val) ? Math.min(M2.get(val), i) : i);
        }
        ArrayList<long[]> list1;
        ArrayList<long[]> list2;
        list1 = M1.keySet().stream().map(key -> new long[]{Integer.bitCount(M1.get(key)), key, M1.get(key)}).collect(Collectors.toCollection(ArrayList::new));

        list2 = M2.keySet().stream().map(key -> new long[]{Integer.bitCount(M2.get(key)), key, M2.get(key)}).collect(Collectors.toCollection(ArrayList::new));

        for (int i = 0; i < 40; i++) {
            list2.add(new long[]{i, -INF, 0});
            list2.add(new long[]{i, INF, 0});
        }

        list1.sort(Comparator.comparingLong(a -> a[0]));
        list2.sort(Comparator.comparingLong(a -> a[0]));

        long diff = INF;
        long select = INF;

        for (long[] e1 : list1) {
            if (e1[0] > N / 2) continue;
            long[] e2 = list2.stream().filter(t -> t[0] == N / 2 - e1[0] && t[1] == -e1[1]).findFirst().orElse(null);

            if (e2 == null) continue;

            long curDiff = Math.abs(e1[1] + e2[1]);
            long curSelect = (e1[2] << len1) | e2[2];

            if (diff > curDiff || (diff == curDiff && select > curSelect)) {
                diff = curDiff;
                select = curSelect;
            }

            int idx = list2.indexOf(e2);
            if (idx > 0) {
                e2 = list2.get(idx - 1);
                curDiff = Math.abs(e1[1] + e2[1]);
                curSelect = (e1[2] << len1) | e2[2];

                if (diff > curDiff || (diff == curDiff && select > curSelect)) {
                    diff = curDiff;
                    select = curSelect;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print((select & (1L << (N - 1 - i))) != 0 ? 2 + " " : 1 + " ");
        }
    }
}
