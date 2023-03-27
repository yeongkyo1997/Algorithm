import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812_크게_만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K;
    static int[] num;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[N];
        String[] s = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(s[i]);
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() < num[i] && idx < K) {
                stack.pop();
                idx++;
            }

            stack.push(num[i]);
        }

        while (idx < K) {
            stack.pop();
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.reverse().toString() + "\n");
        bw.close();
    }
}