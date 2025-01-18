#include <bits/stdc++.h>
using namespace std;

struct Fenwick
{
    int n;
    vector<long long> fenw;
    Fenwick(int n) : n(n), fenw(n + 1, 0LL) {}

    void update(int i, long long val)
    {
        for (; i <= n; i += (i & -i))
        {
            fenw[i] += val;
        }
    }
    long long query(int i)
    {
        long long s = 0;
        for (; i > 0; i -= (i & -i))
        {
            s += fenw[i];
        }
        return s;
    }
    long long range(int l, int r)
    {
        if (r < l)
            return 0LL;
        return query(r) - query(l - 1);
    }
};

long long solveBeautyAllSubstrings(const string &s)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N = (int)s.size();
    vector<int> arr(N);
    for (int i = 0; i < N; i++)
    {
        arr[i] = (s[i] - 'a');
    }

    vector<int> nextDiff(N, N), prevDiff(N, -1);
    for (int i = N - 2; i >= 0; i--)
    {
        if (arr[i] != arr[i + 1])
            nextDiff[i] = i + 1;
        else
            nextDiff[i] = nextDiff[i + 1];
    }
    for (int i = 1; i < N; i++)
    {
        if (arr[i] != arr[i - 1])
            prevDiff[i] = i - 1;
        else
            prevDiff[i] = prevDiff[i - 1];
    }

    static const int ALPH = 26;
    vector<long long> countChar(ALPH, 0LL), sumIndex(ALPH, 0LL);
    long long catA = 0LL;
    for (int j = 0; j < N; j++)
    {
        long long total = 1LL * j * (j + 1) / 2;
        int c = arr[j];
        long long ccount = countChar[c];
        long long csum = sumIndex[c];

        long long sameTerm = ccount * j - csum;
        long long diffTerm = total - sameTerm;
        catA += diffTerm;

        countChar[c]++;
        sumIndex[c] += j;
    }

    vector<vector<int>> posOf(ALPH);
    for (int i = 0; i < N; i++)
    {
        posOf[arr[i]].push_back(i);
    }

    long long catB = 0LL;

    struct Query
    {
        int xIdx;
        int ndx;
        long long baseA;
        int yStart;
        long long p_x;
    };

    auto processSameChar = [&](const vector<int> &pos) -> long long
    {
        long long res = 0;
        int m = (int)pos.size();
        if (m < 2)
            return 0;

        vector<long long> pSum(m + 1, 0LL);
        for (int i = 0; i < m; i++)
        {
            pSum[i + 1] = pSum[i] + pos[i];
        }

        vector<Query> queries;
        queries.reserve(m);

        for (int x = 0; x < m - 1; x++)
        {
            int px = pos[x];
            int ndx = nextDiff[px];
            if (ndx >= N)
                continue;

            int yStart = int(std::upper_bound(pos.begin(), pos.end(), ndx) - pos.begin());
            if (yStart >= m)
                continue;

            long long tailCount = (long long)(m - yStart);
            long long sumTailPos = (pSum[m] - pSum[yStart]);
            long long baseA = sumTailPos - tailCount * ndx;

            Query qq;
            qq.xIdx = x;
            qq.ndx = ndx;
            qq.baseA = baseA;
            qq.yStart = yStart;
            qq.p_x = px;
            queries.push_back(qq);
        }
        if (queries.empty())
            return 0LL;

        vector<long long> cprime(m);
        for (int y = 0; y < m; y++)
        {
            int py = pos[y];
            if (prevDiff[py] < 0)
            {
                cprime[y] = -1000000000000000000LL;
            }
            else
            {

                cprime[y] = (long long)prevDiff[py] - py;
            }
        }

        vector<pair<long long, int>> data(m);
        for (int y = 0; y < m; y++)
        {
            data[y] = {cprime[y], y};
        }
        sort(data.begin(), data.end(), [&](auto &a, auto &b)
             { return a.first > b.first; });

        struct OfflineQ
        {
            long long Dval;
            int yStart;
            long long baseA;
            long long px, ndx;
            int idx;
        };
        vector<OfflineQ> offq;
        offq.reserve(queries.size());
        for (int i = 0; i < (int)queries.size(); i++)
        {
            auto &Q = queries[i];
            long long Dx = (long long)Q.p_x - Q.ndx;

            long long Dp = Dx + 1;
            offq.push_back({Dp, Q.yStart, Q.baseA, Q.p_x, (long long)Q.ndx, i});
        }
        sort(offq.begin(), offq.end(), [&](auto &a, auto &b)
             { return a.Dval > b.Dval; });

        Fenwick fenwSum(m), fenwCount(m);

        int dataPos = 0;
        long long *ansBuf = new long long[queries.size()];

        for (auto &Q : offq)
        {
            long long needed = Q.Dval;
            while (dataPos < m && data[dataPos].first >= needed)
            {

                int yidx = data[dataPos].second;

                fenwSum.update(yidx + 1, data[dataPos].first);
                fenwCount.update(yidx + 1, 1LL);
                dataPos++;
            }

            int L = Q.yStart + 1, R = m;
            long long cntInRange = fenwCount.range(L, R);
            long long sumInRange = fenwSum.range(L, R);

            long long Dx = (long long)Q.px - Q.ndx;

            long long sumT = sumInRange - cntInRange * Dx;

            long long curRes = Q.baseA + sumT;

            ansBuf[Q.idx] = curRes;
        }

        long long localSum = 0;
        for (int i = 0; i < (int)queries.size(); i++)
        {
            localSum += ansBuf[i];
        }
        delete[] ansBuf;
        return localSum;
    };

    for (int c = 0; c < ALPH; c++)
    {
        if (!posOf[c].empty())
        {
            catB += processSameChar(posOf[c]);
        }
    }

    long long ans = catA + catB;
    return ans;
}

long long solution(string s)
{
    return solveBeautyAllSubstrings(s);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;
    cout << solution(s) << "\n";

    return 0;
}