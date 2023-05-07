#include <iostream>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int X, N, a, b;
    cin >> X >> N;

    int sum = 0;
    for (int i = 0; i < N; i++)
    {
        cin >> a >> b;
        sum += (a * b);
    }

    if (sum == X)
        cout << "Yes\n";
    else
        cout << "No\n";

    return 0;
}