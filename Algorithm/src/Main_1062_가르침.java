import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Character> charSet = new HashSet<>();
        int[] binaries = new int[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int num = 0;

            for (char c : s.toCharArray()) {
                charSet.add(c);
                num |= (1 << (c - 'a'));
            }
            binaries[i] = num;
        }

        Character[] charArr = charSet.toArray(new Character[0]);
        int maxCount = 0;

        for (int i = 0; i < (1 << charArr.length); i++) {
            if (Integer.bitCount(i) != M) continue;
            int tmp = 0;

            for (int j = 0; j < charArr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp |= (1 << (charArr[j] - 'a'));
                }
            }

            int cnt = 0;
            for (int binary : binaries)
                if ((tmp & binary) == binary) cnt++;

            maxCount = Math.max(maxCount, cnt);
        }

        bw.write(charSet.size() <= M ? N + "\n" : maxCount + "\n");


        bw.close();
    }
}