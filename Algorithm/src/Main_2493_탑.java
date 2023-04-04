import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] list;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && list[stack.peek()] < list[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) bw.write("0 ");
            else bw.write(stack.peek() + 1 + " ");
            stack.push(i);
        }
        bw.close();
    }
}
