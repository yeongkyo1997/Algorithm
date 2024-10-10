import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        Integer[] list = new Integer[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Collections.sort(Arrays.asList(list), (o1, o2) -> Integer.compare(o1, o2));

        for (int a : list) {
            bw.write(a + "\n");
        }

        bw.close();
    }
}