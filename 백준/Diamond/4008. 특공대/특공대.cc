#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

struct Line
{
    ll m;
    ll c;
};

bool is_bad(const Line &l1, const Line &l2, const Line &l3)
{

    __int128 lhs = (__int128)(l2.c - l1.c) * (l1.m - l3.m);
    __int128 rhs = (__int128)(l3.c - l1.c) * (l1.m - l2.m);
    return lhs >= rhs;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;

    ll a, b, c;
    cin >> a >> b >> c;

    vector<ll> x(n);
    for (auto &val : x)
        cin >> val;

    vector<ll> prefix_sum(n + 1, 0);
    for (int i = 1; i <= n; i++)
        prefix_sum[i] = prefix_sum[i - 1] + x[i - 1];

    vector<ll> dp(n + 1, 0);
    dp[0] = 0;

    deque<Line> dq;

    Line initial;
    initial.m = 0;
    initial.c = 0;
    dq.push_back(initial);

    for (int i = 1; i <= n; i++)
    {
        ll x_i = prefix_sum[i];

        while (dq.size() >= 2)
        {
            Line first = dq[0];
            Line second = dq[1];

            ll val1 = first.m * x_i + first.c;
            ll val2 = second.m * x_i + second.c;
            if (val2 >= val1)
            {
                dq.pop_front();
            }
            else
            {
                break;
            }
        }

        Line best = dq[0];
        ll contribution = best.m * x_i + best.c;
        dp[i] = a * x_i * x_i + b * x_i + c + contribution;

        Line new_line;
        new_line.m = -2 * a * prefix_sum[i];
        new_line.c = dp[i] + a * prefix_sum[i] * prefix_sum[i] - b * prefix_sum[i];

        while (dq.size() >= 2)
        {
            Line l1 = dq[dq.size() - 2];
            Line l2 = dq[dq.size() - 1];
            Line l3 = new_line;
            if (is_bad(l1, l2, l3))
            {
                dq.pop_back();
            }
            else
            {
                break;
            }
        }

        dq.push_back(new_line);
    }

    cout << dp[n];
}