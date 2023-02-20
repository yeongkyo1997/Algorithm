import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && rank(stack.peek()) >= rank(ch))
                        bw.write(stack.pop() + "");
                    stack.add(ch);
                    break;
                case '(':
                    stack.add(ch);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(')
                        bw.write(stack.pop() + "");
                    stack.pop();
                    break;
                default:
                    bw.write(ch + "");
            }
        }
        while (!stack.isEmpty())
            bw.write(stack.pop() + "");
        bw.flush();
        bw.close();
    }

    static int rank(char ch) {
        switch (ch) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}
