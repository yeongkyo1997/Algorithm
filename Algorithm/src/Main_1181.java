import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main_1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        ArrayList<String> list = new ArrayList<>(set);
        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });

        for (String s : list)
            bw.write(s + "\n");

        bw.flush();
        bw.close();
    }
}
