#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int N;
vector<pair<int, int>> arr;
int result = INT_MIN;

void dfs(int total, int depth) {
    if (depth >= N) {
        result = max(result, total);
        return;
    }

    int a = arr[depth].first;
    int b = arr[depth].second;

    if (depth + a <= N) {
        dfs(total + b, depth + a);
    }
    dfs(total, depth + 1);
}

int main() {
    cin >> N;
    arr.resize(N);
    for (int i = 0; i < N; ++i) {
        cin >> arr[i].first >> arr[i].second;
    }

    dfs(0, 0);
    cout << result << endl;

    return 0;
}