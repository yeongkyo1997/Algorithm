import java.awt.image.ImageProducer;
import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {

            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (k-- != 0) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (cmd) {
                    case "I":
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if (!map.isEmpty()) {
                            num = num == 1 ? map.lastKey() : map.firstKey();
                            if (map.put(num, map.get(num) - 1) == 1) map.remove(num);
                        }
                        break;
                }
            }
            if (map.isEmpty()) bw.write("EMPTY" + "\n");
            else bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            map.clear();
        }
        bw.close();
    }
}
