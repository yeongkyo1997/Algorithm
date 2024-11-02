#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    long long int N, M;
    cin >> N >> M;

    cout << ((N == M) ? 1 : 0);
}