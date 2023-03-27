import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

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

        IntStream.range(0, 4).forEach(i -> DNA[i] = Integer.parseInt(st.nextToken()));

        int result = 0;
        if (isACGT(str.substring(0, P).toCharArray())) result++;

        result += IntStream.range(1, S - P + 1).filter(i -> isACGT(str.substring(i, i + P).toCharArray())).count();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static boolean isACGT(char[] ch) {
        int[] tmp = new int[4];
        for (char c : ch) {
            switch (c) {
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
            if (tmp[j] < DNA[j]) return false;
        }
        return true;
    }
}
