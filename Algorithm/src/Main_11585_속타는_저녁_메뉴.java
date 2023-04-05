import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11585_속타는_저녁_메뉴 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] target = new int[N];
        int[] roulette = new int[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            roulette[i] = Integer.parseInt(st.nextToken());
            roulette[i + N] = roulette[i];
        }

        int[] pi = getPi(target);
        int targetCount = findKeyword(roulette, target, pi);

        for (int i = targetCount; i > 0; i--) {
            if (targetCount % i == 0 && N % i == 0) {
                bw.write(targetCount / i + "/" + N / i);
                break;
            }
        }
        bw.flush();
        bw.close();
    }

    static int[] getPi(int[] keyword) {
        int keywordLength = keyword.length;
        int[] pi = new int[keywordLength];

        int j = 0;
        for (int i = 1; i < keywordLength; i++) {
            while (keyword[i] != keyword[j] && j > 0) {
                j = pi[j - 1];
            }

            if (keyword[i] == keyword[j]) {
                j += 1;
                pi[i] = j;
            }
        }

        return pi;
    }

    static int findKeyword(int[] string, int[] keyword, int[] pi) {
        int keywordCount = 0;
        int stringLength = string.length;
        int keywordLength = keyword.length;

        int i = 0, j = 0;
        while (i < stringLength) {
            if (string[i] == keyword[j]) {
                i += 1;
                j += 1;
            } else {
                if (j == 0) {
                    i += 1;
                } else {
                    j = pi[j - 1];
                }
            }

            if (j == keywordLength) {
                keywordCount += 1;
                j = pi[j - 1];
            }
        }

        return keywordCount;
    }
}