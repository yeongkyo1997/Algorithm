import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_12891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int result = 0;
    private static int[] DNA;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        StringBuilder str = new StringBuilder(br.readLine());
        DNA = new int[4];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            DNA[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        if (isACGT(str.substring(0, P).toCharArray()))
            result++;

        for (int i = 1; i < S - P + 1; i++) {
            if (isACGT(str.substring(i, i + P).toCharArray())) {
                result++;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static boolean isACGT(char[] ch) {
        int[] tmp = new int[4];
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case 'A':
                    tmp[0]++;
                    break;
                case 'C':
                    tmp[1]++;
                    break;
                case 'G':
                    tmp[2]++;
                    break;
                case 'T':
                    tmp[3]++;
                    break;
            }
        }
        for (int j = 0; j < 4; j++) {
            if (tmp[j] < DNA[j])
                return false;
        }
        return true;
    }
}
