import java.io.*;
import java.util.StringTokenizer;

public class Main_5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int data) {
            if (this.data > data) {
                if (left == null) left = new Node(data);
                else left.insert(data);
            } else {
                if (right == null) right = new Node(data);
                else right.insert(data);
            }
        }

        public void postOrder() throws IOException {
            if (left != null) left.postOrder();
            if (right != null) right.postOrder();
            bw.write(data + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Node root = new Node(Integer.parseInt(br.readLine()));

        br.lines().mapToInt(Integer::parseInt).forEach(root::insert);
        root.postOrder();
        bw.close();
    }
}