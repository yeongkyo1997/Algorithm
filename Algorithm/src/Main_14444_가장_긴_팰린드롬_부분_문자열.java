import java.io.*;
import java.util.StringTokenizer;

public class Main_14444_가장_긴_팰린드롬_부분_문자열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static int findLongestPalindromeSubstringLength(String s) {
        StringBuilder processedString = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            processedString.append(s.charAt(i));
            processedString.append("#");
        }

        int[] palindromeLengths = new int[processedString.length()];
        int center = 0;
        int rightBoundary = 0;
        int maxPalindromeLength = 0;

        for (int i = 0; i < processedString.length(); i++) {
            int mirror = 2 * center - i;
            if (i < rightBoundary) {
                palindromeLengths[i] = Math.min(rightBoundary - i, palindromeLengths[mirror]);
            }

            int left = i - (palindromeLengths[i] + 1);
            int right = i + (palindromeLengths[i] + 1);
            while (left >= 0 && right < processedString.length() && processedString.charAt(left) == processedString.charAt(right)) {
                palindromeLengths[i]++;
                left--;
                right++;
            }

            if (i + palindromeLengths[i] > rightBoundary) {
                rightBoundary = i + palindromeLengths[i];
                center = i;
            }

            maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLengths[i]);
        }

        return maxPalindromeLength;
    }

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        int longestPalindromeLength = findLongestPalindromeSubstringLength(s);
        bw.write(String.valueOf(longestPalindromeLength));
        bw.close();
    }
}
