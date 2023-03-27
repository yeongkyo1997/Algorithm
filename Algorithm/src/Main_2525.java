import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2525 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int hour, minute;
		int C;
		st = new StringTokenizer(br.readLine());

		hour = parseInt(st.nextToken());
		minute = parseInt(st.nextToken());
		C = parseInt(br.readLine());

		minute += C;

		hour += minute / 60;
		minute %= 60;
		hour %= 24;

		bw.write(hour + " " + minute);
		bw.flush();
		bw.close();
	}
}
