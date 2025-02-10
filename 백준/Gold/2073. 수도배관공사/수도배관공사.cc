#include <iostream>
#include <vector>
#include <set>
#include <bitset>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int D, P;
    cin >> D >> P;

    vector<pair<int, int>> pipes(P);
    for (int i = 0; i < P; i++)
    {
        int L, C;
        cin >> L >> C;
        pipes[i] = {L, C};
    }

    set<int> capSet;
    for (auto &p : pipes)
    {
        capSet.insert(p.second);
    }
    vector<int> caps(capSet.begin(), capSet.end());
    sort(caps.begin(), caps.end(), greater<int>());

    int ans = 0;
    for (int cap : caps)
    {

        bitset<100001> dp;
        dp.reset();
        dp[0] = 1;

        for (auto &p : pipes)
        {

            if (p.second >= cap)
            {

                dp |= (dp << p.first);
            }
        }

        if (dp[D])
        {
            ans = cap;
            break;
        }
    }

    cout << ans << "\n";
    return 0;
}