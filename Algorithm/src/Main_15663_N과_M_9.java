
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15663_N과_M_9 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static int[] arr = new int[10];
    static int[] num = new int[10];
    static int[] check = new int[10];
    static List<int[]> result = new ArrayList<>();

    static void seq(int len) {
        if (len == m) {
            result.add(arr.clone());
            return;
        }

        int last = 0;

        for (int i = 0; i < n; i++) {
            if (check[i] == 0 && num[i] != last) {
                arr[len] = num[i];
                last = arr[len];
                check[i] = 1;
                seq(len + 1);
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        seq(0);

        result.sort((o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] != o2[i]) return o1[i] - o2[i];
            }
            return 0;
        });

        for (int[] arr : result) {
            for (int i = 0; i < m - 1; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write(arr[m - 1] + "");
            bw.write("\n");
        }
        bw.close();
    }
}

