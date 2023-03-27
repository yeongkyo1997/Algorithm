import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] list = new Integer[N];
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            stack.add(list[i]);
        }

        for (int i = 0; i < N; i++) {
        }
    }
}
