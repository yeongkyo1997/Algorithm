import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		bw.write("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n"
				+ "N2 Bomber      Heavy Fighter  Limited    21        \n"
				+ "J-Type 327     Light Combat   Unlimited  1         \n"
				+ "NX Cruiser     Medium Fighter Limited    18        \n"
				+ "N1 Starfighter Medium Fighter Unlimited  25        \n"
				+ "Royal Cruiser  Light Combat   Limited    4         ");
		bw.flush();
		bw.close();
	}
}
