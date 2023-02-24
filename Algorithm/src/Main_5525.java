import java.io.*;
import java.util.StringTokenizer;
<<<<<<< HEAD
import java.util.regex.Matcher;
import java.util.regex.Pattern;
=======
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2

public class Main_5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
<<<<<<< HEAD

        StringBuilder IOI = new StringBuilder();
        for (int i = 0; i < N; i++)
            IOI.append("IO");

        IOI.append("I");
        Pattern pattern = Pattern.compile(IOI.toString());
        Matcher matcher = pattern.matcher(str);

        int cnt = 0;
        while (matcher.find()) cnt++;

        bw.write(cnt + "");
=======
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < M - 2; i++) {
            if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
                cnt++;
                if (cnt == N) {
                    cnt--;
                    result++;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        bw.write(result + "\n");
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
        bw.close();
    }
}
