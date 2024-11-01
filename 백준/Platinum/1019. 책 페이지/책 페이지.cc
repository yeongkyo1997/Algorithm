#include <iostream>
#include <vector>
using namespace std;

typedef long long ll;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll N;
    cin >> N;
    vector<ll> cnts(10, 0);
    ll factor = 1;
    while (factor <= N)
    {
        ll higher = N / (factor * 10);
        ll cur = (N / factor) % 10;
        ll lower = N % factor;
        for (int d = 1; d <= 9; d++)
        {
            if (d < cur)
            {
                cnts[d] += (higher + 1) * factor;
            }
            else if (d == cur)
            {
                cnts[d] += higher * factor + lower + 1;
            }
            else
            {
                cnts[d] += higher * factor;
            }
        }
        if (higher > 0)
        {
            if (cur > 0)
            {
                cnts[0] += (higher - 1) * factor + factor;
            }
            else
            {
                cnts[0] += (higher - 1) * factor + lower + 1;
            }
        }
        factor *= 10;
    }
    cout << cnts[0];
    for (int d = 1; d <= 9; d++)
        cout << ' ' << cnts[d];
    cout << '\n';
}