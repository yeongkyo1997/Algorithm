import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                list.add(Integer.valueOf(st.nextToken()));
            }
            int sum = list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
            int min = list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).min().getAsInt();
            bw.write(String.format("%d %d\n", sum, min));
        }
        bw.close();
    }
}