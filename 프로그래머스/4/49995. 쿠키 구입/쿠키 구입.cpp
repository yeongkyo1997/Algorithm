#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> cookie)
{
    int N = cookie.size();

    vector<long long> prefix(N + 1, 0);
    for (int i = 1; i <= N; ++i)
    {
        prefix[i] = prefix[i - 1] + cookie[i - 1];
    }

    int maxCookies = 0;

    for (int m = 1; m < N; ++m)
    {

        vector<int> sum1_list;
        sum1_list.reserve(m);
        long long sum1 = 0;
        for (int l = m; l >= 1; --l)
        {
            sum1 += cookie[l - 1];
            sum1_list.push_back(sum1);
        }

        vector<int> sum2_list;
        sum2_list.reserve(N - m);
        long long sum2 = 0;
        for (int r = m + 1; r <= N; ++r)
        {
            sum2 += cookie[r - 1];
            sum2_list.push_back(sum2);
        }

        sort(sum1_list.begin(), sum1_list.end(), greater<int>());
        sort(sum2_list.begin(), sum2_list.end(), greater<int>());

        int i = 0, j = 0;
        while (i < sum1_list.size() && j < sum2_list.size())
        {
            if (sum1_list[i] == sum2_list[j])
            {
                if (sum1_list[i] > maxCookies)
                {
                    maxCookies = sum1_list[i];
                }

                break;
            }
            else if (sum1_list[i] > sum2_list[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
    }

    return maxCookies;
}