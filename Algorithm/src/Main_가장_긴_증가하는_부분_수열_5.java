import java.io.*;
import java.util.*;

public class Main_가장_긴_증가하는_부분_수열_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] dp = new int[N];
        int a;
        int idx = 0, dptmp = 0;
        ArrayList<Integer> L = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a = Integer.parseInt(st.nextToken());
            num[i] = a;

            if (L.size() == 0) {
                L.add(num[i]);
                dp[i] = 1;
            } else {
                if (L.get(L.size() - 1) < num[i]) {
                    L.add(num[i]);
                    dp[i] = L.size();
                } else {
                    int index = Collections.binarySearch(L, num[i]);
                    if (index < 0) {
                        index = -index - 1;
                    }
                    L.set(index, num[i]);
                    dp[i] = index + 1;
                }
            }

            if (dp[i] > dptmp) {
                idx = i;
                dptmp = dp[i];
            }
        }

        System.out.println(L.size());
        s.push(num[idx]);

        for (int i = idx - 1; i >= 0; i--) {
            if (num[i] < num[idx] && dp[i] + 1 == dp[idx]) {
                idx = i;
                s.push(num[i]);
            }
        }

        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
