#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cstring> 

using namespace std;

int n;
int cost[15][15];
int dp[15][10][1 << 15];
int solve(int current_artist, int current_price, int visited_mask) {
    if (dp[current_artist][current_price][visited_mask] != -1) {
        return dp[current_artist][current_price][visited_mask];
    }

    int max_owners = __builtin_popcount(visited_mask);

    for (int next_artist = 0; next_artist < n; ++next_artist) {
        if (!(visited_mask & (1 << next_artist))) {
            int selling_price = cost[current_artist][next_artist];
            if (selling_price >= current_price) {
                max_owners = max(max_owners,
                                 solve(next_artist, selling_price, visited_mask | (1 << next_artist)));
            }
        }
    }

    return dp[current_artist][current_price][visited_mask] = max_owners;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; ++i) {
        string row;
        cin >> row;
        for (int j = 0; j < n; ++j) {
            cost[i][j] = row[j] - '0'; 
        }
    }

    memset(dp, -1, sizeof(dp));

    int result = solve(0, 0, 1);

    cout << result << endl;

    return 0;
}