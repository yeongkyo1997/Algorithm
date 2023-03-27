import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main_1158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = IntStream.range(0, N).mapToObj(i -> i + 1).collect(Collectors.toCollection(LinkedList::new));

        int idx = 0;
        bw.write("<");
        while (N != 0) {
            idx = (idx + K - 1) % N;

            bw.write(list.get(idx) + "");
            list.remove(idx);

            N--;
            if (N != 0) bw.write(", ");
        }

        bw.write(">");
        bw.close();
    }
}
