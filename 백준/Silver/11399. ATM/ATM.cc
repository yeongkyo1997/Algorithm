#include <iostream>
#include <algorithm>

int main() {
	int N;
	scanf("%d", &N);
	int* arr = new int[N];

	for (int i = 0; i < N; ++i) {
		scanf("%d", arr + i);
	}

	std::sort(arr, arr + N);

	int time = 0;
	for (int i = 0; i < N; ++i) time += (N - i) * arr[i];

	printf("%d\n", time);

	delete[] arr;

	return 0;
}