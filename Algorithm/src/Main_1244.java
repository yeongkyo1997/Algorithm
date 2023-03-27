import java.io.*;
import java.util.StringTokenizer;

// 스위치 켜고 끄기
public class Main_1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gen == 1) for (int j = num; j < N + 1; j += num) {
                list[j] = (list[j] == 0) ? 1 : 0;
            }
            else {
                list[num] = (list[num] == 0) ? 1 : 0;
                int left = num - 1;
                int right = num + 1;
                while (left > 0 && right < N + 1 && list[left] == list[right]) {
                    list[left] = (list[left] == 0) ? 1 : 0;
                    list[right] = (list[right] == 0) ? 1 : 0;
                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            bw.write(list[i] + " ");
            if (i % 20 == 0) {
                bw.write("\n");
            }
        }
        bw.close();
    }
}
