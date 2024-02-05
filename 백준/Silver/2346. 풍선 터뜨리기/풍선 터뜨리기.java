import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] idx = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            idx[i] = i + 1;
        }
        int cur = 0;
        int next = list[cur];
        int cnt = 0;
        while (cnt < N) {
            bw.write(idx[cur] + " ");
            idx[cur] = 0;
            cnt++;
            if (cnt == N)
                break;
            if (next > 0) {
                for (int i = 0; i < next; i++) {
                    cur = (cur + 1) % N;
                    if (idx[cur] == 0)
                        i--;
                }
            } else {
                for (int i = 0; i > next; i--) {
                    cur = (cur - 1 + N) % N;
                    if (idx[cur] == 0) {
                        i++;
                    }
                }
            }
            next = list[cur];
        }
        bw.close();
    }
}