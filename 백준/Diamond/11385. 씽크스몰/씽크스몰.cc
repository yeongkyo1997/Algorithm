#include <bits/stdc++.h>
using namespace std;

int modExp(long long base, int exp, int mod)
{
    long long result = 1 % mod;
    base %= mod;
    while (exp > 0)
    {
        if (exp & 1)
            result = (result * base) % mod;
        base = (base * base) % mod;
        exp >>= 1;
    }
    return (int)result;
}

int modInv(int a, int mod)
{
    return modExp(a, mod - 2, mod);
}

void ntt(vector<int> &a, bool invert, int mod, int root)
{
    int n = a.size();
    for (int i = 1, j = 0; i < n; i++)
    {
        int bit = n >> 1;
        for (; j & bit; bit >>= 1)
            j -= bit;
        j += bit;
        if (i < j)
            swap(a[i], a[j]);
    }
    for (int len = 2; len <= n; len <<= 1)
    {
        int wlen = modExp(root, (mod - 1) / len, mod);
        if (invert)
            wlen = modInv(wlen, mod);
        for (int i = 0; i < n; i += len)
        {
            int w = 1;
            for (int j = 0; j < len / 2; j++)
            {
                int u = a[i + j];
                int v = (int)((long long)a[i + j + len / 2] * w % mod);
                int t = u + v;
                if (t >= mod)
                    t -= mod;
                a[i + j] = t;
                t = u - v;
                if (t < 0)
                    t += mod;
                a[i + j + len / 2] = t;
                w = (int)((long long)w * wlen % mod);
            }
        }
    }
    if (invert)
    {
        int inv_n = modInv(n, mod);
        for (int &x : a)
            x = (int)((long long)x * inv_n % mod);
    }
}

vector<int> convolution(const vector<int> &a, const vector<int> &b, int mod, int root)
{
    int n = a.size(), m = b.size();
    int sz = 1;
    while (sz < n + m - 1)
        sz <<= 1;
    vector<int> fa(sz, 0), fb(sz, 0);
    for (int i = 0; i < n; i++)
    {
        fa[i] = a[i] % mod;
    }
    for (int i = 0; i < m; i++)
    {
        fb[i] = b[i] % mod;
    }
    ntt(fa, false, mod, root);
    ntt(fb, false, mod, root);
    for (int i = 0; i < sz; i++)
    {
        fa[i] = (int)((long long)fa[i] * fb[i] % mod);
    }
    ntt(fa, true, mod, root);
    fa.resize(n + m - 1);
    return fa;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;
    vector<int> f(N + 1), g(M + 1);
    for (int i = 0; i <= N; i++)
    {
        cin >> f[i];
    }
    for (int j = 0; j <= M; j++)
    {
        cin >> g[j];
    }

    const int MOD1 = 998244353, ROOT1 = 3;
    const int MOD2 = 1004535809, ROOT2 = 3;
    const int MOD3 = 469762049, ROOT3 = 3;

    vector<int> conv1 = convolution(f, g, MOD1, ROOT1);
    vector<int> conv2 = convolution(f, g, MOD2, ROOT2);
    vector<int> conv3 = convolution(f, g, MOD3, ROOT3);

    int sz = conv1.size();

    int invM1_modM2 = modInv(MOD1 % MOD2, MOD2);

    long long M1M2 = (long long)MOD1 * MOD2 % MOD3;
    int invM1M2_modM3 = modInv((int)M1M2, MOD3);

    long long answer = 0;
    for (int i = 0; i < sz; i++)
    {
        int r1 = conv1[i];
        int r2 = conv2[i];
        int r3 = conv3[i];

        int diff = r2 - r1;
        if (diff < 0)
            diff += MOD2;
        int k2 = (int)((long long)diff * invM1_modM2 % MOD2);
        long long x = r1 + (long long)MOD1 * k2;

        int x_mod3 = (int)(x % MOD3);
        int diff2 = r3 - x_mod3;
        if (diff2 < 0)
            diff2 += MOD3;
        int k3 = (int)((long long)diff2 * invM1M2_modM3 % MOD3);

        long long coef = x + (long long)MOD1 * MOD2 * k3;

        answer ^= coef;
    }

    cout << answer << "\n";
    return 0;
}