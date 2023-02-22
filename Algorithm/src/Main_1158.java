import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

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
