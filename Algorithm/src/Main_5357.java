import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_5357 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Deque<Character> deque = new ArrayDeque<>();
            String str = br.readLine();

            deque.add(str.charAt(0));
            for (int j = 1; j < str.length(); j++) {
                if (deque.peekLast() != str.charAt(j))
                    deque.addLast(str.charAt(j));
            }

            for (Character character : deque) {
                bw.write(character + "");
            }
            bw.write("\n" + "");
        }
        bw.close();
    }
}
