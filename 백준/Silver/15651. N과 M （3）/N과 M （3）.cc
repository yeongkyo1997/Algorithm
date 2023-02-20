#include <iostream>

using namespace std;

int arr[8];

int N, M;

void print(int m) {
	if (m == M) {
		for (int j = 0; j < M; j++) {
			cout << arr[j] << " ";
		}
		cout << "\n";
	}
	else {
		for (int i = 1; i <= N; i++) {
			arr[m] = i;
			print(m + 1);
			arr[m] = 0;
		}

	}
}

int main() {
	cin >> N >> M;

	print(0);
}