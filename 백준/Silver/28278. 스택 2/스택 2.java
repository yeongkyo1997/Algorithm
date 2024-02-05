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

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if (stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.pop() + "\n");
                    break;
                case 3:
                    bw.write(stack.size() + "\n");
                    break;
                case 4:
                    if (stack.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case 5:
                    if (stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.peek() + "\n");
                    break;
            }
        }
        bw.close();
    }
}