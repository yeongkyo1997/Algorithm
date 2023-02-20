#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <utility>
#include <functional>
#include <iomanip>
#include <string.h>
#include <string>
#include <tuple>
#include <string.h>
#include <math.h>
#include <map>
#include <algorithm>
using namespace std;

int n, arr[26], result;
string a;
vector<string> word;
void func(int cur, int pos, int cur_sum, int sum, int visit) {
	if (cur == word.size()) {
		result = max(result, sum);
		return;
	}
	if (pos == word[cur].size()) {
		func(cur + 1, 0, 0, sum + cur_sum, visit);
		return;
	}

	if (arr[word[cur][pos] - 'A'] == -1) {
		for (int i = 0; i <= 9; i++) {
			if (visit & (1 << i)) continue;
			arr[word[cur][pos] - 'A'] = i;
			func(cur, pos + 1, cur_sum * 10 + arr[word[cur][pos] - 'A'], sum, visit | (1 << i));
			arr[word[cur][pos] - 'A'] = -1;
		}
	}
	else {
		func(cur, pos + 1, cur_sum * 10 + arr[word[cur][pos] - 'A'], sum, visit);
	}

}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	cin >> n;
	memset(arr, -1, sizeof(arr));

	while (n--) {
		cin >> a;
		word.push_back(a);
	}
	func(0, 0, 0, 0, 0);
	cout << result;

	return 0;
}