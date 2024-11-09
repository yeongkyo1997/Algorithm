#include <iostream>
#include <vector>
#include <string>

using namespace std;

int solution(vector<string> strs, string t)
{
    int n = t.size();
    vector<int> dp(n + 1, n + 1);
    dp[0] = 0;

    for (int i = 1; i <= n; ++i)
    {
        for (auto &word : strs)
        {
            int len = word.size();
            if (i >= len)
            {
                if (t.compare(i - len, len, word) == 0)
                {
                    if (dp[i - len] + 1 < dp[i])
                    {
                        dp[i] = dp[i - len] + 1;
                    }
                }
            }
        }
    }

    return dp[n] > n ? -1 : dp[n];
}
