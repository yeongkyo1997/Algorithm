import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1208 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    // sw 1208. Flatten
    public static void main(String[] args) throws IOException {
        int T = 10;
        int dump, max, min, maxIdx, minIdx, diff;
        int[] box = new int[100];
        for (int tc = 1; tc < T + 1; tc++) {
            dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                box[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < dump; i++) {
                max = 0;
                min = 101;
                maxIdx = 0;
                minIdx = 0;
                for (int j = 0; j < 100; j++) {
                    if (box[j] > max) {
                        max = box[j];
                        maxIdx = j;
                    }
                    if (box[j] < min) {
                        min = box[j];
                        minIdx = j;
                    }
                }
                box[maxIdx]--;
                box[minIdx]++;
            }
            max = 0;
            min = 101;
            for (int i = 0; i < 100; i++) {
                if (box[i] > max) {
                    max = box[i];
                }
                if (box[i] < min) {
                    min = box[i];
                }
            }
            diff = max - min;
            bw.write("#" + tc + " " + diff + "\n");
        }
        bw.flush();
        bw.close();

    }
}
