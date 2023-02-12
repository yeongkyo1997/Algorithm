import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<String, Integer>() {
            @Override
            public boolean equals(Object o) {
                if (!(o instanceof String))
                    return false;
                String tmp = (String) o;
                return tmp.equalsIgnoreCase(String.valueOf(this));
            }
        };

        StringBuilder sb;
        for (int i = 1; i < N + 1; i++) {
            sb = new StringBuilder(br.readLine());
            map1.put(i, sb.toString());
            map2.put(sb.toString(), i);
        }

        for (int i = 0; i < M; i++) {
            sb = new StringBuilder(br.readLine());

            if (sb.toString().matches("[0-9]+")) bw.write(map1.get(Integer.parseInt(sb.toString())) + "\n");
            else bw.write(map2.get(sb.toString()) + "\n");
        }
        bw.close();
    }
}
