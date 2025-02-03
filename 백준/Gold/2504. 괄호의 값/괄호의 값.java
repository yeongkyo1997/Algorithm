import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine().trim();
        Stack<Long> stack = new Stack<>();
        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {

                stack.push(-1L);
            } else if (c == '[') {

                stack.push(-2L);
            } else if (c == ')') {
                long sum = 0;
                boolean found = false;

                while (!stack.isEmpty()) {
                    long top = stack.pop();
                    if (top == -1L) {
                        found = true;
                        break;
                    } else if (top == -2L) {
                        valid = false;
                        break;
                    } else {

                        sum += top;
                    }
                }
                if (!valid || !found) {
                    valid = false;
                    break;
                }

                if (sum == 0) {
                    stack.push(2L);
                } else {
                    stack.push(sum * 2);
                }
            } else if (c == ']') {
                long sum = 0;
                boolean found = false;

                while (!stack.isEmpty()) {
                    long top = stack.pop();
                    if (top == -2L) {
                        found = true;
                        break;
                    } else if (top == -1L) {
                        valid = false;
                        break;
                    } else {
                        sum += top;
                    }
                }
                if (!valid || !found) {
                    valid = false;
                    break;
                }

                if (sum == 0) {
                    stack.push(3L);
                } else {
                    stack.push(sum * 3);
                }
            } else {

                valid = false;
                break;
            }
        }

        if (!valid) {
            bw.write("0");
        } else {
            long result = 0;

            for (long num : stack) {
                if (num < 0) {
                    result = 0;
                    valid = false;
                    break;
                }
                result += num;
            }
            bw.write(String.valueOf(result));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}