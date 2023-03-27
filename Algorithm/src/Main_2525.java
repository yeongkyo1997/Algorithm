import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main_2525 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int hour = parseInt(st.nextToken());
        int minute = parseInt(st.nextToken());
        int C = parseInt(br.readLine());

        minute += C;

        hour += minute / 60;
        minute %= 60;
        hour %= 24;

        bw.write(hour + " " + minute);
        bw.flush();
        bw.close();
	}
}
