import java.io.*;
import java.util.StringTokenizer;

public class Main_9935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String str1  = br.readLine();
		String str2 = br.readLine();
		int len1 = str1.length();
		int len2 = str2.length();
		int[] fail = new int[len2];

		for (int i = 1, j = 0; i < len2; i++) {
			while (j > 0 && str2.charAt(i) != str2.charAt(j)) {
				j = fail[j - 1];
			}
			if (str2.charAt(i) == str2.charAt(j)) {
				fail[i] = ++j;
			}
		}

        StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; i < len1; i++) {
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = fail[j - 1];
			}

            if (str1.charAt(i) == str2.charAt(j)) {
                if (j == len2 - 1) {
                    j = fail[j];
                } else {
                    j++;
                }
            } else {
                sb.append(str1.charAt(i));
            }
        }

        bw.write(sb.length() == 0 ? "FRULA" : sb.toString());
        bw.close();
    }
}
