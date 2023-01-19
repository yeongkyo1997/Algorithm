import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2038 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = parseInt(br.readLine());
		bw.write(findFn(n) + "");
		bw.flush();
		bw.close();
	}

	public static int findFn(int n) {
		return (int) (Math.floor(Math.log(n) / Math.log(2))) + 1;
	}

}
