#include <iostream>
using namespace std;
int main()
{
    int N, L;
    cin >> N >> L;

    for (int l = L; l <= 100; l++)
    {
        int tg = N - l * (l + 1) / 2;
        if (tg % l == 0)
        {
            int x = tg / l + 1;
            if (x >= 0)
            {
                for (int len = 0; len < l; len++)
                {
                    cout << len + x << " ";
                }
                cout << "\n";
                return 0;
            }
        }
    }
    cout << "-1\n";
}