#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;

ll EulerPhi(ll n) {
    ll result = n;
    for (ll p = 2; p * p <= n; ++p) {
        if (n % p == 0) {
            while (n % p == 0)
                n /= p;
            result -= result / p;
        }
    }
    if (n > 1)
        result -= result / n;
    return result;
}

int main() {
    ll n;
    cin >> n;
    cout << EulerPhi(n) << "\n";
    return 0;
}