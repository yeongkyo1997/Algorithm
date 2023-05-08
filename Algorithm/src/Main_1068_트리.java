import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1068_트리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, k, leaf = 0, root;
    static List<Integer>[] tree = new List[51];

    static int dfs(int node) {
        if (node == k) return -1;

        if (tree[node].size() == 0) {
            leaf++;
            return 0;
        }

        for (int i = 0; i < tree[node].size(); i++) {
            int tmp = dfs(tree[node].get(i));
            if (tmp == -1 && tree[node].size() == 1) leaf++;
        }
        return 0;
    }


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        IntStream.range(0, N).forEach(i -> tree[i] = new ArrayList<>());

        for (int i = 0; i < N; i++) {
            int t1 = Integer.parseInt(st.nextToken());
            if (t1 == -1) root = i;
            else tree[t1].add(i);
        }

        k = Integer.parseInt(br.readLine());
        dfs(root);
        bw.write(leaf + "\n");
        bw.close();
    }
}