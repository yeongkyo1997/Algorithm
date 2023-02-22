#include <cstdio>
#include <cmath>
#include <vector>
#include <algorithm>
#include <utility>
#include <iostream>

using namespace std;

int main() {
	int robotNum;
	cin >> robotNum;

	vector<pair<double, int>> v;

	for (int i = 1; i <= robotNum; i++) {
		int x, y, speed;
		cin >> x;
		cin >> y;
		cin >> speed;

		double distance = sqrt(pow(x, 2.) + pow(y, 2.));
		double time = distance / (double)speed;

		pair<double, int> timePair = make_pair(time, i);
		v.push_back(timePair);
	}
	sort(v.begin(), v.end());
	
	for (int i = 0; i < robotNum; i++) {
		cout << v[i].second << "\n";
	}
}