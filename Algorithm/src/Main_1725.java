import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine()));
        Stack<Integer> stack = new Stack<>();
        list.add(0);
        stack.add(0);

        int result = 0;

        for (int i = 1; i < N + 2; i++) {
            while (list.get(stack.peek()) > list.get(i)) {
                int height = list.get(stack.pop());
                int width = i - stack.peek() - 1;
                result = Math.max(result, height * width);
            }
            stack.add(i);
        }
        bw.write(result + "");
        bw.close();
    }
}
