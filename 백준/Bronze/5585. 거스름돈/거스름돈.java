import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int sum = 1000 - N;
        int result = 0;

        int[] coins = { 500, 100, 50, 10, 5, 1 };

        for (int coin : coins) {
            result += sum / coin;
            sum %= coin;
        }

        bw.write(result + "\n");

        bw.flush();
    }
}