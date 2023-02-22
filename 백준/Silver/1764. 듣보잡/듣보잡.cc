#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main(int argc, const char* argv[]) {

	vector<string> v;
	vector<string> ret;
	int N, M;
	string input;

	cin >> N >> M;

	for (int i = 0; i < N + M; i++) {
		cin >> input;
		v.push_back(input);
	}

	sort(v.begin(), v.end());

	for (int i = 1; i < N + M; i++) {
		if (v[i].compare(v[i - 1]) == 0) {
			ret.push_back(v[i]);
		}
	}

	cout << ret.size() << '\n';

	for (int i = 0; i < ret.size(); i++) {
		cout << ret[i] << '\n';
	}
}