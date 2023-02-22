import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		bw.write(".  .   .\n");
		bw.write("|  | _ | _. _ ._ _  _\n");
		bw.write("|/\\|(/.|(_.(_)[ | )(/.\n");

		bw.flush();
		bw.close();
	}
}
