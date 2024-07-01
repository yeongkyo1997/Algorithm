import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static ArrayList<int[]> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		combination(new int[M], 1, 0);
		for (int[] r : result) {
			for (int i : r) {
				bw.write(i + " ");
			}
			bw.newLine();
		}
		
		bw.close();
	}

	static void combination(int[] arr, int start, int depth) {
		if (depth == M) {
			result.add(arr.clone());
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			combination(arr, i + 1, depth + 1);
		}
	}
}