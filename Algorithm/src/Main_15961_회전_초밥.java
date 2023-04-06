import java.io.*;
import java.util.StringTokenizer;

public class Main_15961_회전_초밥 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n, d, k, c;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        int[] check = new int[d + 1];

        for (int i = 0; i < n; i++) sushi[i] = Integer.parseInt(br.readLine());


        int cur = 0;
        int result = 0;
        for (int i = 0; i < k; i++)
            if (check[sushi[i]]++ == 0) cur++;

        if (check[c] == 0) cur++;

        result = Math.max(cur, result);

        int left = 1;
        int right = k;

        while (right < n) {
            if (--check[sushi[left]] == 0) {
                cur--;
                if (sushi[left] == c) cur++;
            }

            if (check[sushi[right]]++ == 0) {
                cur++;
                if (sushi[right] == c) cur++;
            }
            result = Math.max(cur, result);
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}