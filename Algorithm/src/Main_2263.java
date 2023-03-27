import java.io.*;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_2263 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] inOrder = new int[n];
        int[] index = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        range(0, n).forEach(i -> {
            inOrder[i] = Integer.parseInt(st.nextToken());
            index[inOrder[i]] = i;
        });
        st = new StringTokenizer(br.readLine());
        int[] postOrder = range(0, n).map(i -> Integer.parseInt(st.nextToken())).toArray();
        preOrder(postOrder, index, 0, n - 1, 0, n - 1);
        bw.close();
    }

    public static void preOrder(int[] postOrder, int[] index, int inStart, int inEnd, int postStart, int postEnd) throws IOException {
        if (inStart > inEnd || postStart > postEnd) return;
        int root = postOrder[postEnd];
        bw.write(root + " ");

        int inRoot = index[root];
        int left = inRoot - inStart;
        preOrder(postOrder, index, inStart, inRoot - 1, postStart, postStart + left - 1);
        preOrder(postOrder, index, inRoot + 1, inEnd, postStart + left, postEnd - 1);
    }
}
