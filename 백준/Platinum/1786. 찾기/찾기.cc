#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<int> getPi(string p)
{
    int j = 0;

    vector<int> pi(p.size(), 0);

    for (int i = 1; i < p.size(); i++)
    {
        while (j > 0 && p[i] != p[j])
            j = pi[j - 1];
        if (p[i] == p[j])
            pi[i] = ++j;
    }
    return pi;
}

vector<int> KMP(string s, string p)
{
    vector<int> ret;
    auto pi = getPi(p);

    int j = 0;

    for (int i = 0; i < s.size(); i++)
    {
        while (j > 0 && s[i] != p[j])
            j = pi[j - 1];
        if (s[i] == p[j])
        {
            if (j == p.size() - 1)
            {
                ret.push_back(i - p.size() + 1);
                j = pi[j];
            }
            else
            {
                j++;
            }
        }
    }
    return ret;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s, p;
    getline(cin, s);
    getline(cin, p);

    vector<int> ret = KMP(s, p);

    cout << ret.size() << "\n";

    for (auto r : ret)
    {
        cout << r + 1 << "\n";
    }
}