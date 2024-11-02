#include <iostream>

using namespace std;

typedef long long ll;

int main()
{
    int N;
    cin >> N;

    ll result = 1;
    for (int i = 1; i <= N; i++)
    {
        result *= i;
    }
    cout << result;
}