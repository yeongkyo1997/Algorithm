import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2309_일곱_난쟁이 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] numbers = new int[7];
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        combi(0, 0, 0);
    }

    static void combi(int start, int depth, int sum) throws IOException {
        if (depth == 7) {
            if (sum == 100) {
                Arrays.sort(numbers);
                for (int number : numbers) {
                    bw.write(number + "\n");
                }
                bw.close();
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            numbers[depth] = arr[i];
            combi(i + 1, depth + 1, sum + arr[i]);
        }
    }
}
