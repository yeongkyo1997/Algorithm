#include <bits/stdc++.h>
#define MAX_SIZE 1000
using namespace std;

int main() {
	int n; scanf("%d", &n);
	int px = -1, py = -1, sx = -1, sy = -1, cnt = 0;
	int** arr = new int* [n];
	for (int i = 0; i < n; i++) {
		arr[i] = new int[n];
	}
	bool ex = false;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == 2) {
				sx = i;
				sy = j;
			}
			else if (arr[i][j] == 5) {
				px = i;
				py = j;
			}
		}
	}

	for (int i = min(px, sx); i <= max(px, sx) && !ex; i++) {
		for (int j = min(py, sy); j <= max(py, sy); j++) {
			if (arr[i][j] == 1)
				cnt++;
			if (cnt >= 3) {
				if ((px - sx) * (px - sx) + (py - sy) * (py - sy) >= 25)
					ex = true;
				break;
			}
		}
	}
	printf("%d", (int)ex);
}