#include <iostream>
#include <algorithm>

using namespace std;

int arr[10];
int size;
int MAX = 0; // 최대 벚꽃 개수
int sum = 0; // 현재 벚꽃 개수
int level = 0; // 현재 단계

int cal(int list[], int left, int right) {
	int ret = 1;

	for (int i = left; i <= right; i++) {
		ret *= list[i];
	}
	return ret;
}

void dfs(int num) {
	if (num < size) {
		if (level < 3) {
			for (int i = num; i < size - 3 + level; i++) {
				int result = cal(arr, num, i);

				sum += result;
				MAX = max(sum, MAX);
				level++;

				dfs(i + 1);

				level--;
				sum -= result;
			}
		}
		else {
			int result = cal(arr, num, size - 1);
			sum += result;
			MAX = max(sum, MAX);
			sum -= result;
		}
	}

}

int main() {
	cin >> size;
	for (int i = 0; i < size; i++)
		cin >> arr[i];
	dfs(0);
	cout << MAX;
}