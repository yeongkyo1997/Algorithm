import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[data - 'A'] = new Node(data, left, right);
        }
        preorder(tree[0]);
        bw.write("\n");
        inorder(tree[0]);
        bw.write("\n");
        postorder(tree[0]);
        bw.flush();
        bw.close();
    }

    static void preorder(Node node) throws IOException {
        bw.write(node.data);
        if (node.left != '.') preorder(tree[node.left - 'A']);
        if (node.right != '.') preorder(tree[node.right - 'A']);
    }

    static void inorder(Node node) throws IOException {
        if (node.left != '.') inorder(tree[node.left - 'A']);
        bw.write(node.data);
        if (node.right != '.') inorder(tree[node.right - 'A']);
    }

    static void postorder(Node node) throws IOException {
        if (node.left != '.') postorder(tree[node.left - 'A']);
        if (node.right != '.') postorder(tree[node.right - 'A']);
        bw.write(node.data);
    }

    static class Node {
        char data;
        char left;
        char right;

        public Node(char data, char left, char right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}