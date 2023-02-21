import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder IOI = new StringBuilder();
        for (int i = 0; i < N; i++)
            IOI.append("IO");

        IOI.append("I");
        Pattern pattern = Pattern.compile(IOI.toString());
        Matcher matcher = pattern.matcher(str);

        int cnt = 0;
        while (matcher.find()) cnt++;

        bw.write(cnt + "");
        bw.close();
    }
}
