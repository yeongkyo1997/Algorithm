import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String dish = br.readLine();
        int result = 0;

        for (int i = 0; i < dish.length(); i++) {
            if (i == 0) result += 10;
            else if (dish.charAt(i) == dish.charAt(i - 1)) result += 5;
            else result += 10;
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}