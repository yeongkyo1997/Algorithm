import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1099_알_수_없는_문장 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int numAlpha = 26;

    public static void main(String[] args) throws IOException {
        String strInput = br.readLine();
        int iNum = Integer.parseInt(br.readLine());
        String[] strings = new String[iNum];

        for (int i = 0; i < iNum; i++) strings[i] = br.readLine();

        int[] dp = new int[strInput.length() + 1];
        Arrays.fill(dp, 100000);

        dp[0] = 0;
        for (int i = 0; i < strInput.length(); i++) {
            for (int j = 0; j < iNum; j++) {
                String strTmp = strings[j];
                int length = strTmp.length();

                if (length > i + 1) continue;

                int[] cnt1 = new int[numAlpha];
                int[] cnt2 = new int[numAlpha];

                IntStream.range(0, length).forEach(k -> cnt1[strTmp.charAt(k) - 'a']++);

                for (int k = 0; k < length; k++) cnt2[strInput.charAt(i - k) - 'a']++;
                int test = IntStream.range(0, numAlpha).anyMatch(k -> cnt1[k] != cnt2[k]) ? 0 : 1;
                if (test == 0) continue;

                int val = 0;
                for (int k = 0; k < length; k++) {
                    if ((strInput.charAt(i + 1 - length + k) != strTmp.charAt(k))) val += 1;
                }

                dp[i + 1] = Math.min(dp[i + 1], dp[i + 1 - length] + val);
            }
        }

        if (dp[strInput.length()] == 100000) bw.write(-1 + "\n");
        else bw.write(dp[strInput.length()] + "\n");
        bw.close();
    }
}