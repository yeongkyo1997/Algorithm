import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int[] list = new int[3];

		for (int i = 0; i < 3; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(list);
		bw.write(list[1] + "");
		bw.flush();
		bw.close();
	}
}
