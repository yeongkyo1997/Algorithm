import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> set1 = new HashSet<>(Arrays.asList(a));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(b));
		Set<Integer> tmp = new HashSet<>();
		;
		tmp.addAll(set1);

		set1.removeAll(set2);
		set2.removeAll(tmp);

		bw.write((set1.size() + set2.size()) + "");
		bw.flush();
		bw.close();
	}
}
