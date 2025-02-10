#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long D, P, Q;
    cin >> D >> P >> Q;

    if (P > Q)
        swap(P, Q);

    if (P == 1)
    {
        cout << D << "\n";
        return 0;
    }

    long long B_upper = (D + Q - 1) / Q;
    if (B_upper > P - 1)
        B_upper = P - 1;

    long long ans = LLONG_MAX;
    for (long long b = 0; b <= B_upper; b++)
    {
        long long sumQ = b * Q;
        long long candidate;
        if (sumQ >= D)
        {
            candidate = sumQ;
        }
        else
        {
            long long rem = D - sumQ;

            long long a = (rem + P - 1) / P;
            candidate = sumQ + a * P;
        }
        ans = min(ans, candidate);
    }

    cout << ans << "\n";
    return 0;
}