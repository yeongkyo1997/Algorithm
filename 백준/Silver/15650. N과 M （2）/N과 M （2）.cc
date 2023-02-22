#include <iostream>

using namespace std;

int arr[8];

int N, M;

void print(int m) {
	if (m == M) {
		for (int j = 0; j < M; j++) {
			cout << arr[j] << " ";
		}
		cout << endl;
	}
	else {
		for (int i = 1; i <= N; i++) {
			if (m != 0) {
				if (arr[m - 1] < i) {
					arr[m] = i;
					print(m + 1);
					arr[m] = 0;
				}
			}
			else {
				arr[m] = i;
				print(m + 1);
				arr[m] = 0;
			}

		}
	}
}

int main() {
	cin >> N >> M;

	print(0);
}