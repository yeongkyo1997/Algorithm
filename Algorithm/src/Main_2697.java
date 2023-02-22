import java.io.*;
import java.util.StringTokenizer;

public class Main_2697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] list = br.readLine().toCharArray();
            if (!nextPerm(list))
                bw.write("BIGGEST" + "\n");
            else
                for (char c : list) {
                    bw.write(c + "");
                }
            bw.write("\n" + "");
        }
        bw.close();
    }

    static boolean nextPerm(char[] list) {
        int n = list.length;

        int i = n - 1;
        while (i > 0 && list[i - 1] >= list[i]) i--;
        if (i == 0) return false;

        int j = n - 1;
        while (list[i - 1] >= list[j]) j--;
        swap(list, i - 1, j);

        int k = n - 1;
        while (i < k) swap(list, i++, k--);

        return true;
    }

    static void swap(char[] list, int a, int b) {
        char tmp = list[a];
        list[a] = list[b];
        list[b] = tmp;
    }
}
