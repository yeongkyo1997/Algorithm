import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] list;
    static int[] cal = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        sol(list[0], 1);
        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    static void sol(int total, int depth) {
        if (depth == N) {
            max = Math.max(total, max);
            min = Math.min(total, min);
            return;
        }
        for (int i = 0; i < cal.length; i++) {
            if (cal[i] > 0) {
                cal[i]--;
                switch (i) {
                    case 0:
                        sol(total + list[depth], depth + 1);
                        break;
                    case 1:
                        sol(total - list[depth], depth + 1);
                        break;
                    case 2:
                        sol(total * list[depth], depth + 1);
                        break;
                    case 3:
                        sol(total / list[depth], depth + 1);
                        break;
                }
                cal[i]++;
            }
        }
    }
}
