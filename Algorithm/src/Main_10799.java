import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10799 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();

                if (str.charAt(i - 1) == '(') result += stack.size();
                else result++;
            }
        }

        bw.write(result + "\n");
        bw.close();
    }
}
