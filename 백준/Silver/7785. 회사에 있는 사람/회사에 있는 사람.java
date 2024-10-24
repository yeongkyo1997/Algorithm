import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> tree = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String name;
            String command;
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            command = st.nextToken();

            if (command.equals("enter")) {
                tree.add(name);
            } else if (command.equals("leave")) {
                tree.remove(name);
            }
        }

        while (!tree.isEmpty()) {
            bw.write(tree.pollLast() + "\n");
        }

        bw.close();
    }
}