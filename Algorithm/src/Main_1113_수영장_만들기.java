//#include<bits/stdc++.h>
//        #define X first
//        #define Y second
//        using namespace std;
//
//        int dx[]={0,1,0,-1};
//        int dy[]={1,0,-1,0};
//        int main() {
//        int mp[100][100]={};
//        int Max=0;
//        int sum=0;
//        int n,m; cin >> n >> m;
//        queue<pair<int,int>> q;
//        for(int i=1;i<=n;i++){
//        string s; cin >> s;
//        for(int j=1;j<=m;j++){
//        mp[i][j]=s[j-1]-'0';
//        Max=max(mp[i][j],Max);
//        }
//        }
//        for(int h=1;h<=Max;h++){
//        mp[0][0]=h;
//        q.push({0,0});
//        while(!q.empty()){
//        auto cur = q.front(); q.pop();
//        for(int dir=0;dir<4;dir++){
//        int nx = cur.X+dx[dir];
//        int ny = cur.Y+dy[dir];
//        if(nx<0||ny<0||nx>n+1||ny>m+1) continue;
//        if(mp[nx][ny]>=h) continue;
//        mp[nx][ny]=h;
//        q.push({nx,ny});
//        }
//        }
//        /*
//        for(int i=0;i<=n+1;i++){
//            for(int j=0;j<=m+1;j++){
//                cout << mp[i][j];
//            }
//            cout << '\n';
//        }
//         */
//        for(int i=1;i<=n;i++){
//        for(int j=1;j<=m;j++){
//        if(mp[i][j]<h){
//        sum++;
//        mp[i][j]+=1;
//        }
//        }
//        }
//        //cout << sum << '\n';
//        }
//        cout << sum;
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1113_수영장_만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static int max = 0;
    static int sum = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();

            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
                max = Math.max(map[i][j], max);
            }
        }
        for (int h = 1; h <= max; h++) {
            map[0][0] = h;

            Queue<Pair> q = new ArrayDeque<>();
            q.add(new Pair(0, 0));

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx > N + 1 || ny > M + 1) continue;
                    if (map[nx][ny] >= h) continue;
                    map[nx][ny] = h;
                    q.add(new Pair(nx, ny));
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] < h) {
                        sum++;
                        map[i][j] += 1;
                    }
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}