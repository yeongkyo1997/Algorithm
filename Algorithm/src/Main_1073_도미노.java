import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1073_도미노 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] numbers = new int[10];
    static int[] d = {1, 0, 1, 0, 3, 0, 15, 0, 105, 0};

    public static void main(String[] args) throws Exception {
        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            int temp = Integer.parseInt(br.readLine());
            int a = temp / 10;
            int b = temp % 10;
            numbers[a]++;
            numbers[b]++;
        }
        long result = 1;
        for (int i = 0; i < 10; i++) {
            result *= d[numbers[i]];
        }
        bw.write(result + "\n");
        bw.close();
    }
}