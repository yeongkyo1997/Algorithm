import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main_17299_오등큰수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Map<Integer, Integer> map = new HashMap<>();
    static int N;
    static int[] arr;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][2];

        Arrays.sort(arr, ((o1, o2) -> Long.compare(o2[1], o1[1])));
    }
}
