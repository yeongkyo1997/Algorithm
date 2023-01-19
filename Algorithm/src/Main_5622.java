import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_5622 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		int sum = 0;

		map.put("ABC", 2);
		map.put("DEF", 3);
		map.put("GHI", 4);
		map.put("JKL", 5);
		map.put("MNO", 6);
		map.put("PQRS", 7);
		map.put("TUV", 8);
		map.put("WXYZ", 9);
		
		while (st.hasMoreTokens()) {
		}
	}
}
