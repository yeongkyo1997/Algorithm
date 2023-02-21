import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1039 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] list = new int[6];
        int idx = 0;
        while (N > 0) {
            list[idx++] = N % 10;
            N /= 10;
        }

        int result = -1;

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < idx - 1; j++) {
                for (int k = j + 1; k < idx; k++) {
                    if (j == 0 && list[k] == 0) {
                        continue;
                    }
                    swap(list, j, k);
                    int num = convert(list, idx);
                    result = Math.max(result, num);
                    swap(list, j, k);
                }
            }
        }

        bw.write(result + "");

        bw.close();
    }

    static void swap(int[] list, int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    static int convert(int[] list, int idx) {
        int result = 0;
        for (int i = 0; i < idx; i++) {
            result += list[i] * Math.pow(10, i);
        }
        return result;
    }

}
