#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

	int n, m, i, temp;

	scanf("%d", &n);

	vector<int> v;
	vector<int>::iterator low;
	vector<int>::iterator high;

	for (i = 0; i < n; i++) {
		scanf("%d", &temp);
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	scanf("%d", &m);

	for (i = 0; i < m; i++) {
		scanf("%d", &temp);
		low = lower_bound(v.begin(), v.end(), temp);
		high = lower_bound(v.begin(), v.end(), temp + 1);

		printf("%ld ", high - low);
	}

	printf("\n");

	return 0;
}