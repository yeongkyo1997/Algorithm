#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>
#include <cmath>
#include <climits> 
using namespace std;

struct Point {
	long x, y;
	Point(long x = 0, long y = 0) : x(x), y(y) {}
};

Point root(LLONG_MAX, LLONG_MAX);

long dist(Point p1, Point p2) {
	return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
}

int ccw(Point p1, Point p2, Point p3) {
	long result = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p2.x * p1.y - p3.x * p2.y - p1.x * p3.y;
	if (result > 0)	return 1;
	else if (result < 0) return -1;
	else return 0;
}

bool cmp(Point p1, Point p2) {
	int result = ccw(root, p1, p2);
	if (result > 0) return true;
	else if (result < 0) return false;
	else return dist(root, p1) < dist(root, p2);
}

int grahamScan(vector<Point>& points) {
	for (Point& p : points) {
		if (p.y < root.y || (p.y == root.y && p.x < root.x)) {
			root = p;
		}
	}
	sort(points.begin(), points.end(), cmp);

	vector<Point> stack;
	stack.push_back(root);

	for (int i = 1; i < points.size(); ++i) {
		while (stack.size() > 1 && ccw(stack.end()[-2], stack.back(), points[i]) <= 0) {
			stack.pop_back();
		}
		stack.push_back(points[i]);
	}

	return stack.size();
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;
	cin >> N;

	vector<Point> points(N);
	for (int i = 0; i < N; ++i) {
		cin >> points[i].x >> points[i].y;
	}

	cout << grahamScan(points) << '\n';
	return 0;
}