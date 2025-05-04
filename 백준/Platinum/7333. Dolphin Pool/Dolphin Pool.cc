#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

// 허용 오차
const double EPS = 1e-8;
const double PI = acos(-1.0);

// 점 구조체
struct Point {
    double x, y;
};

// DSU (Union-Find)
struct DSU {
    vector<int> p, r;
    DSU(int n): p(n), r(n,0) {
        for (int i = 0; i < n; i++) p[i] = i;
    }
    int find(int x) {
        return p[x] == x ? x : p[x] = find(p[x]);
    }
    void unite(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return;
        if (r[a] < r[b]) p[a] = b;
        else if (r[a] > r[b]) p[b] = a;
        else { p[b] = a; r[a]++; }
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    while (T--) {
        int N;
        cin >> N;
        vector<Point> center(N);
        vector<double> R(N);
        for(int i = 0; i < N; i++){
            cin >> center[i].x >> center[i].y >> R[i];
        }

        // DSU 초기화
        DSU dsu(N);

        // 교차점 저장
        vector<Point> nodes;
        // 원마다 (node id, angle) 쌍
        vector<vector<pair<int,double>>> circleNodes(N);

        // 모든 원쌍 검사
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                // 중심 거리
                double dx = center[j].x - center[i].x;
                double dy = center[j].y - center[i].y;
                double d = sqrt(dx*dx + dy*dy);
                // 겹치는지 판정: |Ri - Rj| < d < Ri + Rj
                if (d < R[i] + R[j] - EPS && d > fabs(R[i] - R[j]) + EPS) {
                    // DSU 합치기
                    dsu.unite(i,j);
                    // 교차점 계산
                    double a = (R[i]*R[i] - R[j]*R[j] + d*d) / (2.0 * d);
                    double h = sqrt(max(0.0, R[i]*R[i] - a*a));
                    // 중간 점
                    double mx = center[i].x + a * dx / d;
                    double my = center[i].y + a * dy / d;
                    // 교차점 편차
                    double rx = -dy * (h / d);
                    double ry = dx * (h / d);
                    // 두 교차점
                    Point P1{ mx + rx, my + ry };
                    Point P2{ mx - rx, my - ry };
                    // 벡터에 추가하고 circleNodes에도 추가
                    int id1 = nodes.size();
                    nodes.push_back(P1);
                    int id2 = nodes.size();
                    nodes.push_back(P2);
                    // 각 원 위의 각도 계산 (0~2π)
                    double ang1_i = atan2(P1.y - center[i].y, P1.x - center[i].x);
                    if (ang1_i < 0) ang1_i += 2*PI;
                    double ang1_j = atan2(P1.y - center[j].y, P1.x - center[j].x);
                    if (ang1_j < 0) ang1_j += 2*PI;
                    double ang2_i = atan2(P2.y - center[i].y, P2.x - center[i].x);
                    if (ang2_i < 0) ang2_i += 2*PI;
                    double ang2_j = atan2(P2.y - center[j].y, P2.x - center[j].x);
                    if (ang2_j < 0) ang2_j += 2*PI;
                    circleNodes[i].push_back({id1, ang1_i});
                    circleNodes[j].push_back({id1, ang1_j});
                    circleNodes[i].push_back({id2, ang2_i});
                    circleNodes[j].push_back({id2, ang2_j});
                }
            }
        }

        int M = nodes.size();
        // 경계 그래프 인접리스트
        vector<vector<int>> adj(M);

        // 분리된(고립된) 원 개수
        int isolatedCycles = 0;

        // 각 원마다 경계 호(arc) 판정
        for (int i = 0; i < N; i++) {
            auto &lst = circleNodes[i];
            if (lst.empty()) {
                // 교차점 없으면 전체 원이 고립된 경계 사이클이 될 수 있는지 확인
                // angle=0 지점 샘플
                Point sample{ center[i].x + R[i], center[i].y };
                bool ok = true;
                for (int k = 0; k < N; k++) {
                    if (k == i) continue;
                    double dx = sample.x - center[k].x;
                    double dy = sample.y - center[k].y;
                    if (sqrt(dx*dx + dy*dy) < R[k] - EPS) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    isolatedCycles++;
                }
            } else {
                // 교차점이 있으면 호 단위로 판정
                // 각도 순 정렬
                sort(lst.begin(), lst.end(),
                     [](const pair<int,double> &a,
                        const pair<int,double> &b){
                         return a.second < b.second;
                     });
                int m = lst.size();
                for (int k = 0; k < m; k++) {
                    int idA = lst[k].first;
                    double angA = lst[k].second;
                    int nxt = (k+1 == m ? 0 : k+1);
                    int idB = lst[nxt].first;
                    double angB = lst[nxt].second + (nxt==0 ? 2*PI : 0);
                    // 중간 각도
                    double midAng = 0.5 * (angA + angB);
                    // 호의 중간 점
                    Point midP{
                        center[i].x + R[i] * cos(midAng),
                        center[i].y + R[i] * sin(midAng)
                    };
                    // midP가 다른 모든 원 내부에 들어가지 않으면 경계 호
                    bool isBoundary = true;
                    for (int k2 = 0; k2 < N; k2++) {
                        if (k2 == i) continue;
                        double dx = midP.x - center[k2].x;
                        double dy = midP.y - center[k2].y;
                        if (sqrt(dx*dx + dy*dy) < R[k2] - EPS) {
                            isBoundary = false;
                            break;
                        }
                    }
                    if (isBoundary) {
                        // 경계 호 => 그래프 간선 추가
                        adj[idA].push_back(idB);
                        adj[idB].push_back(idA);
                    }
                }
            }
        }

        // 그래프에서 사이클(경계 루프) 개수 세기
        vector<bool> vis(M, false);
        int boundaryCycles = 0;
        for (int u = 0; u < M; u++) {
            if (!vis[u] && !adj[u].empty()) {
                // BFS/DFS로 하나의 루프(연결 성분) 탐색
                vector<int> stk;
                stk.push_back(u);
                vis[u] = true;
                while (!stk.empty()) {
                    int v = stk.back();
                    stk.pop_back();
                    for (int w: adj[v]) {
                        if (!vis[w]) {
                            vis[w] = true;
                            stk.push_back(w);
                        }
                    }
                }
                boundaryCycles++;
            }
        }

        int cycles = boundaryCycles + isolatedCycles;

        // DSU로 원들의 연결 요소(합집합 컴포넌트) 개수
        vector<bool> seen(N, false);
        int components = 0;
        for (int i = 0; i < N; i++) {
            int fi = dsu.find(i);
            if (!seen[fi]) {
                seen[fi] = true;
                components++;
            }
        }

        // 구멍(닫힌 영역) 수 = 경계 사이클 수 - 컴포넌트 수
        int holes = cycles - components;
        cout << holes << "\n";
    }

    return 0;
}
