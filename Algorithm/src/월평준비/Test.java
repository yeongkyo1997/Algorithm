package 월평준비;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int max = Arrays.stream(list).max().getAsInt();
        double result = Arrays.stream(list).mapToDouble(x -> x / (double) max * 100).average().getAsDouble();

        bw.write(result + "");
        bw.close();
    }
}
