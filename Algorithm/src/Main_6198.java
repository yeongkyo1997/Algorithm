import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_6198 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        long cnt = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() <= list[i]) {
                stack.pop();
            }
            stack.push(list[i]);
            cnt += stack.size() - 1;
        }

        bw.write(cnt + "");
        bw.close();
    }
}
