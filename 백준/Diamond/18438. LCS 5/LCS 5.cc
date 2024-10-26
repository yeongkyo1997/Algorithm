#include <bits/stdc++.h>
using namespace std;

vector<int> LCS(const string &A, const string &B)
{
    int m = A.size();
    int n = B.size();
    vector<int> prev(n + 1, 0);
    vector<int> cur(n + 1, 0);

    for (int i = 1; i <= m; ++i)
    {
        for (int j = 1; j <= n; ++j)
        {
            if (A[i - 1] == B[j - 1])
            {
                cur[j] = prev[j - 1] + 1;
            }
            else
            {
                cur[j] = max(prev[j], cur[j - 1]);
            }
        }
        prev.swap(cur);
    }
    return prev;
}

string Hirschberg(const string &A, const string &B)
{
    int m = A.size();
    int n = B.size();

    if (m == 0)
    {
        return "";
    }
    if (m == 1)
    {
        size_t pos = B.find(A[0]);
        if (pos != string::npos)
        {
            return string(1, A[0]);
        }
        else
        {
            return "";
        }
    }
    int mid = m / 2;

    string A_left = A.substr(0, mid);
    string A_right = A.substr(mid, m - mid);

    vector<int> L1 = LCS(A_left, B);

    string A_right_rev = A_right;
    string B_rev = B;
    reverse(A_right_rev.begin(), A_right_rev.end());
    reverse(B_rev.begin(), B_rev.end());

    vector<int> L2 = LCS(A_right_rev, B_rev);

    int max_partition = 0;
    int max_value = 0;
    for (int i = 0; i <= n; ++i)
    {
        int current = L1[i] + L2[n - i];
        if (current > max_value)
        {
            max_value = current;
            max_partition = i;
        }
    }

    string B_left = B.substr(0, max_partition);
    string B_right = B.substr(max_partition, n - max_partition);

    string C1 = Hirschberg(A_left, B_left);
    string C2 = Hirschberg(A_right, B_right);

    return C1 + C2;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    string A, B;
    getline(cin, A);
    getline(cin, B);

    string LCS = Hirschberg(A, B);
    cout << LCS.size() << "\n"
         << LCS;
}