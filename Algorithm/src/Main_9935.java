import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		StringBuilder sb = new StringBuilder(str);
		String replString = br.readLine();
		int len = str.length();

		while (true) {
			sb = sb.delete(sb.indexOf(replString), replString.length() + sb.indexOf(replString) - 1);
			if (sb.length() == len)
				break;
			len = sb.length();
		}

		if ("".equals(sb.toString()))
			bw.write("FRULA" + "\n");
		else
			bw.write(sb + "\n");
		bw.flush();
		bw.close();
	}
}
