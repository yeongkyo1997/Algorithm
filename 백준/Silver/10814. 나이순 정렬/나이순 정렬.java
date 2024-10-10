import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        int age;
        String name;

        public Node(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.age, other.age);
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Node(age, name));
        }
        Collections.sort(list);

        for (Node node : list) {
            bw.write(node + "\n");
        }
        bw.close();
    }
}