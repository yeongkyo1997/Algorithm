package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] inputs;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		int n = 3;
		for (int i = 0; i < n; ++i) {
			System.out.println(i);
		}
	}

	static void subset1(int cnt) throws IOException {
		for (int i = 0; i < N; i++) {
			if ((cnt & 1 << i) != 0) {
				bw.write(inputs[i] + " ");
			}
		}
		bw.write("\n");
	}

	static void subset2(int cnt) {
		if (cnt == 0) {
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					bw.write(inputs[i] + " ");
				}
			}
			bw.write("\n");
			return;
		}
		visited[cnt - 1] = true;
		subset2(cnt - 1);
		visited[cnt - 1] = false;
		subset2(cnt - 1);

	}

	static void subsetSum(int cnt, int sum) {
		if (cnt == 0) {
			bw.write(sum + "\n");
			return;
		}
		subsetSum(cnt - 1, sum + inputs[cnt - 1]);
		subsetSum(cnt - 1, sum);

	}
}
