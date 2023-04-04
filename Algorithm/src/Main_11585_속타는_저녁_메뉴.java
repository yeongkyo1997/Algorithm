import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11585_속타는_저녁_메뉴 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] text = br.readLine().split(" ");
        String[] pattern = br.readLine().split(" ");
        int tLength = text.length, pLength = pattern.length;
        int[] pi = new int[tLength];

        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && !pattern[i].equals(pattern[j])) j = pi[j - 1];

            if (pattern[i].equals(pattern[j])) pi[i] = ++j;
            else pi[i] = 0;
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < tLength; i++) {
            while (j > 0 && !text[i].equals(pattern[j])) j = pi[j - 1];

            if (text[i].equals(pattern[j])) {
                if (j == pLength - 1) {
                    cnt++;
                    list.add(i - pLength + 2);
                    j = pi[j];
                } else j++;
            }
        }
        System.out.println(cnt);
    }
}
