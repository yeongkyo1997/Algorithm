import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!stack.isEmpty() && list[i] > list[stack.peek()]) {
                list[stack.pop()] = list[i];
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            list[stack.pop()] = -1;
        }

        for (int i : list) {
            bw.write(i + " ");
        }
        bw.close();
    }
}