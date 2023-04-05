package min;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15666_N과_M_12 {
    static int N, M, ans;
    static int[] input, numbers;
    static boolean[] visited;
    static Set<String> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        numbers = new int[M];
        input = new int[N];
        s = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        comb(0, 0);

        for (String x : s) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            Arrays.sort(numbers);
            System.out.println(Arrays.toString(numbers));
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < M; i++) {
                num.append(numbers[i]).append(" ");
            }
            s.add(num.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            numbers[cnt] = input[i];
            comb(cnt + 1, i);
        }
    }
}