import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2072 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] board;

	public static void main(String[] args) throws IOException {
		int n = parseInt(br.readLine());
		board = new int[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x, y;
			x = parseInt(st.nextToken());
			y = parseInt(st.nextToken());
			
		}
	}
}
