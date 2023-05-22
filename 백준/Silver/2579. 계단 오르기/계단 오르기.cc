#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> stair(301);
    vector<int> score(301);

    for (int i = 1; i <= N; i++) {
        cin >> stair[i];
    }

    score[1] = stair[1];
    score[2] = stair[1] + stair[2];
    score[3] = max(stair[1], stair[2]) + stair[3];

    for (int n = 4; n <= N; n++) {
        score[n] = max(score[n - 3] + stair[n - 1], score[n - 2]) + stair[n];
    }

    cout << score[N] << endl;

    return 0;
}