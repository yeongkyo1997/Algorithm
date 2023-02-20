#include <iostream>
#include <algorithm>

using namespace std;

struct Point {
	int x, y;
};

bool cmp(const Point &p1, const Point &p2){
    if(p1.y < p2.y) {
        return true;
    }
    else if(p1.y == p2.y) {
        return p1.x < p2.x;
    }
    else {
        return false;
    }
}

int main() {
	int n;
	Point p[100000];

	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> p[i].x >> p[i].y;

	sort(p, p + n, cmp);

	for (int i = 0; i < n; i++)
		cout << p[i].x << " " << p[i].y << "\n";
}