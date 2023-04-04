////
////#include <bits/stdc++.h>
////        using namespace std;
////        const int MAX = 50000;
////// 2^16 > 50000
////        const int DMAX = 16;
////        const int INF = INT_MAX;
////        typedef pair<int, int> pii;
////
////        int V, E;
////// 점 A, 점 B 연결하는 Edge , 가중치는 W
////        struct Edge{
////        int A;
////        int B;
////        int W;
////        bool Used = false;
////        Edge():Edge(0,0,0){}
////        Edge(int a1, int b1, int w1): A(a1), B(b1), W(w1){}
////        };
////// Edge 들 저장
////        vector<Edge> Vec;
////// 가중치 W 작은거부터
////        bool cmp(const Edge &E1, const Edge &E2){
////        return E1.W < E2.W;
////        }
////// Union Find
////// R[i] : i의 root
////        int R[MAX+1];
////        int Find(int x){
////        if(R[x]==0) return x;
////        return R[x] = Find(R[x]);
////        }
////        void Union(int x, int y){
////        int xRoot = Find(x);
////        int yRoot = Find(y);
////        if(xRoot == yRoot) return;
////        R[yRoot] = xRoot;
////        }
//////LCA 를 위한 재료
////// adj[i] : < i 의 자식노드 , 해당 가중치 >
////        vector<pii> adj[MAX+1];
////        int Depth[MAX+1];
////// parent[i][k] = i의 2^k 조상
////        int parent[MAX+1][DMAX+1];
////// Biggest[i][k] : i의 2^k 조상으로 가는 길에 있는 <가장 큰 간선 , 2번째로 큰 간선>
////// 가장큰간선 != 2번째로큰간선 으로 만들어준다.
////// -> 모든 edge 의 가중치가 1 인 경우 등의 예외 방지
////// 쓰이지 않은 간선 추가시 가장 큰 간선으로 대체 했을 경우
////        pii Biggest[MAX+1][DMAX+1];
////// i 들의 depth 구성
////        void MakeDepth(int curr){
////        for(auto child: adj[curr]){
////        if(Depth[child.first]!=0) continue;
////        Depth[child.first] = Depth[curr]+1;
////
////        parent[child.first][0] = curr;
////        // MST 를 구성하는 edge 들의 최소값을 계산하면서 갈꺼다. (코드 52~54)
////        Biggest[child.first][0] = pii(child.second,-1);
////        MakeDepth(child.first);
////        }
////        }
////// 추가할 Edge(a~b) 가 만드는 cycle 을 LCA 를 이용해 찾고, cycle 안에 대체 가능한 가장 큰 수 찾기
////        int HowAboutThis(Edge EE){
////        int x = EE.A;
////        int y = EE.B;
////        int w = EE.W;
////        // 대체가능한 간선의 가장 큰 가중치. w 와 달라야한다.
////        int ret = -1;
////        if(Depth[x]<Depth[y]) swap(x,y);
////        int diff = Depth[x] - Depth[y];
////        int cnt = 0;
////        while(diff){
////        if(diff%2==1){
////        //경로중 가장 큰 가중치
////        if(Biggest[x][cnt].first!=w)
////        ret = max(ret, Biggest[x][cnt].first);
////        //경로중 두번째 큰 가중치
////        else if(Biggest[x][cnt].second!=-1)
////        ret = max(ret, Biggest[x][cnt].second);
////
////        x = parent[x][cnt];
////        }
////        diff/=2;
////        cnt++;
////        }
////        if(x!=y){
////        for (int i = DMAX; i >= 0; i--){
////        if(parent[x][i]!=parent[y][i]){
////        if(Biggest[x][i].first!=w)
////        ret = max(ret, Biggest[x][i].first);
////        else if(Biggest[x][i].second!=-1)
////        ret = max(ret, Biggest[x][i].second);
////        if(Biggest[y][i].first!=w)
////        ret = max(ret, Biggest[y][i].first);
////        else if(Biggest[y][i].second!=-1)
////        ret = max(ret, Biggest[y][i].second);
////
////        x = parent[x][i];
////        y = parent[y][i];
////        }
////        }
////        if(Biggest[x][0].first!=w)
////        ret = max(ret, Biggest[x][0].first);
////        else if(Biggest[x][0].second!=-1)
////        ret = max(ret, Biggest[x][0].second);
////        if(Biggest[y][0].first!=w)
////        ret = max(ret, Biggest[y][0].first);
////        else if(Biggest[y][0].second!=-1)
////        ret = max(ret, Biggest[y][0].second);
////
////        x = parent[x][0];
////        }
////        return ret;
////        }
////        int main(){ios::sync_with_stdio(false);cout.tie(NULL);cin.tie(NULL);
////
////        cin >> V >> E;
////        for(int i=0; i<E; ++i){
////        int a, b, w;
////        cin >> a >> b >> w;
////        Vec.push_back(Edge(a,b,w));
////        }
////// 최소 스패닝 트리 만드는 간선비용
////        int MST = 0;
////// V-1 개의 Edge 나오면 MST 완성!
////        int cnt = 0;
////// 가중치 작은순
////        sort(Vec.begin(), Vec.end(), cmp);
////// MST
////        for(int i=0; i<E; ++i){
////        int a = Vec[i].A;
////        int b = Vec[i].B;
////        int aRoot = Find(a);
////        int bRoot = Find(b);
////        if(aRoot == bRoot) continue;
////        Union(a,b);
////        MST += Vec[i].W;
////        Vec[i].Used = true;
////        // LCA 돌리기 위해 자식 저장
////        adj[a].push_back(pii(b,Vec[i].W));
////        adj[b].push_back(pii(a,Vec[i].W));
////        cnt++;
////        if(cnt==V-1) break;
////        }
////// MST 가 애초에 없는 경우
////        if(cnt!=V-1 || E<=V-1){
////        cout << -1 << '\n';
////        return 0;
////        }
////// LCA 구현, 1번 노드를 Root로 생각
////        Depth[1] = 1;
////// tree Depth 만들기
////        MakeDepth(1);
////        for (int k = 0; k <= DMAX; ++k){
////        for (int i = 1; i <= V; ++i){
////        int Father = parent[i][k];
////        if(Father && parent[Father][k]!=0){
////        // i가 2^k 조상 갈때 큰 가중치 2개 , < w1, w2 > (w1>w2)
////        int w1 = Biggest[i][k].first;
////        int w2 = Biggest[i][k].second;
////        // father이 2^k 조상 갈때 큰 가중치 2개 , < f1, f2 > (f1>f2)
////        int f1 = Biggest[Father][k].first;
////        int f2 = Biggest[Father][k].second;
////        // 큰 가중치 정하기
////        if(w1>f1){
////        Biggest[i][k+1].first = w1;
////        Biggest[i][k+1].second = max(f1,w2);
////        }
////        else if(w1<f1){
////        Biggest[i][k+1].first = f1;
////        Biggest[i][k+1].second = max(w1,f2);
////        }
////        // w1==f1이면
////        else
////        Biggest[i][k+1] = pii(w1,max(w2,f2));
////
////        parent[i][k+1] = parent[Father][k];
////        }
////        }
////        }
////// 안써본 Edge 써서 MST 바로 밑 값 구해보기! (2번째 MST)
////        int Plus = INF;
////        for(int i=0; i<E; ++i){
////        // MST 만들 때 사용한 간선이면 패스
////        if(Vec[i].Used) continue;
////        int t = HowAboutThis(Vec[i]);
////        if(t==-1 || t==Vec[i].W) continue;
////        Plus = min(Plus, Vec[i].W-t);
////        }
////        if(Plus==INF) cout << -1 << '\n';
////        else cout << MST+Plus << '\n';
////        return 0;
////        }
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
////cpp to java
//public class Main_1626_두_번째로_작은_스패닝_트리 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer st;
//
//    static int N, M;
//    static int[] rank;
//    static int[] size;
//    static int MAX = 50000;
//    static int DMAX = 16;
//    static int INF = Integer.MAX_VALUE;
//    static int V, E;
//
//    static class Edge implements Comparable<Edge> {
//        int A, B, W;
//        boolean Used;
//
//        public Edge(int A, int B, int W) {
//            this.A = A;
//            this.B = B;
//            this.W = W;
//            this.Used = false;
//        }
//
//        @Override
//        public int compareTo(Edge o) {
//            return this.W - o.W;
//        }
//    }
//
//    static class Pair {
//        int first, second;
//
//        public Pair(int first, int second) {
//            this.first = first;
//            this.second = second;
//        }
//    }
//
//    static Edge[] Vec;
//    static int[] Depth;
//    static int[][] parent;
//    static Pair[][] Biggest;
//    static List<List<Integer>> adj = new ArrayList<>();
//
//    static int Find(int x) {
//        if (x == rank[x])
//            return x;
//        return rank[x] = Find(rank[x]);
//    }
//
//    static void Union(int x, int y) {
//        x = Find(x);
//        y = Find(y);
//        if (x == y)
//            return;
//        if (size[x] < size[y]) {
//            int temp = x;
//            x = y;
//            y = temp;
//        }
//        rank[y] = x;
//        size[x] += size[y];
//    }
//
//    static void MakeDepth(int x) {
//        for (int i = 0; i < adj.get(x).size(); i++) {
//            int next = adj.get(x).get(i);
//            if (Depth[next] == 0) {
//                Depth[next] = Depth[x] + 1;
//                parent[next][0] = x;
//                MakeDepth(next);
//            }
//        }
//    }
//
