#include <bits/stdc++.h>

using namespace std;

vector<int> prime()
{
    vector<int> sieve(1001, 1);
    sieve[1] = 0;
    sieve[2] = 1;

    for (int i = 2; i <= 1000; ++i)
    {
        if (sieve[i])
        {
            for (int j = i * i; j <= 1000; j += i)
            {
                sieve[j] = 0;
            }
        }
    }
    return sieve;
}

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL);
    cout.tie(NULL);
    vector<int> sieve = prime();
    int N;
    cin >> N;
    int result = 0;

    while (N--)
    {
        int num;
        cin >> num;
        if (sieve[num])
            result++;
    }

    cout << result;
}