import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] Index = new int[100001];
    static int[] inorder = new int[100001];
    static int[] postorder = new int[100001];
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            Index[inorder[i]] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        getPreOrder(1, n, 1, n);
        bw.flush();
        bw.close();
    }

    static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) throws Exception {
        if (inStart > inEnd || postStart > postEnd) return;
        int rootIndex = Index[postorder[postEnd]];
        int leftSize = rootIndex - inStart;
        bw.write(inorder[rootIndex] + " ");
        getPreOrder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        getPreOrder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}