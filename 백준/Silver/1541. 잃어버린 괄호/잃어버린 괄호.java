import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String[] cal = br.readLine().split("-");
        int result = 0;

        for (int i = 0; i < cal.length; i++) {
            int sum = 0;
            String[] cal2 = cal[i].split("\\+");
            for (int j = 0; j < cal2.length; j++) {
                sum += Integer.parseInt(cal2[j]);
            }
            if (i == 0)
                result += sum;
            else
                result -= sum;
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
