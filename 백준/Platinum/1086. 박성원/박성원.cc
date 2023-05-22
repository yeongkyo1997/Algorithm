#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int N, K, MaxBitmask;
vector<string> Nums;
vector<vector<long>> Dp;
vector<vector<int>> Mods;

long dp(int bitmask, int mod);
int getMod(int idx, int mod);
long getGcd(long n, long m);

int main() {
    cin >> N;
    Nums.resize(N);

    for (int i = 0; i < N; i++) {
        cin >> Nums[i];
    }

    cin >> K;
    MaxBitmask = (1 << N) - 1;
    Dp.resize(1 << N, vector<long>(K));
    Mods.resize(N, vector<int>(K));

    for (int j = 0; j < K; j++) {
        for (int i = 0; i < N; i++) {
            Mods[i][j] = -1;
        }
        for (int i = 0; i <= MaxBitmask; i++) {
            Dp[i][j] = -1;
        }
    }

    long answer = dp(0, 0);

    if (answer == 0) {
        cout << "0/1" << endl;
    } else {
        long fac = 1;
        for (int i = 2; i <= N; i++) {
            fac *= i;
        }
        long gcd = getGcd(fac, answer);
        cout << answer / gcd << "/" << fac / gcd << endl;
    }

    return 0;
}

long dp(int bitmask, int mod) {
    if (Dp[bitmask][mod] != -1) {
        return Dp[bitmask][mod];
    }

    if (bitmask == MaxBitmask) {
        return mod == 0 ? 1 : 0;
    }

    long count = 0;
    for (int i = 0; i < N; i++) {
        int idx = 1 << i;
        if ((bitmask & idx) == 0) {
            count += dp(bitmask | idx, getMod(i, mod));
        }
    }

    return Dp[bitmask][mod] = count;
}

int getMod(int idx, int mod) {
    if (Mods[idx][mod] != -1) return Mods[idx][mod];
    int curr = mod;
    int length = Nums[idx].length();
    for (int i = 0; i < length; i++) {
        curr *= 10;
        curr += (Nums[idx][i] - '0');
        curr %= K;
    }
    return Mods[idx][mod] = curr;
}

long getGcd(long n, long m) {
    if (m == 0) return n;
    return getGcd(m, n % m);
}