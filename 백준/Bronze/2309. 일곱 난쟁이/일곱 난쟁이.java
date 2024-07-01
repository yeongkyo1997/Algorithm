import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] people;

	public static void main(String[] args) throws IOException {
		people = new int[9];
		for (int i = 0; i < 9; i++) {
			people[i] = Integer.parseInt(br.readLine());
		}

		people = Arrays.stream(people).boxed().sorted().mapToInt(Integer::intValue).toArray();

		combination(new int[7], 0, 0);
	}

	static void combination(int[] arr, int start, int depth) throws IOException {
		if (depth == 7) {
			int sum = 0;
			for (int i : arr) {
				sum += i;
			}
			if (sum == 100) {
				for (int i : arr) {
					bw.write(i + "\n");
				}
				bw.close();
				System.exit(0);
			}

			return;
		}

		for (int i = start; i < 9; i++) {
			arr[depth] = people[i];
			combination(arr, i + 1, depth + 1);
		}
	}
}