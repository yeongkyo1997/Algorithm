import java.io.*;
import java.util.*;

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

        for (int i = 0; i < N; i++) {
            list1.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            list2.add(br.readLine());
        }

        Collections.sort(list2);
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (Collections.binarySearch(list2, list1.get(i), (String::compareTo)) >= 0)
                result++;
        }

        bw.write(result + "");
        bw.close();
    }
}
