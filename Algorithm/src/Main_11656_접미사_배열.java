import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11656_접미사_배열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder(br.readLine());
        List<String> list = new ArrayList<>();

        while (sb.length() != 0) {
            list.add(sb.toString());
            sb.deleteCharAt(0);
        }

        Collections.sort(list);
        for (String s : list) {
            bw.write(s + "\n");
        }
        bw.close();
    }
}
