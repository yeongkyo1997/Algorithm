import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16212_정열적인_정렬 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());


        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(java.util.stream.Collectors.toList());

        for (int i = 0; i < n; i++) {
            bw.write(list.get(i) + " ");
        }
        bw.close();
    }
}
