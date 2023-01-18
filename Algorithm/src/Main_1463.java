import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1463 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> DP;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;

		while (n != 1) {
			if (n % 3 == 0) {
				n /= 3;
			} else if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
			}
			cnt++;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
	
}
