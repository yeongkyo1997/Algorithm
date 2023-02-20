import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int[] list = new int[3];
        for (int i = 0; i < 3; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        if (list[0] * list[0] + list[1] * list[1] == list[2] * list[2]) bw.write(1 + "");
        else if (list[0] == list[1] && list[1] == list[2]) bw.write(2 + "");
        else bw.write(0 + "");
        bw.close();
    }
}