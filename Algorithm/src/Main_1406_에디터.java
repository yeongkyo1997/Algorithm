import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1406_에디터 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();
    static int N;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();

        IntStream.range(0, str.length()).forEach(i -> left.push(str.charAt(i)));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "L":
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if (!left.isEmpty()) left.pop();
                    break;
                case "P":
                    left.push(st.nextToken().charAt(0));
                    break;
            }
        }
        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) bw.write(right.pop());
        bw.close();
    }
}
