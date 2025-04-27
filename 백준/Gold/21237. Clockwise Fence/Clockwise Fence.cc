#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    while (N--) {
        string s;
        cin >> s;
        // (x,y) 좌표를 따라가면서 정점 리스트 생성
        vector<pair<long long, long long>> pts;
        long long x = 0, y = 0;
        pts.emplace_back(x, y);
        for (char c : s) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;
            pts.emplace_back(x, y);
        }
        // 마무리: 시작점으로 돌아오므로 pts.front() == pts.back()

        // 슈얼레이스 공식으로 signed area 계산
        // area2 = sum_{i=0..m-1}( x_i*y_{i+1} - x_{i+1}*y_i )
        long long area2 = 0;
        int m = pts.size();
        for (int i = 0; i < m-1; i++) {
            long long x1 = pts[i].first;
            long long y1 = pts[i].second;
            long long x2 = pts[i+1].first;
            long long y2 = pts[i+1].second;
            area2 += x1 * y2 - x2 * y1;
        }
        // area2 > 0 이면 path가 CCW, area2 < 0 이면 CW
        if (area2 > 0) {
            cout << "CCW\n";
        } else {
            cout << "CW\n";
        }
    }
    return 0;
}
