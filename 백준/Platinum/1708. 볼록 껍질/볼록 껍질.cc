#include <bits/stdc++.h>
using namespace std;

struct Point
{
    int x, y;
};

long long cross_product(const Point &a, const Point &b, const Point &c)
{
    long long dx1 = b.x - a.x;
    long long dy1 = b.y - a.y;
    long long dx2 = c.x - a.x;
    long long dy2 = c.y - a.y;
    return dx1 * dy2 - dy1 * dx2;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    vector<Point> points(N);
    for (int i = 0; i < N; ++i)
    {
        cin >> points[i].x >> points[i].y;
    }

    sort(points.begin(), points.end(), [&](const Point &a, const Point &b) -> bool
         {
        if(a.x != b.x) return a.x < b.x;
        return a.y < b.y; });

    vector<Point> lower;
    for (const auto &p : points)
    {
        while (lower.size() >= 2 && cross_product(lower[lower.size() - 2], lower[lower.size() - 1], p) <= 0)
        {
            lower.pop_back();
        }
        lower.push_back(p);
    }

    vector<Point> upper;
    for (int i = points.size() - 1; i >= 0; --i)
    {
        const auto &p = points[i];
        while (upper.size() >= 2 && cross_product(upper[upper.size() - 2], upper[upper.size() - 1], p) <= 0)
        {
            upper.pop_back();
        }
        upper.push_back(p);
    }

    lower.pop_back();
    upper.pop_back();

    vector<Point> convex_hull = lower;
    for (const auto &p : upper)
    {
        convex_hull.push_back(p);
    }

    cout << convex_hull.size();
}