import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        bw.write((Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken())) + "");
        bw.flush();
        bw.close();
    }
}
