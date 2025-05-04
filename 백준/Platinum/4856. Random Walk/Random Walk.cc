#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <iomanip>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    const double PI = acos(-1.0);

    while (true) {
        int n;
        cin >> n;
        if (n == 0) break;  // 입력 종료

        vector<pair<double, pair<int,int>>> events;
        events.reserve(2 * n);
        long long Tx = 0, Ty = 0;  // 전체 벡터 합

        // 벡터 입력 및 전체 합, 각도 계산
        for (int i = 0; i < n; i++) {
            int x, y;
            cin >> x >> y;
            Tx += x;
            Ty += y;
            double ang = atan2((double)y, (double)x);
            if (ang < 0) ang += 2 * PI;  // [0,2π) 범위
            events.push_back(make_pair(ang, make_pair(x, y)));
        }

        // 2π 더한 복사본 추가
        for (int i = 0; i < n; i++) {
            double ang = events[i].first + 2 * PI;
            events.push_back(make_pair(ang, events[i].second));
        }

        // 각도 순 정렬 (C++11 호환)
        sort(events.begin(), events.end(),
             [](const pair<double, pair<int,int>> &a,
                const pair<double, pair<int,int>> &b) {
                 return a.first < b.first;
             });

        // 투 포인터로 반원(π) 구간 최대 거리 계산
        long long Sx = 0, Sy = 0;
        int r = 0;
        long long best_sq = 0;

        for (int l = 0; l < n; l++) {
            double base_ang = events[l].first;
            // r 을 움직여 [base_ang, base_ang+π) 구간에 넣기
            while (r < l + n && events[r].first < base_ang + PI) {
                Sx += events[r].second.first;
                Sy += events[r].second.second;
                r++;
            }
            // 결과 벡터 R = 2*S - T
            long long Rx = 2 * Sx - Tx;
            long long Ry = 2 * Sy - Ty;
            long long dist_sq = Rx * Rx + Ry * Ry;
            if (dist_sq > best_sq) best_sq = dist_sq;

            // l 증가 시 S에서 제거
            Sx -= events[l].second.first;
            Sy -= events[l].second.second;
        }

        // 최종 거리 출력
        double best = sqrt((double)best_sq);
        cout << "Maximum distance = "
             << fixed << setprecision(3) << best
             << " meters.\n";
    }

    return 0;
}
