//#include <iostream>
//#include <vector>
//#include <queue>
//#include <algorithm>
//#include <string>
//#include <deque>
//#include <math.h>
//        #include <memory.h>
//        #include <stack>
//#include <map>
//#include <set>
//#define X first
//        #define Y second
//        #define INF 0x3f3f3f3f
//        #define MOD 1000000007
//        #define ll long long
//        using namespace std;
//        int arr[1001] = { 0 }, n;
//        pair<int, int> check(int tmp[])
//        {
//        int x = 0, flag = 0;
//        for (int i = 1; i <= n; i++)
//        {
//        if (tmp[i] != i)
//        flag = 1;
//        if ((tmp[i] + 1 == tmp[i - 1]) || (tmp[i] - 1 == tmp[i - 1]))
//        continue;
//        x++;
//        }
//        return { x,flag };
//        }
//        vector<pair<int, int>> check_t(int tmp[])
//        {
//        vector<pair<int, int>> v;
//        int x = 0, y = 0;
//        for (int i = 1; i <= n; i++)
//        {
//        x = i;
//        int j = i;
//        while (j < n && (tmp[j] + 1 == tmp[j + 1] || tmp[j] - 1 == tmp[j + 1]))
//        j++;
//        y = j;
//        v.push_back({ x,y });
//        i = j;
//        }
//        return v;
//        }
//        void solve(int cnt, int ans[3][2], int tmp[1001], int size)
//        {
//        int group[101][2] = { 0 }, num = 1, g_num = 0, flag = 0;
//        for (int i = 1; i < n; i++)
//        {
//        if (tmp[i] != i)
//        flag = 1;
//        if (abs(tmp[i]-tmp[i+1])!=1)
//        {
//        group[g_num][0] = num;
//        group[g_num++][1] = i;
//        num = i + 1;
//        }
//        }
//        group[g_num][0] = num;
//        group[g_num++][1] = n;
//        if (!flag)
//        {
//        for (int i = 0; i < cnt; i++)
//        cout << ans[i][0] << " " << ans[i][1] << '\n';
//        for (; cnt < 3; cnt++)
//        cout << 1 << " " << 1 << '\n';
//        exit(0);
//        }
//        if (cnt == 3)
//        return;
//        if (g_num - 1 >= size && cnt > 1)
//        return;
//	/*for (int i = 1; i <= n; i++)
//		cout << tmp[i] << " ";
//	cout << '\n';
//	for (int i = 0; i < g_num; i++)
//		cout << group[i][0] << " " << group[i][1] << '\n';
//	cout << '\n';*/
//        for (int i = 0; i < g_num; i++)
//        {
//        for (int j = i; j < g_num; j++)
//        {
//        int l = group[i][0], r = group[j][1];
//        for (; l <= r; l++)
//        {
//        int t_num = tmp[l];
//        tmp[l] = tmp[r];
//        tmp[r] = t_num;
//        r--;
//        }
//        ans[cnt][0] = group[i][0];
//        ans[cnt][1] = group[j][1];
//        solve(cnt + 1, ans, tmp, g_num - 1);
//        l = group[i][0], r = group[j][1];
//        for (; l <= r; l++)
//        {
//        int t_num = tmp[l];
//        tmp[l] = tmp[r];
//        tmp[r] = t_num;
//        r--;
//        }
//        }
//        }
//        }
//        int main()
//        {
//        ios::sync_with_stdio(false);
//        cin.tie(NULL), cout.tie(NULL);
//        cin >> n;
//        for (int i = 1; i <= n; i++)
//        cin >> arr[i];
//        int tmp[3][2] = { 0 };
//        vector<pair<int, int>> v = check_t(arr);
//        for (int i = 0; i < v.size(); i++)
//        {
//        for (int j = i; j < v.size(); j++)
//        {
//        int l = v[i].X, r = v[j].Y;
//        for (; l <= r; l++)
//        {
//        int temp = arr[l];
//        arr[l] = arr[r];
//        arr[r] = temp;
//        r--;
//        }
//        pair<int, int> v2 = check(arr);
//        if (v2.X <= v.size())
//        {
//        tmp[0][0] = v[i].X;
//        tmp[0][1] = v[j].Y;
//        solve(1, tmp, arr, v.size());
//        }
//        l = v[i].X, r = v[j].Y;
//        for (; l <= r; l++)
//        {
//        int temp = arr[l];
//        arr[l] = arr[r];
//        arr[r] = temp;
//        r--;
//        }
//        if (i != j)
//        {
//        l = v[i].X, r = v[j].X;
//        for (; l <= r; l++)
//        {
//        int temp = arr[l];
//        arr[l] = arr[r];
//        arr[r] = temp;
//        r--;
//        }
//        pair<int, int> v2 = check(arr);
//        if (v2.X <= v.size())
//        {
//        tmp[0][0] = v[i].X;
//        tmp[0][1] = v[j].X;
//        solve(1, tmp, arr, v.size());
//        }
//        l = v[i].X, r = v[j].X;
//        for (; l <= r; l++)
//        {
//        int temp = arr[l];
//        arr[l] = arr[r];
//        arr[r] = temp;
//        r--;
//        }
//        }
//        }
//        }
//        }

//cpp to java

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_2561_세_번_뒤집기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[] arr = new int[1001];
    static int[] tmp = new int[1001];
    static int[][] ans = new int[3][2];
    static int[][] group = new int[101][2];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmp[i] = arr[i];
        }
        solve(0, ans, tmp, 0);
        bw.write("-1");
        bw.flush();
        bw.close();
    }

    static void solve(int cnt, int[][] result, int[] tmp, int size) throws IOException {
        int num = 1, gNum = 0, flag = 0;

        for (int i = 1; i < n; i++) {
            if (tmp[i] != i) flag = 1;
            if (Math.abs(tmp[i] - tmp[i + 1]) != 1) {
                group[gNum][0] = num;
                group[gNum++][1] = i;
                num = i + 1;
            }
        }

        group[gNum][0] = num;
        group[gNum++][1] = n;

        if (flag == 0) {
            IntStream.range(0, cnt).mapToObj(i -> result[i][0] + " " + result[i][1]).forEach(System.out::println);

            while (cnt < 3) {
                bw.write("1 1\n");
                cnt++;
            }

            bw.close();
            System.exit(0);
        }

        if (cnt == 3) return;
        if (gNum - 1 >= size && cnt > 1) return;

        for (int i = 0; i < gNum; i++) {
            for (int j = i; j < gNum; j++) {

                int l = group[i][0], r = group[j][1];

                while (l <= r) {
                    int tNum = tmp[l];
                    tmp[l] = tmp[r];
                    tmp[r] = tNum;
                    r--;
                    l++;
                }
                result[cnt][0] = group[i][0];
                result[cnt][1] = group[j][1];
                solve(cnt + 1, result, tmp, gNum - 1);

                l = group[i][0];
                r = group[j][1];

                while (l <= r) {
                    int t_num = tmp[l];
                    tmp[l] = tmp[r];
                    tmp[r] = t_num;
                    r--;
                    l++;
                }
            }
        }
    }
}