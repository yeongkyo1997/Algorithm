#include <bits/stdc++.h>
using namespace std;

struct Pos { int r, c; };

bool seesStudent(const vector<vector<char>>& g, int r, int c) {
    static int dr[4] = {-1, 1, 0, 0};
    static int dc[4] = {0, 0, -1, 1};
    int n = (int)g.size();

    for (int d = 0; d < 4; ++d) {
        int nr = r + dr[d], nc = c + dc[d];
        while (0 <= nr && nr < n && 0 <= nc && nc < n) {
            if (g[nr][nc] == 'O') break;      // 장애물이면 시야가 막힘
            if (g[nr][nc] == 'S') return true; // 학생을 보면 실패
            nr += dr[d]; nc += dc[d];
        }
    }
    return false; // 이 선생은 아무 학생도 못 봄
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    if(!(cin >> N)) return 0;
    vector<vector<char>> g(N, vector<char>(N));
    vector<Pos> empties, teachers;

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            string s; cin >> s;
            g[i][j] = s[0];
            if (g[i][j] == 'X') empties.push_back({i, j});
            else if (g[i][j] == 'T') teachers.push_back({i, j});
        }
    }

    int E = (int)empties.size();
    // 빈 칸 3개 조합 모두 시도
    for (int a = 0; a < E; ++a) {
        for (int b = a + 1; b < E; ++b) {
            for (int c = b + 1; c < E; ++c) {
                // 장애물 설치
                auto [r1, c1] = empties[a];
                auto [r2, c2] = empties[b];
                auto [r3, c3] = empties[c];
                g[r1][c1] = g[r2][c2] = g[r3][c3] = 'O';

                bool ok = true;
                for (const auto& t : teachers) {
                    if (seesStudent(g, t.r, t.c)) { ok = false; break; }
                }

                if (ok) {
                    cout << "YES\n";
                    return 0;
                }

                // 원상복구
                g[r1][c1] = g[r2][c2] = g[r3][c3] = 'X';
            }
        }
    }

    cout << "NO\n";
    return 0;
}