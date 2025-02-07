#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

struct Point
{
    int x, y;
};

bool cmpX(const Point &a, const Point &b)
{
    return a.x < b.x;
}

bool cmpY(const Point &a, const Point &b)
{
    return a.y < b.y;
}

inline long long dist2(const Point &a, const Point &b)
{
    long long dx = a.x - b.x;
    long long dy = a.y - b.y;
    return dx * dx + dy * dy;
}

long long closest_pair(vector<Point> &points, int l, int r)
{
    if (r - l <= 1)
        return LLONG_MAX;
    int mid = (l + r) / 2;
    int midx = points[mid].x;

    long long d = min(closest_pair(points, l, mid), closest_pair(points, mid, r));

    vector<Point> strip;
    for (int i = l; i < r; i++)
    {
        long long dx = points[i].x - midx;
        if (dx * dx < d)
        {
            strip.push_back(points[i]);
        }
    }

    sort(strip.begin(), strip.end(), cmpY);

    int sz = strip.size();
    for (int i = 0; i < sz; i++)
    {

        for (int j = i + 1; j < sz && (long long)(strip[j].y - strip[i].y) * (strip[j].y - strip[i].y) < d; j++)
        {
            d = min(d, dist2(strip[i], strip[j]));
        }
    }
    return d;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<Point> points(n);
    for (int i = 0; i < n; i++)
    {
        cin >> points[i].x >> points[i].y;
    }

    sort(points.begin(), points.end(), cmpX);

    long long ans = closest_pair(points, 0, n);
    cout << ans << "\n";

    return 0;
}