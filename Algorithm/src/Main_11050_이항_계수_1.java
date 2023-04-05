import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11050_이항_계수_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N, K;
		N = parseInt(st.nextToken());
		K = parseInt(st.nextToken());

		int nFac = 1;
		for (int i = 1; i <= N; i++) {
			nFac *= i;
		}

		int kFac = 1;
		for (int i = 1; i <= K; i++) {
			kFac *= i;
		}
		int nkFac = 1;
		for (int i = 1; i <= N - K; i++) {
			nkFac *= i;
		}
		bw.write((nFac / (kFac * nkFac)) + "");
		bw.flush();
		bw.close();
	}
}
