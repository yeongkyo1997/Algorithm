import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static public void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] list = new String[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = st.nextToken();
        }
        Arrays.sort(list, (s1, s2) -> {
            if (s1.equals(s2))
                return s2.compareTo(s1);
            else {
                return s2.concat(s1).compareTo(s1.concat(s2));
            }
        });
        if (list[0].equals("0"))
            bw.write("0");
        else {
            for (int i = 0; i < list.length; i++) {
                bw.write(list[i]);
            }
        }
        bw.flush();
        bw.close();
    }
}