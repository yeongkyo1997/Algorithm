import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class Main_11050 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N, K;
        N = parseInt(st.nextToken());
        K = parseInt(st.nextToken());

        int nFac = IntStream.rangeClosed(1, N).reduce(1, (a, b) -> a * b);
        int kFac = IntStream.rangeClosed(1, K).reduce(1, (a, b) -> a * b);
        int nkFac = IntStream.rangeClosed(1, N - K).reduce(1, (a, b) -> a * b);

        bw.write((nFac / (kFac * nkFac)) + "");
        bw.flush();
        bw.close();
    }
}
