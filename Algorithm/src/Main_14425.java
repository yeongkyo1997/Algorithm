import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_14425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();

        for (int i = 0; i < N; i++) list1.add(br.readLine());

        for (int i = 0; i < M; i++) list2.add(br.readLine());

        Collections.sort(list2);
        int result = (int) IntStream.range(0, N).filter(i -> Collections.binarySearch(list2, list1.get(i), (String::compareTo)) >= 0).count();

        bw.write(result + "");
        bw.close();
    }
}
