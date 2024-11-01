#include <iostream>
#include <cstdio>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int T;
    scanf("%d", &T);

    while (T--)
    {
        int a, b;
        scanf("%d,%d", &a, &b);
        cout << a + b << "\n";
    }
}