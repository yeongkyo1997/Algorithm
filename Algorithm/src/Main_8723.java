import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_8723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int[] list = IntStream.range(0, 3).map(i -> Integer.parseInt(st.nextToken())).toArray();
        Arrays.sort(list);
        if (list[0] * list[0] + list[1] * list[1] == list[2] * list[2]) bw.write(1 + "");
        else if (list[0] == list[1] && list[1] == list[2]) bw.write(2 + "");
        else bw.write(0 + "");
        bw.close();
    }
}
