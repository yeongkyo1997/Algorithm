import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main_10250_ACM_호텔 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int H, N;
			H = parseInt(st.nextToken());
			st.nextToken();
			N = parseInt(st.nextToken());

			if (N % H == 0)
				bw.write(1 + "");
			else
				bw.write(String.valueOf(N % H));
			bw.write("0" + (int) Math.ceil(N / (double) H) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
