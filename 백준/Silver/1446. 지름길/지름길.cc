#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

struct Shortcut
{
    int start;
    int end;
    int length;
};

int main()
{
    int N, D;
    cin >> N >> D;

    vector<Shortcut> shortcuts(N);
    for (int i = 0; i < N; ++i)
    {
        cin >> shortcuts[i].start >> shortcuts[i].end >> shortcuts[i].length;
    }

    const int INF = 1e9;
    vector<int> dp(D + 1, INF);
    dp[0] = 0;

    for (int i = 0; i <= D; ++i)
    {
        if (i > 0)
        {
            dp[i] = min(dp[i], dp[i - 1] + 1);
        }

        for (auto &s : shortcuts)
        {
            if (s.start == i)
            {
                if (s.end > D)
                    continue;
                dp[s.end] = min(dp[s.end], dp[i] + s.length);
            }
        }
    }

    cout << dp[D];
}