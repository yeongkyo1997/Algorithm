#include <iostream>
#include <vector>

using namespace std;

typedef struct Point {
	int x, y;
} Point;

int main() {
	Point *p;
	int size;

	cin >> size;
	p = new Point[size];

	for (int i = 0; i < size; i++) {
		cin >> p[i].x >> p[i].y;
		cout << "Case #" << i + 1 << ": " << p[i].x + p[i].y << endl;
	}
}