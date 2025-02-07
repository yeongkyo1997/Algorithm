#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

struct Point
{
    int x, y;
};

long long cross(const Point &O, const Point &A, const Point &B)
{
    return (long long)(A.x - O.x) * (B.y - O.y) - (long long)(A.y - O.y) * (B.x - O.x);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, L;
    cin >> N >> L;
    vector<Point> pts(N);
    for (int i = 0; i < N; i++)
    {
        cin >> pts[i].x >> pts[i].y;
    }

    sort(pts.begin(), pts.end(), [](const Point &a, const Point &b)
         {
        if(a.x == b.x)
            return a.y < b.y;
        return a.x < b.x; });

    vector<Point> hull;

    for (int i = 0; i < N; i++)
    {
        while (hull.size() >= 2 && cross(hull[hull.size() - 2], hull[hull.size() - 1], pts[i]) <= 0)
            hull.pop_back();
        hull.push_back(pts[i]);
    }

    for (int i = N - 2, t = hull.size() + 1; i >= 0; i--)
    {
        while (hull.size() >= t && cross(hull[hull.size() - 2], hull[hull.size() - 1], pts[i]) <= 0)
            hull.pop_back();
        hull.push_back(pts[i]);
    }

    hull.pop_back();

    double perimeter = 0.0;
    for (int i = 0; i < hull.size(); i++)
    {
        int j = (i + 1) % hull.size();
        double dx = hull[j].x - hull[i].x;
        double dy = hull[j].y - hull[i].y;
        perimeter += sqrt(dx * dx + dy * dy);
    }

    double result = perimeter + 2.0 * M_PI * L;

    cout << (long long)round(result) << "\n";

    return 0;
}