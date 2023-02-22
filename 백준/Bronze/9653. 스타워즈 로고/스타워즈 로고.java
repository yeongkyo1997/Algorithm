import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		bw.write("    8888888888  888    88888\n");
		bw.write("   88     88   88 88   88  88\n");
		bw.write("    8888  88  88   88  88888\n");
		bw.write("       88 88 888888888 88   88\n");
		bw.write("88888888  88 88     88 88    888888\n");
		bw.write("\n");
		bw.write("88  88  88   888    88888    888888\n");
		bw.write("88  88  88  88 88   88  88  88\n");
		bw.write("88 8888 88 88   88  88888    8888\n");
		bw.write(" 888  888 888888888 88  88      88\n");
		bw.write("  88  88  88     88 88   88888888\n");
		bw.flush();
		bw.close();
	}
}
