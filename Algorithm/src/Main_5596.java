import java.io.*;
import java.util.*;

public class Main_5596 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Integer[] arr = {1, 2, 3, 4, 5};

        long cnt = Arrays.stream(arr).filter(n -> n % 2 == 0).count();
        System.out.println(cnt);

        long sum = Arrays.stream(arr).mapToLong(x -> x).sum();
        System.out.println(sum);

        double avg = Arrays.stream(arr).mapToDouble(x -> x).average().getAsDouble();
        System.out.println(avg);

        int max = Arrays.stream(arr).mapToInt(x -> x).max().getAsInt();
        System.out.println(max);

        int min = Arrays.stream(arr).mapToInt(x -> x).min().getAsInt();
        System.out.println(min);

        int first = Arrays.stream(arr).mapToInt(x -> x).filter(n -> n % 2 == 0).findFirst().getAsInt();
        System.out.println(first);

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
    }
}
