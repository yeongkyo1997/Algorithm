#include <bits/stdc++.h>
using namespace std;

priority_queue <pair<int, char>, vector <pair<int, char>>, greater<pair<int, char>>> pq;

int main(void) {
	int a, b, n;
	cin >> a >> b >> n;
	int maxR = -1, maxB = -1;

	for (int i = 0; i < n; i++) {
		int t, m; 
		char ch;
		cin >> t >> ch >> m;
		int cnt = 0;
		if (ch == 'B') {
			if (maxB > t) t = maxB;
			for (int j = t; cnt < m; j += a) {
				pq.push(make_pair(j, ch));
				cnt += 1;
			}
			maxB = t + m * a;
		}
		else {
			if (maxR > t) t = maxR;
			for (int j = t; cnt < m; j += b) {
				pq.push(make_pair(j, ch));
				cnt += 1;
			}
			maxR = t + m * b;
		}
	}

	vector<int> v1, v2;
	int idx = 1;
	while (!pq.empty()) {
		char c = pq.top().second;
		if (c == 'B') {
			v1.push_back(idx++);
		}
		else {
			v2.push_back(idx++);
		}
		pq.pop();
	}

	cout << v1.size() << '\n';
	for (int i = 0; i < v1.size(); i++) {
		cout << v1[i] << ' ';
	}
	cout << '\n';

	cout << v2.size() << '\n';
	for (int i = 0; i < v2.size(); i++) {
		cout << v2[i] << ' ';
	}
	cout << '\n';

	return 0;
}