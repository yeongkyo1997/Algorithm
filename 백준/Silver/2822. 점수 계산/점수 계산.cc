#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    vector<pair<int, int>> problems(8);
    for (int i = 0; i < 8; ++i) {
        int score;
        cin >> score;
        problems[i] = {score, i + 1};
    }

    sort(problems.begin(), problems.end(), [](const auto& a, const auto& b) {
        return a.first > b.first;
    });

    int total = 0;
    vector<int> selected;
    for (int i = 0; i < 5; ++i) {
        total += problems[i].first;
        selected.push_back(problems[i].second);
    }

    sort(selected.begin(), selected.end());

    cout << total << '\n';
    for (size_t i = 0; i < selected.size(); ++i) {
        if (i > 0) cout << ' ';
        cout << selected[i];
    }
    cout << '\n';

    return 0;
}