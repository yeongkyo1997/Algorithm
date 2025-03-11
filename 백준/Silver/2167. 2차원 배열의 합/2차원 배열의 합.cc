#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int N, M;
    cin >> N >> M;
    
    vector<vector<int>> matrix(N+1, vector<int>(M+1, 0));
    vector<vector<int>> prefix(N+1, vector<int>(M+1, 0));
    
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= M; ++j) {
            cin >> matrix[i][j];
        }
    }
    
    // Compute 2D prefix sums
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= M; ++j) {
            prefix[i][j] = matrix[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
        }
    }
    
    int K;
    cin >> K;
    
    while (K--) {
        int i, j, x, y;
        cin >> i >> j >> x >> y;
        int sum = prefix[x][y] - prefix[i-1][y] - prefix[x][j-1] + prefix[i-1][j-1];
        cout << sum << '\n';
    }
    
    return 0;
}