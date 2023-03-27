import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if (n <= 10) System.out.println(n);
        else if (n > 1022) System.out.println("-1");
        else {
            for (int i = 0; i < 10; i++) {
                solve(i, 1);
            }
            Collections.sort(list);

            bw.write(list.get(n) + "");
        }
        bw.close();
    }

    public static void solve(long num, int idx) {
        if (idx > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            solve((num * 10) + i, idx + 1);
        }
    }
}