#include <iostream>
#include <vector>
using namespace std;

const int MAX = 1000001;

vector<bool> sieve(MAX, true);
vector<int> primes;
vector<pair<int, int>> ans(MAX);

void precompute() {
    sieve[0] = sieve[1] = false;
    for (int i = 2; i < MAX; i++) {
        if (sieve[i]) {
            primes.push_back(i);
            for (long long j = (long long)i * i; j < MAX; j += i)
                sieve[j] = false;
        }
    }

    for (int n = 6; n < MAX; n += 2) {
        bool found = false;
        for (int i = 1; i < primes.size(); i++) {
            int a = primes[i];
            if (a > n / 2) break;
            if (sieve[n - a]) {
                ans[n] = {a, n - a};
                found = true;
                break;
            }
        }
        if (!found) ans[n] = {-1, -1};
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    precompute();

    int n;
    while (cin >> n && n != 0) {
        cout << n << " = " << ans[n].first << " + " << ans[n].second << '\n';
    }
    return 0;
    
}