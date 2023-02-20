import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		if (a == 60 && b == 60 && c == 60) {
			bw.write("Equilateral");
		}
		else if (a + b + c == 180 && (a == b || b == c || c == a))
			bw.write("Isosceles");
		else if (a + b + c == 180 && (a!=b&&b!=c&&c!=a))
			bw.write("Scalene");
		else{
			bw.write("Error");
		}
		bw.flush();
		bw.close();
	}
}
