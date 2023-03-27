import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1700 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        List<Integer> mulitap = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        while (!list.isEmpty()) {
            int tmp = list.remove(0);

            if (list.contains(tmp)) continue;

            if (mulitap.size() < N) {
                mulitap.add(tmp);
            } else {
                int idx = -1;
                int maxIdx = -1;
                cnt++;

                for (int i = 0; i < mulitap.size(); i++) {
                    if (!list.contains(mulitap.get(i))) {
                        mulitap.remove(i);
                        mulitap.add(tmp);
                        break;
                    } else if (list.indexOf(mulitap.get(i)) > idx) {
                        idx = list.indexOf(mulitap.get(i));
                        maxIdx = i;
                    }
                }
                if (maxIdx != -1) {
                    mulitap.remove(maxIdx);
                    mulitap.add(tmp);
                }
            }
        }
        bw.write(cnt + "");
        bw.close();
    }
}
