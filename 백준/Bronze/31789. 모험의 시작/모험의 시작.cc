#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;

    long long X, S;
    cin >> X >> S;

    bool flag = false;

    for (int i = 0; i < N; i++)
    {
        long long c, p;
        cin >> c >> p;
        if (c <= X && p > S)
        {
            flag = true;
        }
    }

    if (flag)
    {
        cout << "YES";
    }
    else
    {
        cout << "NO";
    }

    return 0;
}