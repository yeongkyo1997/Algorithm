import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16637 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char[] exp;
    static int answer = Integer.MIN_VALUE;

    public static int calc(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }

    public static void solve(int idx, int sum) {
        if (idx >= n) {
            answer = Math.max(answer, sum);
            return;
        }

        if (idx + 2 < n && exp[idx + 1] == '+') solve(idx + 2, sum + (exp[idx] - '0') + (exp[idx + 2] - '0'));
        else if (idx + 2 < n && exp[idx + 1] == '-') solve(idx + 2, sum + (exp[idx] - '0') - (exp[idx + 2] - '0'));
        else if (idx + 2 < n && exp[idx + 1] == '*') solve(idx + 2, sum + (exp[idx] - '0') * (exp[idx + 2] - '0'));
        else solve(idx + 2, calc(exp[idx] - '0', exp[idx + 2] - '0', exp[idx + 1]));

        if (idx + 4 < n && exp[idx + 1] == '+' && exp[idx + 3] == '*')
            solve(idx + 4, sum + (exp[idx] - '0') + (exp[idx + 2] - '0') * (exp[idx + 4] - '0'));
        else if (idx + 4 < n && exp[idx + 1] == '-' && exp[idx + 3] == '*')
            solve(idx + 4, sum + (exp[idx] - '0') - (exp[idx + 2] - '0') * (exp[idx + 4] - '0'));
        else if (idx + 4 < n && exp[idx + 1] == '*' && exp[idx + 3] == '*') {
            solve(sum + (exp[idx] - '0') * (exp[idx + 2] - '0') * (exp[idx + 4] - '0'), idx + 4);
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        exp = br.readLine().toCharArray();
        solve(0, 0);
        System.out.println(answer);
    }
}
