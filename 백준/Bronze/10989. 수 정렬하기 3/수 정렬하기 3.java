import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int i = 0; i <= 10000; i++) {
            if (map.containsKey(i))
                for (int j = 0; j < map.get(i); j++)
                    bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}

