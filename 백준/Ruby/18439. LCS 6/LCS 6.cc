#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

typedef unsigned long long ull;

void shiftLeft(const vector<ull> &src, vector<ull> &dest, int blockCount)
{
    ull carry = 0;
    for (int i = 0; i < blockCount; i++)
    {
        ull newCarry = src[i] >> (64 - 1);
        dest[i] = (src[i] << 1) | carry;
        carry = newCarry;
    }
}

void subtractVec(const vector<ull> &X, const vector<ull> &Y, vector<ull> &res, int blockCount)
{
    ull carry = 0;
    for (int i = 0; i < blockCount; i++)
    {
        ull x = X[i], y = Y[i];
        ull sub = x - y - carry;
        res[i] = sub;

        carry = (x < y + carry) ? 1ULL : 0ULL;
    }
}

int popcountVec(const vector<ull> &vec)
{
    int cnt = 0;
    for (auto v : vec)
    {
        cnt += __builtin_popcountll(v);
    }
    return cnt;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s, t;
    cin >> s >> t;

    if (s.size() > t.size())
        swap(s, t);

    int n = t.size();
    int blockCount = (n + 63) / 64;

    vector<vector<ull>> charMask(26, vector<ull>(blockCount, 0ULL));
    for (int i = 0; i < n; i++)
    {
        char c = t[i];
        int idx = c - 'A';
        int block = i / 64;
        int bit = i % 64;
        charMask[idx][block] |= (1ULL << bit);
    }

    vector<ull> dp(blockCount, 0ULL);

    vector<ull> X(blockCount, 0ULL), shifted(blockCount, 0ULL), sub(blockCount, 0ULL);

    for (char c : s)
    {
        int letter = c - 'A';

        for (int i = 0; i < blockCount; i++)
        {
            X[i] = dp[i] | charMask[letter][i];
        }

        shiftLeft(dp, shifted, blockCount);
        shifted[0] |= 1ULL;

        subtractVec(X, shifted, sub, blockCount);

        for (int i = 0; i < blockCount; i++)
        {
            dp[i] = X[i] & (~sub[i]);
        }
    }

    int lcsLen = popcountVec(dp);
    cout << lcsLen << "\n";

    return 0;
}