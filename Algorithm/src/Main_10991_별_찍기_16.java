import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_10991_별_찍기_16 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            IntStream.rangeClosed(1, N - i).mapToObj(j -> " ").forEach(System.out::print);
            IntStream.rangeClosed(1, i).mapToObj(j -> "* ").forEach(System.out::print);
            System.out.println();
        }
    }
}
