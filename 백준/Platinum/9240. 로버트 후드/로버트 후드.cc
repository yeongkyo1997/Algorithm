#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

struct Point
{
    int x, y;
    bool operator<(const Point &other) const
    {
        return x < other.x || (x == other.x && y < other.y);
    }
};

ll cross(const Point &O, const Point &A, const Point &B)
{
    ll val = (ll)(A.x - O.x) * (B.y - O.y) - (ll)(A.y - O.y) * (B.x - O.x);
    return val;
}

vector<Point> convex_hull(vector<Point> &pts)
{
    int n = pts.size();
    if (n == 1)
        return pts;
    sort(pts.begin(), pts.end());
    vector<Point> lower, upper;
    for (auto &p : pts)
    {
        while (lower.size() >= 2 && cross(lower[lower.size() - 2], lower[lower.size() - 1], p) <= 0)
        {
            lower.pop_back();
        }
        lower.push_back(p);
    }
    for (int i = n - 1; i >= 0; --i)
    {
        auto &p = pts[i];
        while (upper.size() >= 2 && cross(upper[upper.size() - 2], upper[upper.size() - 1], p) <= 0)
        {
            upper.pop_back();
        }
        upper.push_back(p);
    }
    lower.pop_back();
    upper.pop_back();
    vector<Point> hull;
    for (auto &p : lower)
        hull.push_back(p);
    for (auto &p : upper)
        hull.push_back(p);
    return hull;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int C;
    cin >> C;
    vector<Point> pts;
    pts.reserve(C);
    for (int i = 0; i < C; i++)
    {
        int x, y;
        cin >> x >> y;
        pts.push_back(Point{x, y});
    }
    sort(pts.begin(), pts.end(), [&](const Point &a, const Point &b) -> bool
         {
        if(a.x != b.x) return a.x < b.x;
        return a.y < b.y; });
    pts.erase(unique(pts.begin(), pts.end(), [&](const Point &a, const Point &b) -> bool
                     { return a.x == b.x && a.y == b.y; }),
              pts.end());
    int N = pts.size();
    if (N == 1)
    {
        cout << fixed << setprecision(6) << "0.0\n";
        return 0;
    }
    vector<Point> hull = convex_hull(pts);
    int M = hull.size();
    double max_dist_sq = 0.0;
    if (M == 1)
    {
        max_dist_sq = 0.0;
    }
    else
    {
        int j = 1;
        for (int i = 0; i < M; i++)
        {
            while (true)
            {
                int ni = (i + 1) % M;
                int nj = (j + 1) % M;
                ll cross_val = (ll)(hull[ni].x - hull[i].x) * (hull[nj].y - hull[j].y) -
                               (ll)(hull[ni].y - hull[i].y) * (hull[nj].x - hull[j].x);
                if (cross_val > 0)
                {
                    j = nj;
                }
                else
                {
                    break;
                }
            }
            ll dx = (ll)(hull[i].x - hull[j].x);
            ll dy = (ll)(hull[i].y - hull[j].y);
            double dist_sq = (double)(dx * dx + dy * dy);
            if (dist_sq > max_dist_sq)
            {
                max_dist_sq = dist_sq;
            }
        }
    }
    double max_dist = sqrt(max_dist_sq);
    cout << fixed << setprecision(10) << max_dist << "\n";
}