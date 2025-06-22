#include <iostream>
#include <vector>

std::vector<int> fish[5][5];
int smell[5][5];
int sx, sy;
int M, S;

const int f_dr[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
const int f_dc[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};

const int s_dr[] = {0, -1, 0, 1, 0};
const int s_dc[] = {0, 0, -1, 0, 1};

void solve() {
    for (int t = 1; t <= S; ++t) {
        std::vector<int> copied_fish[5][5];
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= 4; ++j) {
                copied_fish[i][j] = fish[i][j];
            }
        }

        std::vector<int> next_fish[5][5];
        for (int r = 1; r <= 4; ++r) {
            for (int c = 1; c <= 4; ++c) {
                for (int dir : fish[r][c]) {
                    bool moved = false;
                    for (int i = 0; i < 8; ++i) {
                        int nd = (dir - 1 - i + 8) % 8 + 1;
                        int nr = r + f_dr[nd];
                        int nc = c + f_dc[nd];

                        if (nr >= 1 && nr <= 4 && nc >= 1 && nc <= 4) {
                            if (smell[nr][nc] == 0 && (nr != sx || nc != sy)) {
                                next_fish[nr][nc].push_back(nd);
                                moved = true;
                                break;
                            }
                        }
                    }
                    if (!moved) {
                        next_fish[r][c].push_back(dir);
                    }
                }
            }
        }
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= 4; ++j) {
                fish[i][j] = next_fish[i][j];
            }
        }

        int max_eaten = -1;
        int best_path[3];
        int p[3];

        for (p[0] = 1; p[0] <= 4; ++p[0]) {
            for (p[1] = 1; p[1] <= 4; ++p[1]) {
                for (p[2] = 1; p[2] <= 4; ++p[2]) {
                    int cur_r = sx;
                    int cur_c = sy;
                    int path_r[3], path_c[3];
                    bool possible = true;

                    for (int k = 0; k < 3; ++k) {
                        int nr = cur_r + s_dr[p[k]];
                        int nc = cur_c + s_dc[p[k]];
                        if (nr < 1 || nr > 4 || nc < 1 || nc > 4) {
                            possible = false;
                            break;
                        }
                        cur_r = nr;
                        cur_c = nc;
                        path_r[k] = cur_r;
                        path_c[k] = cur_c;
                    }

                    if (!possible) continue;

                    int eaten_count = 0;
                    bool visited[5][5] = {};
                    for (int k = 0; k < 3; ++k) {
                        int nr = path_r[k];
                        int nc = path_c[k];
                        if (!visited[nr][nc]) {
                            eaten_count += fish[nr][nc].size();
                            visited[nr][nc] = true;
                        }
                    }

                    if (eaten_count > max_eaten) {
                        max_eaten = eaten_count;
                        for (int k = 0; k < 3; ++k) best_path[k] = p[k];
                    }
                }
            }
        }

        for (int k = 0; k < 3; ++k) {
            sx += s_dr[best_path[k]];
            sy += s_dc[best_path[k]];
            if (!fish[sx][sy].empty()) {
                fish[sx][sy].clear();
                smell[sx][sy] = t;
            }
        }

        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= 4; ++j) {
                if (smell[i][j] > 0 && t - smell[i][j] >= 2) {
                    smell[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= 4; ++j) {
                if(!copied_fish[i][j].empty()) {
                    fish[i][j].insert(fish[i][j].end(), copied_fish[i][j].begin(), copied_fish[i][j].end());
                }
            }
        }
    }

    int total_fish = 0;
    for (int i = 1; i <= 4; ++i) {
        for (int j = 1; j <= 4; ++j) {
            total_fish += fish[i][j].size();
        }
    }
    std::cout << total_fish << "\n";
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    std::cin >> M >> S;
    for (int i = 0; i < M; ++i) {
        int r, c, d;
        std::cin >> r >> c >> d;
        fish[r][c].push_back(d);
    }
    std::cin >> sx >> sy;

    solve();

    return 0;
}