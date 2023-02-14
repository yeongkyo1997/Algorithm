import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int K = Integer.parseInt(br.readLine());

            while (K-- != 0) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    if (num == 1) {
                        int max = map.lastKey();
                        if (map.get(max) == 1) map.remove(max);
                        else map.put(max, map.get(max) - 1);
                    } else {
                        int min = map.firstKey();
                        if (map.get(min) == 1) map.remove(min);
                        else map.put(min, map.get(min) - 1);
                    }
                }
            }

            if (map.isEmpty()) bw.write("EMPTY\n");
            else bw.write(map.lastKey() + " " + map.firstKey() + "\n");
        }
        bw.close();
    }
}
