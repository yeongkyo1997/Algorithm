#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M;
    cin >> N >> M;

    unordered_set<string> a, b;

    while (N--)
    {
        string name;
        cin >> name;
        a.insert(name);
    }
    while (M--)
    {
        string name;
        cin >> name;
        b.insert(name);
    }

    vector<string> ret;
    for (const auto &ele : a)
    {
        if (b.find(ele) != b.end())
            ret.push_back(ele);
    }

    sort(ret.begin(), ret.end());

    cout << ret.size() << '\n';
    for (const auto &ele : ret)
    {
        cout << ele << '\n';
    }
}