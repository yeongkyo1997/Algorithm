import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Tree {
        Node root;
        int cnt;

        Tree() {
            this.root = null;
            cnt = 0;
        }

        void insert(int data) {
            Node node = new Node(data);
            Node cur = this.root;

            if (root == null)
                root = node;
            else {
                while (true) {
                    if (cur.data > data)
                        if (cur.left == null) {
                            cur.left.data = data;
                            return;
                        } else {
                        }
                }
            }
        }
    }

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }

    }

    public static void main(String[] args) throws IOException {

    }

}
