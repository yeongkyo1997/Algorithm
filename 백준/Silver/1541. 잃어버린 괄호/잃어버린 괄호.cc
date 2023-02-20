#include<iostream>
#include <string>
using namespace std;

int arr[1000];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	string s;
	cin >> s;

	int num = 0;
	int ans = 0;
	int flag = 1;

	for (char c : s) {
		if (c == '+') {
			ans += num;
			num = 0;
		}
		else if (c == '-') {
			flag = -1;
			ans += num;

			num = 0;
		}
		else {
			num = num * 10 + (c - '0') * flag;
		}
	}

	ans += num;

	cout << ans << '\n';
}