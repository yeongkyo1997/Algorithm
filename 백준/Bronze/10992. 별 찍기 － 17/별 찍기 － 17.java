import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            IntStream.range(0, N - i - 1).mapToObj(j -> " ").forEach(System.out::print);
            System.out.print("*");

            if (i != 0) {
                IntStream.range(0, 2 * i - 1).mapToObj(j -> " ").forEach(System.out::print);
                System.out.print("*");
            }

            System.out.println();
        }

        IntStream.range(0, 2 * N - 1).mapToObj(i -> "*").forEach(System.out::print);
        System.out.println();
    }
}