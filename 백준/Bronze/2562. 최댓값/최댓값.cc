#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int arr[10000];
	int MAX = 0;
	int index = 0;

	for (int i = 0; i < 9; i++) {
		cin >> arr[i];
		if (arr[i] > MAX) {
			MAX = arr[i];
			index = i;
		}
	}

	cout << MAX << endl << index + 1;
}