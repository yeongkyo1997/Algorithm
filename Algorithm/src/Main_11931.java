import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11931 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o2, o1) -> o1 - o2);

		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		while (!pq.isEmpty()) {
			bw.write(pq.poll() + "\n");
		}
		bw.close();
	}
}
