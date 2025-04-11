#include <iostream>
#include <vector>
#include <cmath>
#include <numeric>

using namespace std;

struct Fireball {
    int r, c, m, s, d;
};

int N;
int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};

vector<Fireball> fireballs;
vector<vector<vector<int>>> grid;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int M, K;
    cin >> N >> M >> K;

    fireballs.resize(M);
    for (int i = 0; i < M; ++i) {
        cin >> fireballs[i].r >> fireballs[i].c >> fireballs[i].m >> fireballs[i].s >> fireballs[i].d;
        fireballs[i].r--;
        fireballs[i].c--;
    }

    for (int k = 0; k < K; ++k) {
        grid.assign(N, vector<vector<int>>(N, vector<int>()));

        for (int i = 0; i < fireballs.size(); ++i) {
            Fireball& fb = fireballs[i];

            long long move_r = (long long)dr[fb.d] * fb.s;
            long long move_c = (long long)dc[fb.d] * fb.s;

            int nr = (fb.r + move_r % N + N) % N;
            int nc = (fb.c + move_c % N + N) % N;

            fb.r = nr;
            fb.c = nc;
            grid[nr][nc].push_back(i); 
        }

        vector<Fireball> next_fireballs;

        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c].size() == 0) {
                    continue;
                }

                if (grid[r][c].size() == 1) {
                    next_fireballs.push_back(fireballs[grid[r][c][0]]);
                } else {
                    int total_m = 0;
                    int total_s = 0;
                    int count = grid[r][c].size();
                    bool all_even = true;
                    bool all_odd = true;

                    for (int index : grid[r][c]) {
                        total_m += fireballs[index].m;
                        total_s += fireballs[index].s;
                        if (fireballs[index].d % 2 == 0) {
                            all_odd = false;
                        } else {
                            all_even = false;
                        }
                    }

                    int new_m = total_m / 5;
                    if (new_m == 0) {
                        continue; 
                    }
                    int new_s = total_s / count;

                    int start_dir = (all_even || all_odd) ? 0 : 1;
                    for (int i = 0; i < 4; ++i) {
                        next_fireballs.push_back({r, c, new_m, new_s, start_dir + 2 * i});
                    }
                }
            }
        }
        fireballs = next_fireballs;
        if (fireballs.empty()) break; 
    }

    long long total_mass = 0;
    for (const auto& fb : fireballs) {
        total_mass += fb.m;
    }

    cout << total_mass << endl;

    return 0;
}