//#include <stdio.h>
//        #include <vector>
//using namespace std;
//
//        vector<int> v[100005];
//        int ans[100005]={1};
//
//        void dfs(int x){
//
//        for(int i=0;i<v[x].size();i++){
//        int k = v[x][i];
//
//        if(ans[k]==0){
//        ans[k] = x;
//        dfs(k);
//        }
//        }
//
//        return;
//        }
//
//        int main(){
//        int n;
//        int x,y;
//
//        scanf("%d",&n);
//
//        for(int i=0;i<n-1;i++){
//        scanf("%d %d",&x,&y);
//        v[x].push_back(y);
//        v[y].push_back(x);
//        }
//
//        dfs(1);
//
//        for(int i=2;i<=n;i++)
//        printf("%d\n",ans[i]);
//
//        return 0;
//        }

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//cpp to java
public class Main_11725_트리의_부모_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] ans;
    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        ans = new int[N + 1];
        visited = new boolean[N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.close();
    }

    public static void dfs(int x) {
        visited[x] = true;

        for (int i = 1; i <= N; i++) {
            if (arr[x][i] == 1 && !visited[i]) {
                ans[i] = x;
                dfs(i);
            }
        }
    }
}