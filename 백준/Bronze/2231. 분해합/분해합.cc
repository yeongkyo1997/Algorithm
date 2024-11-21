#include <bits/stdc++.h>

using namespace std;

int sum(string s)
{
    int ret = stoi(s);
    for (char &c : s)
    {
        ret += c - '0';
    }
    return ret;
}

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        if (sum(to_string(i)) == N)
        {
            cout << i;
            return 0;
        }
    }
    cout << 0;
}