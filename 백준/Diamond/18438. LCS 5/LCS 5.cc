#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> lcsForward(const string &X, int i1, int i2, const string &Y, int j1, int j2)
{
    int m = j2 - j1;
    vector<int> prev(m + 1, 0), curr(m + 1, 0);
    for (int i = i1; i < i2; i++)
    {
        curr.assign(m + 1, 0);
        for (int j = 0; j < m; j++)
        {
            if (X[i] == Y[j1 + j])
                curr[j + 1] = prev[j] + 1;
            else
                curr[j + 1] = max(prev[j + 1], curr[j]);
        }
        prev = curr;
    }
    return prev;
}

vector<int> lcsBackward(const string &X, int i1, int i2, const string &Y, int j1, int j2)
{
    int m = j2 - j1;
    vector<int> prev(m + 1, 0), curr(m + 1, 0);
    for (int i = i2 - 1; i >= i1; i--)
    {
        curr.assign(m + 1, 0);
        for (int j = m - 1; j >= 0; j--)
        {
            if (X[i] == Y[j1 + j])
                curr[j] = prev[j + 1] + 1;
            else
                curr[j] = max(prev[j], curr[j + 1]);
        }
        prev = curr;
    }
    return prev;
}

string Hirschberg(const string &X, const string &Y)
{
    int n = X.size(), m = Y.size();
    if (n == 0)
        return "";
    if (n == 1)
    {
        for (int j = 0; j < m; j++)
        {
            if (X[0] == Y[j])
                return string(1, X[0]);
        }
        return "";
    }
    int i = n / 2;

    vector<int> L1 = lcsForward(X, 0, i, Y, 0, m);

    vector<int> L2 = lcsBackward(X, i, n, Y, 0, m);

    int jmax = 0, maxVal = -1;
    for (int j = 0; j <= m; j++)
    {
        if (L1[j] + L2[j] > maxVal)
        {
            maxVal = L1[j] + L2[j];
            jmax = j;
        }
    }

    string left = Hirschberg(X.substr(0, i), Y.substr(0, jmax));
    string right = Hirschberg(X.substr(i), Y.substr(jmax));
    return left + right;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s1, s2;
    cin >> s1 >> s2;

    string lcs = Hirschberg(s1, s2);
    cout << lcs.size() << "\n"
         << lcs;
    return 0;
}