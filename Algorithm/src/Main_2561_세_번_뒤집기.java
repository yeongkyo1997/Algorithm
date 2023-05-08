import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2561_세_번_뒤집기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[] arr = new int[1001];

    static int[] check(int[] arr) {
        int[] ans = new int[2];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                cnt++;
                ans[0] = i;
            }
        }
        ans[1] = cnt;
        return ans;
    }

    static int[] check_t(int[] arr) {
        int[] ans = new int[2];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - 1 != arr[i + 1]) {
                cnt++;
                ans[0] = i;
            }
        }
        ans[1] = cnt;
        return ans;
    }

    static void solve(int cnt, int[][] ans, int[] tmp, int size) {
        int[][] group = new int[1001][2];
        int g_num = 0;
        int num = 0;
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (tmp[i] != i) {
                flag = true;
                num = i + 1;
            }
        }
        group[g_num][0] = num;
        group[g_num++][1] = n;
        if (!flag) {
            for (int i = 0; i < cnt; i++)
                System.out.println(ans[i][0] + " " + ans[i][1]);
            while (cnt < 3) {
                System.out.println(1 + " " + 1);
                cnt++;
            }
            System.exit(0);
        }
        if (cnt == 3) return;
        if (0 >= size && cnt > 1) return;
        for (int i = 0; i < g_num; i++) {
            for (int j = i; j < g_num; j++) {
                int l = group[i][0], r = group[j][1];
                for (; l <= r; l++) {
                    int t_num = tmp[l];
                    tmp[l] = tmp[r];
                    tmp[r] = t_num;
                    r--;
                }
                ans[cnt][0] = group[i][0];
                ans[cnt][1] = group[j][1];
                solve(cnt + 1, ans, tmp, g_num - 1);
                l = group[i][0];
                r = group[j][1];
                for (; l <= r; l++) {
                    int t_num = tmp[l];
                    tmp[l] = tmp[r];
                    tmp[r] = t_num;
                    r--;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int[][] tmp = new int[3][2];
        int[] v = check_t(arr);
        for (int i = 0; i < v.length; i++) {
            for (int j = i; j < v.length; j++) {
                int l = v[i], r = v[j];
                for (; l <= r; l++) {
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    r--;
                }
                int[] v2 = check(arr);
                if (v2[0] <= v.length) {
                    tmp[0][0] = v[i];
                    tmp[0][1] = v[j];
                    solve(1, tmp, arr, v.length);
                }
                l = v[i];
                r = v[j];
                for (; l <= r; l++) {
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    r--;
                }
                if (i != j) {
                    l = v[i];
                    r = v[j];
                    for (; l <= r; l++) {
                        int temp = arr[l];
                        arr[l] = arr[r];
                        arr[r] = temp;
                        r--;
                    }
                    int[] v3 = check(arr);
                    if (v3[0] <= v.length) {
                        tmp[0][0] = v[i];
                        tmp[0][1] = v[j];
                        solve(1, tmp, arr, v.length);
                    }
                    l = v[i];
                    r = v[j];
                    for (; l <= r; l++) {
                        int temp = arr[l];
                        arr[l] = arr[r];
                        arr[r] = temp;
                        r--;
                    }
                }
            }
        }
    }
}
