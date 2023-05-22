#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <cmath>

class Point {
public:
    int x;
    int y;

    Point(int x, int y) : x(x), y(y) {}

    bool operator<(const Point& other) const {
        return (y == other.y) ? (x < other.x) : (y < other.y);
    }
};

int dist(const Point& o1, const Point& o2) {
    return (o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y);
}

int main() {
    int n;
    std::cin >> n;

    std::vector<Point> points;

    for (int i = 0; i < n; ++i) {
        int x, y;
        std::cin >> x >> y;
        points.emplace_back(x, y);
    }

    sort(points.begin(), points.end(), [](const Point& p1, const Point& p2) {
        return p1.x < p2.x;
    });

    std::set<Point> set_pairs(points.begin(), points.begin() + 2);
    int min_dist = dist(points[0], points[1]);
    int lowest_idx = 0;

    for (int i = 2; i < n; ++i) {
        Point bench_point = points[i];

        while (lowest_idx < i) {
            Point target_point = points[lowest_idx];
            int x_dist = bench_point.x - target_point.x;

            if (x_dist * x_dist > min_dist) {
                set_pairs.erase(target_point);
                ++lowest_idx;
            }
            else {
                break;
            }
        }

        int sqrt_min_dist = static_cast<int>(std::sqrt(min_dist)) + 1;
        auto lb = set_pairs.lower_bound(Point(-100000, bench_point.y - sqrt_min_dist));
        auto ub = set_pairs.upper_bound(Point(100000, bench_point.y + sqrt_min_dist));

        for (auto it = lb; it != ub; ++it) {
            min_dist = std::min(min_dist, dist(bench_point, *it));
        }

        set_pairs.insert(bench_point);
    }

    std::cout << min_dist << std::endl;

    return 0;
}