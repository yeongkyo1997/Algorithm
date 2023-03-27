import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                if ("0".equals(st.nextToken())) cnt++;
            }

            switch (cnt) {
                case 1:
                    bw.write("A" + "\n");
                    break;
                case 2:
                    bw.write("B" + "\n");
                    break;
                case 3:
                    bw.write("C" + "\n");
                    break;
                case 4:
                    bw.write("D" + "\n");
                    break;
                case 0:
                    bw.write("E" + "\n");
            }
        }
        bw.close();
    }
}