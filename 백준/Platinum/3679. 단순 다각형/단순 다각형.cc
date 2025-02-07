#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

struct Point
{
    int x, y;
};

double angleFromCenter(const Point &p, double cx, double cy)
{
    return atan2(p.y - cy, p.x - cx);
}

bool onSegment(const Point &A, const Point &B, const Point &C)
{
    return (min(A.x, B.x) <= C.x && C.x <= max(A.x, B.x) &&
            min(A.y, B.y) <= C.y && C.y <= max(A.y, B.y));
}

long long cross(const Point &A, const Point &B, const Point &C)
{
    return (long long)(B.x - A.x) * (C.y - A.y) - (long long)(B.y - A.y) * (C.x - A.x);
}

bool segmentsIntersect(const Point &A, const Point &B, const Point &C, const Point &D)
{
    auto orientation = [&](const Point &P, const Point &Q, const Point &R) -> int
    {
        long long val = cross(P, Q, R);
        if (val > 0)
            return 1;
        if (val < 0)
            return -1;
        return 0;
    };
    int o1 = orientation(A, B, C);
    int o2 = orientation(A, B, D);
    int o3 = orientation(C, D, A);
    int o4 = orientation(C, D, B);

    if (o1 != o2 && o3 != o4)
        return true;

    if (o1 == 0 && onSegment(A, B, C))
        return true;
    if (o2 == 0 && onSegment(A, B, D))
        return true;
    if (o3 == 0 && onSegment(C, D, A))
        return true;
    if (o4 == 0 && onSegment(C, D, B))
        return true;
    return false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

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

        long long sumX = 0, sumY = 0;
        for (int i = 0; i < n; i++)
        {
            sumX += pts[i].x;
            sumY += pts[i].y;
        }
        double cx = (double)sumX / n;
        double cy = (double)sumY / n;

        vector<int> order(n);
        for (int i = 0; i < n; i++)
        {
            order[i] = i;
        }
        sort(order.begin(), order.end(), [&](int i, int j)
             { return angleFromCenter(pts[i], cx, cy) < angleFromCenter(pts[j], cx, cy); });

        bool improved = true;
        while (improved)
        {
            improved = false;

            for (int i = 0; i < n; i++)
            {
                int i_next = (i + 1) % n;
                for (int j = i + 2; j < n; j++)
                {
                    int j_next = (j + 1) % n;

                    continue;
                    if (i_next == j)
                        continue;
                    if (j_next == i)
                        continue;

                    Point A = pts[order[i]];
                    Point B = pts[order[i_next]];
                    Point C = pts[order[j]];
                    Point D = pts[order[j_next]];

                    if (segmentsIntersect(A, B, C, D))
                    {

                        reverse(order.begin() + i + 1, order.begin() + j + 1);
                        improved = true;
                        goto restart;
                    }
                }
            }
        restart:;
        }

        for (int i = 0; i < n; i++)
        {
            cout << order[i] << (i == n - 1 ? "\n" : " ");
        }
    }
    return 0;
}