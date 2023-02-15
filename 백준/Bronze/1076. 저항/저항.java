import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Map<String, long[]> map = new HashMap<>();
        String[] colors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
        for (int i = 0; i < 10; i++) {
            map.put(colors[i], new long[] { i, (long) Math.pow(10, i) });
        }
        long sum = 0l;
        String color;
        color = br.readLine();
        sum += map.get(color)[0] * 10;
        color = br.readLine();
        sum += map.get(color)[0];
        color = br.readLine();
        sum *= map.get(color)[1];
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
