import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static ArrayList<int[]> result = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		
		permutation(new int[M], 0);
		
		for (int[] r : result) {
			for (int i : r) {
				bw.write(i + " ");
			}
			bw.newLine();
		}

		bw.close();
	}

	static void permutation(int[] arr, int depth) {
		if (depth == M) {
			result.add(arr.clone());
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				arr[depth] = i;
				visited[i] = true;
				permutation(arr, depth + 1);
				visited[i] = false;
			}
		}
	}
}