#include <bits/stdc++.h>
using namespace std;

static const int MAX_SUM = 2000;

bool isPrimeArr[MAX_SUM + 1];

void sievePrime()
{
    fill(isPrimeArr, isPrimeArr + MAX_SUM + 1, true);
    isPrimeArr[0] = false;
    isPrimeArr[1] = false;
    for (int i = 2; i * i <= MAX_SUM; i++)
    {
        if (isPrimeArr[i])
        {
            for (int j = i * i; j <= MAX_SUM; j += i)
            {
                isPrimeArr[j] = false;
            }
        }
    }
}

bool dfs(int u, const vector<vector<int>> &adj,
         vector<int> &matched, vector<bool> &visited)
{
    for (int v : adj[u])
    {
        if (visited[v])
            continue;
        visited[v] = true;

        if (matched[v] == -1 || dfs(matched[v], adj, matched, visited))
        {
            matched[v] = u;
            return true;
        }
    }
    return false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    sievePrime();

    int N;
    cin >> N;

    vector<int> arr(N);
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    int firstNum = arr[0];

    vector<int> others(arr.begin() + 1, arr.end());

    vector<int> candidates;
    for (int x : others)
    {
        if (isPrimeArr[firstNum + x])
        {
            candidates.push_back(x);
        }
    }

    vector<int> answer;

    sort(candidates.begin(), candidates.end());

    for (int c : candidates)
    {

        vector<int> remain;
        remain.reserve(N - 2);
        for (int x : others)
        {
            if (x == c)
                continue;
            remain.push_back(x);
        }

        vector<int> odd, even;
        for (int x : remain)
        {
            if (x % 2)
                odd.push_back(x);
            else
                even.push_back(x);
        }

        if (odd.size() != even.size())
        {
            continue;
        }

        int sizeLeft = (int)odd.size();
        int sizeRight = (int)even.size();

        vector<vector<int>> adj(sizeLeft);

        for (int i = 0; i < sizeLeft; i++)
        {
            for (int j = 0; j < sizeRight; j++)
            {
                if (isPrimeArr[odd[i] + even[j]])
                {
                    adj[i].push_back(j);
                }
            }
        }

        vector<int> matched(sizeRight, -1);
        int matchCount = 0;
        for (int i = 0; i < sizeLeft; i++)
        {
            vector<bool> visited(sizeRight, false);
            if (dfs(i, adj, matched, visited))
            {
                matchCount++;
            }
        }

        if (matchCount == sizeLeft)
        {
            answer.push_back(c);
        }
    }

    if (answer.empty())
    {
        cout << -1 << "\n";
    }
    else
    {
        for (int i = 0; i < (int)answer.size(); i++)
        {
            cout << answer[i];
            if (i + 1 < (int)answer.size())
                cout << " ";
        }
        cout << "\n";
    }

    return 0;
}