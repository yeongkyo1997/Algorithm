#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

struct Point
{
    ll x, y;
};

bool cmp(const Point &a, const Point &b)
{
    if (a.x != b.x)
        return a.x < b.x;
    return a.y < b.y;
}

ll cross(const Point &O, const Point &A, const Point &B)
{
    return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
}

ll cross_product(const Point &A, const Point &B, const Point &C, const Point &D)
{
    ll dx1 = B.x - A.x;
    ll dy1 = B.y - A.y;
    ll dx2 = D.x - C.x;
    ll dy2 = D.y - C.y;
    return dx1 * dy2 - dy1 * dx2;
}

ll dist_sq(const Point &A, const Point &B)
{
    ll dx = A.x - B.x;
    ll dy = A.y - B.y;
    return dx * dx + dy * dy;
}

vector<Point> convex_hull(vector<Point> &pts)
{
    int n = pts.size();
    if (n <= 1)
    {
        return pts;
    }
    sort(pts.begin(), pts.end(), cmp);
    vector<Point> lower;
    for (auto &p : pts)
    {
        while (lower.size() >= 2 && cross(lower[lower.size() - 2], lower[lower.size() - 1], p) <= 0)
        {
            lower.pop_back();
        }
        lower.push_back(p);
    }
    vector<Point> upper;
    for (int i = n - 1; i >= 0; i--)
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
    lower.insert(lower.end(), upper.begin(), upper.end());
    return lower;
}

pair<Point, Point> max_distance_pair(const vector<Point> &hull)
{
    int m = hull.size();
    if (m == 1)
    {

        return {hull[0], hull[0]};
    }
    if (m == 2)
    {

        return {hull[0], hull[1]};
    }
    ll max_dsq = 0;
    pair<Point, Point> res = {hull[0], hull[1]};
    int j = 1;
    for (int i = 0; i < m; i++)
    {
        int ni = (i + 1) % m;

        while (true)
        {
            int nj = (j + 1) % m;
            ll cross_val = cross_product(hull[i], hull[ni], hull[j], hull[nj]);
            if (cross_val > 0)
            {
                j = nj;
            }
            else
            {
                break;
            }
        }

        ll d_sq = dist_sq(hull[i], hull[j]);
        if (d_sq > max_dsq)
        {
            max_dsq = d_sq;
            res = {hull[i], hull[j]};
        }
    }
    return res;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int T;
    cin >> T;
    while (T--)
    {
        int n;
        cin >> n;
        vector<Point> pts(n);
        for (int i = 0; i < n; i++)
        {
            cin >> pts[i].x >> pts[i].y;
        }

        vector<Point> hull = convex_hull(pts);

        pair<Point, Point> farthest = max_distance_pair(hull);
        cout << farthest.first.x << " " << farthest.first.y << " " << farthest.second.x << " " << farthest.second.y << "\n";
    }
}