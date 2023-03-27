import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_2493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] list;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        range(0, N).forEach(i -> list[i] = Integer.parseInt(st.nextToken()));

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && list[stack.peek()] < list[i]) stack.pop();
            bw.write(stack.isEmpty() ? "0 " : stack.peek() + 1 + " ");
            stack.push(i);
        }
        bw.close();
    }
}
