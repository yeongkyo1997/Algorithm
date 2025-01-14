#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    vector<int> A(n), B(n), C(n), D(n);

    for (int i = 0; i < n; i++)
    {
        cin >> A[i] >> B[i] >> C[i] >> D[i];
    }

    vector<int> AB;
    AB.reserve((long long)n * n);

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            AB.push_back(A[i] + B[j]);
        }
    }

    vector<int> CD;
    CD.reserve((long long)n * n);

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            CD.push_back(C[i] + D[j]);
        }
    }

    sort(AB.begin(), AB.end());
    sort(CD.begin(), CD.end());

    long long result = 0;
    int i = 0;
    int j = CD.size() - 1;

    while (i < AB.size() && j >= 0)
    {
        long long cur_sum = (long long)AB[i] + (long long)CD[j];

        if (cur_sum == 0)
        {
            long long cnt1 = 1;
            int cur_a = AB[i];
            i++;
            while (i < AB.size() && AB[i] == cur_a)
            {
                cnt1++;
                i++;
            }

            long long cnt2 = 1;
            int cur_b = CD[j];
            j--;
            while (j >= 0 && CD[j] == cur_b)
            {
                cnt2++;
                j--;
            }
            result += cnt1 * cnt2;
        }
        else if (cur_sum > 0)
            j--;
        else
            i++;
    }

    cout << result;
    return 0;
}