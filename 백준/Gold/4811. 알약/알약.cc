#include <bits/stdc++.h>
using namespace std;

typedef unsigned long long ull;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    const int MAX_N = 30;
    ull catalan[MAX_N + 1];
    catalan[0] = 1;
    for (int n = 1; n <= MAX_N; n++)
    {
        catalan[n] = catalan[n - 1] * 2 * (2 * (n - 1) + 1) / (n + 1);
    }
    while (true)
    {
        int N;
        cin >> N;
        if (N == 0)
            break;
        if (N >= 0 && N <= MAX_N)
        {
            cout << catalan[N] << "\n";
        }
        else
        {
            cout << "0\n";
        }
    }
}