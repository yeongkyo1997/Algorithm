#include <bits/stdc++.h>

using namespace std;

struct setCompare
{
    bool operator()(string a, string b) const
    {
        if (a.size() == b.size())
            return a < b;
        return a.size() < b.size();
    }
};
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    set<string, setCompare> s;

    while (N--)
    {
        string word;
        cin >> word;
        s.insert(word);
    }

    for (auto it = s.begin(); it != s.end(); ++it)
    {
        cout << *it << '\n';
    }
}