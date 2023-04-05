import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10825_국영수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        String name;
        int kor, eng, math;

        public Node(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Node o) {
            if (this.kor == o.kor) {
                if (this.eng == o.eng) {
                    if (this.math == o.math) {
                        return this.name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }
                return this.eng - o.eng;
            }
            return o.kor - this.kor;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Node(name, kor, eng, math));
        }

        Collections.sort(list);

        for (Node node : list) bw.write(node.name + "\n");

        bw.close();
    }
}
