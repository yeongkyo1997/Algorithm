import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1700_멀티탭_스케줄링 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K, result;
    static int[] ord;
    static ArrayList<Integer> tab = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ord = new int[K];
        st = new StringTokenizer(br.readLine());

        IntStream.range(0, K).forEach(i -> ord[i] = Integer.parseInt(st.nextToken()));

        outer:
        for (int i = 0; i < K; i++) {

            for (Integer integer : tab) {
                if (integer == ord[i]) continue outer;
            }

            if (tab.size() < N) {
                tab.add(ord[i]);
                continue;
            }

            int maxd = 0, maxt = 0;
            for (int t = 0; t < tab.size(); t++) {
                int d = 1000000000;

                for (int j = i + 1; j < K; j++) {
                    if (tab.get(t) == ord[j]) {
                        d = j;
                        break;
                    }
                }
                if (maxd < d) {
                    maxd = d;
                    maxt = t;
                }
            }

            tab.set(maxt, ord[i]);
            result++;
        }

        bw.write(result + "\n");
        bw.close();
    }
}