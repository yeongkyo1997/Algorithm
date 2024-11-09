#include <bits/stdc++.h>
using namespace std;

long long solution(vector<int> cookie)
{
    int N = cookie.size();
    if (N < 2)
        return 0;

    vector<long long> prefixSum(N + 1, 0);

    for (int i = 1; i <= N; i++)
        prefixSum[i] = prefixSum[i - 1] + cookie[i - 1];

    long long maxSum = 0;

    for (int m = 1; m <= N - 1; m++)
    {
        vector<long long> sum1s;
        for (int l = 1; l <= m; l++)
        {
            long long s = prefixSum[m] - prefixSum[l - 1];
            sum1s.push_back(s);
        }

        sort(sum1s.begin(), sum1s.end());

        vector<long long> sum2s;
        for (int r = m + 1; r <= N; r++)
        {
            long long s = prefixSum[r] - prefixSum[m];
            sum2s.push_back(s);
        }

        sort(sum2s.begin(), sum2s.end());

        int i = sum1s.size() - 1;
        int j = sum2s.size() - 1;

        while (i >= 0 && j >= 0)
        {
            if (sum1s[i] == sum2s[j])
            {
                if (sum1s[i] > maxSum)
                    maxSum = sum1s[i];
                break;
            }
            else if (sum1s[i] > sum2s[j])
                i--;
            else
                j--;
        }
    }

    return maxSum;
}