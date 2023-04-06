import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1099_알_수_없는_문장 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int cost = 0;
    static int numAlpabet = 26;

    public static void main(String[] args) throws IOException {
        String strInput = br.readLine();
        int iNum = Integer.parseInt(br.readLine());
        String[] arr_SecondInput = new String[iNum];

        for (int i = 0; i < iNum; i++) arr_SecondInput[i] = br.readLine();

        int[] dp = new int[strInput.length() + 1];
        Arrays.fill(dp, 100000);

        dp[0] = 0;
        for (int i = 0; i < strInput.length(); i++) {
            for (int j = 0; j < iNum; j++) {
                String strTemp = arr_SecondInput[j];
                int size_strTemp = strTemp.length();

                if (size_strTemp > i + 1) continue;

                int[] cnt = new int[numAlpabet];
                int[] cnts = new int[numAlpabet];

                IntStream.range(0, size_strTemp).forEach(k -> cnt[strTemp.charAt(k) - 'a']++);

                for (int k = 0; k < size_strTemp; k++) cnts[strInput.charAt(i - k) - 'a']++;
                int test = 1;
                for (int k = 0; k < numAlpabet; k++) {
                    if (cnt[k] == cnts[k]) test = 1;
                    else {
                        test = 0;
                        break;
                    }
                }
                if (test == 0) continue;

                int val = 0;
                for (int k = 0; k < size_strTemp; k++) {
                    if ((strInput.charAt(i + 1 - size_strTemp + k) != strTemp.charAt(k))) {
                        val += 1;
                    }
                }
                dp[i + 1] = Math.min(dp[i + 1], dp[i + 1 - size_strTemp] + val);
            }
        }
        if (dp[strInput.length()] == 100000) System.out.println(-1);
        else System.out.println(dp[strInput.length()]);

    }
}