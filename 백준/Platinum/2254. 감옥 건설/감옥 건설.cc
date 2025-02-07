#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Point
{
    long long x, y;
};

Point prison;

bool cmpPoints(const Point &a, const Point &b)
{
    if (a.x == b.x)
        return a.y < b.y;
    return a.x < b.x;
}

long long cross(const Point &o, const Point &a, const Point &b)
{
    return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
}

vector<Point> convexHull(vector<Point> &pts)
{
    int n = pts.size();
    if (n < 3)
        return pts;
    vector<Point> hull;
    sort(pts.begin(), pts.end(), cmpPoints);

    for (int i = 0; i < n; i++)
    {
        while (hull.size() >= 2 && cross(hull[hull.size() - 2], hull[hull.size() - 1], pts[i]) <= 0)
            hull.pop_back();
        hull.push_back(pts[i]);
    }

    int lowerSize = hull.size();
    for (int i = n - 2; i >= 0; i--)
    {
        while (hull.size() > lowerSize && cross(hull[hull.size() - 2], hull[hull.size() - 1], pts[i]) <= 0)
            hull.pop_back();
        hull.push_back(pts[i]);
    }

    hull.pop_back();
    return hull;
}

bool pointInsidePolygon(const vector<Point> &poly, const Point &p)
{
    int m = poly.size();
    if (m < 3)
        return false;

    for (int i = 0; i < m; i++)
    {
        int next = (i + 1) % m;
        if (cross(poly[i], poly[next], p) <= 0)
        {
            return false;
        }
    }
    return true;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    long long Px, Py;
    cin >> N >> Px >> Py;
    prison = {Px, Py};

    vector<Point> pillars(N);
    for (int i = 0; i < N; i++)
    {
        cin >> pillars[i].x >> pillars[i].y;
    }

    int fenceCount = 0;

    while (pillars.size() >= 3)
    {

        vector<Point> hull = convexHull(pillars);

        if (!pointInsidePolygon(hull, prison))
            break;

        fenceCount++;

        vector<bool> used(pillars.size(), false);

        for (auto &h : hull)
        {

            for (int i = 0; i < pillars.size(); i++)
            {
                if (pillars[i].x == h.x && pillars[i].y == h.y)
                {
                    used[i] = true;
                }
            }
        }
        vector<Point> remaining;
        for (int i = 0; i < pillars.size(); i++)
        {
            if (!used[i])
                remaining.push_back(pillars[i]);
        }
        pillars = remaining;
    }

    cout << fenceCount << "\n";
    return 0;
}