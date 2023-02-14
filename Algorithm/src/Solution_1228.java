import java.io.*;
import java.util.StringTokenizer;

public class Solution_1228 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] list = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int[] tmp = new int[y];

                for (int j = 0; j < y; j++) {
                    tmp[j] = Integer.parseInt(st.nextToken());
                }

                int[] newList = new int[N + y];
                for (int j = 0; j < x; j++) {
                    newList[j] = list[j];
                }
                for (int j = 0; j < y; j++) {
                    newList[x + j] = tmp[j];
                }

                for (int j = x; j < N; j++) {
                    newList[j + y] = list[j];
                }
                list = newList;
                N += y;
            }

            bw.write("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                bw.write(list[i] + " ");
            }

            bw.write("\n");
        }
        bw.close();
    }
}
