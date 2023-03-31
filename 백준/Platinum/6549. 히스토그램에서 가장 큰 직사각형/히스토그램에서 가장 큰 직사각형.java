import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    int height = arr[stack.pop()];
                    int width = i;
                    if (!stack.isEmpty()) {
                        width = (i - stack.peek() - 1);
                    }
                    max = Math.max(max, (long) height * width);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int height = arr[stack.pop()];
                int width = n;
                if (!stack.isEmpty()) {
                    width = (n - stack.peek() - 1);
                }
                max = Math.max(max, (long) height * width);
            }
            bw.write(max + "\n");
        }
        bw.close();
    }
}