#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

struct Point
{
    long long x, y;
};

bool comparePoints(const Point &p1, const Point &p2)
{
    if (p1.x == p2.x)
        return p1.y < p2.y;
    return p1.x < p2.x;
}

long long cross(const Point &O, const Point &A, const Point &B)
{
    return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
}

long long distSq(const Point &A, const Point &B)
{
    long long dx = A.x - B.x;
    long long dy = A.y - B.y;
    return dx * dx + dy * dy;
}

vector<Point> convexHull(vector<Point> &pts)
{
    int n = pts.size();
    if (n <= 1)
        return pts;

    sort(pts.begin(), pts.end(), comparePoints);

    vector<Point> lower, upper;

    for (int i = 0; i < n; i++)
    {
        while (lower.size() >= 2 && cross(lower[lower.size() - 2], lower[lower.size() - 1], pts[i]) <= 0)
        {
            lower.pop_back();
        }
        lower.push_back(pts[i]);
    }

    for (int i = n - 1; i >= 0; i--)
    {
        while (upper.size() >= 2 && cross(upper[upper.size() - 2], upper[upper.size() - 1], pts[i]) <= 0)
        {
            upper.pop_back();
        }
        upper.push_back(pts[i]);
    }

    lower.pop_back();
    upper.pop_back();

    vector<Point> hull;
    for (const auto &p : lower)
        hull.push_back(p);
    for (const auto &p : upper)
        hull.push_back(p);

    return hull;
}

long long rotatingCalipers(const vector<Point> &hull)
{
    int m = hull.size();
    if (m == 0)
        return 0;
    if (m == 1)
        return 0;
    if (m == 2)
        return distSq(hull[0], hull[1]);

    long long maxDist = 0;
    int j = 1;

    for (int i = 0; i < m; i++)
    {

        while (abs(cross(hull[i], hull[(i + 1) % m], hull[(j + 1) % m])) >
               abs(cross(hull[i], hull[(i + 1) % m], hull[j])))
        {
            j = (j + 1) % m;
        }

        maxDist = max(maxDist, distSq(hull[i], hull[j]));
        maxDist = max(maxDist, distSq(hull[(i + 1) % m], hull[j]));
    }

    return maxDist;
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

    vector<Point> hull = convexHull(points);

    long long answer = rotatingCalipers(hull);
    cout << answer << "\n";

    return 0;
}