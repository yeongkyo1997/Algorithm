#include <bits/stdc++.h>
using namespace std;

int N;
vector<int> arr;
vector<int> ans;
vector<pair<int, int>> freq;

bool backtrack(int index, int prev)
{

    if (index == N)
    {
        return true;
    }

    for (int i = 0; i < (int)freq.size(); i++)
    {
        int val = freq[i].first;

        if (freq[i].second > 0 && prev + 1 != val)
        {
            freq[i].second--;
            ans[index] = val;

            if (backtrack(index + 1, val))
            {
                return true;
            }

            freq[i].second++;
        }
    }
    return false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    arr.resize(N);
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());

    freq.clear();
    freq.push_back({arr[0], 1});
    for (int i = 1; i < N; i++)
    {
        if (arr[i] == freq.back().first)
        {
            freq.back().second++;
        }
        else
        {
            freq.push_back({arr[i], 1});
        }
    }

    ans.resize(N);

    backtrack(0, -2);

    for (int i = 0; i < N; i++)
    {
        cout << ans[i];
        if (i < N - 1)
            cout << ' ';
    }
    cout << '\n';

    return 0;
}