import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int cur = 1;
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        while (idx < N) {
            if (cur == list[idx]) {
                cur++;
                idx++;
            } else if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                cur++;
            } else {
                stack.push(list[idx]);
                idx++;
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == cur) {
                stack.pop();
                cur++;
            } else {
                break;
            }
        }

        if (stack.isEmpty()) {
            bw.write("Nice\n");
        } else {
            bw.write("Sad\n");
        }
        bw.close();
    }
}