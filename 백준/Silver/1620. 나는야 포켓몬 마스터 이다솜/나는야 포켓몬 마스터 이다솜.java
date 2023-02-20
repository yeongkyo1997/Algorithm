import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> name = new ArrayList<>();
        int n, m;
        String tmp;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            tmp = br.readLine();
            name.add(tmp);
            map.put(tmp, i);
        }

        for (int i = 0; i < m; i++) {
            tmp = br.readLine();
            if (tmp.charAt(0) >= 'A' && tmp.charAt(0) <= 'Z') {
                bw.write(map.get(tmp) + "\n");
            } else {
                bw.write(name.get(Integer.parseInt(tmp) - 1) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}