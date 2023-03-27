import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main_10867 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = IntStream.range(0, N).mapToObj(i -> Integer.parseInt(st.nextToken())).distinct().sorted().collect(Collectors.toCollection(ArrayList::new));

        for (Integer integer : list) bw.write(integer + " ");
        bw.close();
    }
}
