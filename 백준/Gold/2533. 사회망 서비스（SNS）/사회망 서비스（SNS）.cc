#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>

using namespace std;

class Node {
public:
    vector<int> linked;
};

void solve(int par, int chi, vector<Node>& nodes, vector<vector<int>>& dp) {
    int sum = 0;
    for (int i : nodes[chi].linked) {
        if (i != par) {
            solve(chi, i, nodes, dp);
            sum += dp[i][1];
        }
    }
    dp[chi][0] = sum;

    sum = 0;
    for (int i : nodes[chi].linked) {
        sum += min(dp[i][0], dp[i][1]);
    }
    dp[chi][1] = sum + 1;
}

int main() {
    int n;
    cin >> n;
    vector<Node> nodes(n + 1);
    vector<vector<int>> dp(n + 1, vector<int>(2));

    for (int i = 0; i < n - 1; ++i) {
        int a, b;
        cin >> a >> b;
        nodes[a].linked.push_back(b);
        nodes[b].linked.push_back(a);
    }
    
    solve(-1, 1, nodes, dp);
    cout << min(dp[1][0], dp[1][1]) << endl;

    return 0;
}