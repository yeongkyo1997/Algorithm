#include <iostream>
#include <algorithm>
#include <vector>
#include <functional>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	int num, legnth;
	cin >> num >> legnth;
	vector<int> arr(num);
	for (int i = 0; i < num; i++)
		cin >> arr[i];

	sort(arr.begin(), arr.end(), greater<int>());

	int sum = 0;
	int result = arr.front() - 1;
	int ptr = 0;

	while (true) {
		while (arr[ptr] - result > 0)
			sum += arr[ptr++] - result;
		if (sum < legnth) {
			result--;
			sum += ptr;
		}
		else {
			break;
		}
	}
	cout << result;

	return 0;
}