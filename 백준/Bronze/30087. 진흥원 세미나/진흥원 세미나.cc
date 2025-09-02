#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    unordered_map<string, string> rooms{
        {"Algorithm", "204"},
        {"DataAnalysis", "207"},
        {"ArtificialIntelligence", "302"},
        {"CyberSecurity", "B101"},
        {"Network", "303"},
        {"Startup", "501"},
        {"TestStrategy", "105"}
    };

    int N;
    if (!(cin >> N)) return 0;
    for (int i = 0; i < N; ++i) {
        string s;
        cin >> s;
        cout << rooms[s] << '\n';
    }
    return 0;
}