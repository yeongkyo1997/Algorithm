#include <iostream>
#include <vector>
#include <algorithm>

const int INF = 1501; // 최대 수색 범위(15) * 최대 지역 개수(100) 보다 큰 값으로 설정 가능

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n, m, r;
    std::cin >> n >> m >> r;

    std::vector<int> items(n + 1);
    for (int i = 1; i <= n; ++i) {
        std::cin >> items[i];
    }

    // 거리 정보 저장 배열 (dist[i][j] = i에서 j까지의 최단 거리)
    std::vector<std::vector<int>> dist(n + 1, std::vector<int>(n + 1, INF));

    // 자기 자신으로 가는 거리는 0
    for (int i = 1; i <= n; ++i) {
        dist[i][i] = 0;
    }

    // 도로 정보 입력 받아 초기 거리 설정 (양방향)
    for (int i = 0; i < r; ++i) {
        int u, v, l;
        std::cin >> u >> v >> l;
        // 이미 더 짧은 경로가 있을 수 있으므로 min 사용
        dist[u][v] = std::min(dist[u][v], l);
        dist[v][u] = std::min(dist[v][u], l);
    }

    // 플로이드-워셜 알고리즘으로 모든 지역 쌍 간의 최단 거리 계산
    for (int k = 1; k <= n; ++k) { // 경유지
        for (int i = 1; i <= n; ++i) { // 출발지
            for (int j = 1; j <= n; ++j) { // 도착지
                // i에서 k를 거쳐 j로 가는 거리가 기존 i에서 j로 가는 거리보다 짧으면 갱신
                 if (dist[i][k] != INF && dist[k][j] != INF) { // 경로가 존재할 때만 계산
                      dist[i][j] = std::min(dist[i][j], dist[i][k] + dist[k][j]);
                 }
            }
        }
    }

    int max_items = 0;
    // 각 지역에 낙하했을 경우 얻을 수 있는 아이템 계산
    for (int i = 1; i <= n; ++i) { // i 지역에 낙하
        int current_items = 0;
        for (int j = 1; j <= n; ++j) { // j 지역 탐색
            // i에서 j까지의 최단 거리가 수색 범위 m 이내이면
            if (dist[i][j] <= m) {
                current_items += items[j]; // j 지역의 아이템 획득
            }
        }
        // 최대 아이템 수 갱신
        max_items = std::max(max_items, current_items);
    }

    // 결과 출력
    std::cout << max_items << "\n";

    return 0;
}