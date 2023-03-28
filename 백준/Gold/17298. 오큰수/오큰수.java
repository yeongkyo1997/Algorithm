import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && list[stack.peek()] < list[i]) {
                list[stack.pop()] = list[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            list[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            bw.write(list[i] + " ");
        }

        bw.close();
    }
}