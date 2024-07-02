import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[] result;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			result[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int a, b;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			while (a < b) {
				result[a] = result[a] ^ result[b];
				result[b] = result[a] ^ result[b];
				result[a] = result[a] ^ result[b];
				a++;
				b--;
			}
		}

		for (int i = 1; i <= N; i++) {
			bw.write(result[i] + " ");
		}
		bw.close();
	}
}