#include <iostream>
#include <algorithm>

using namespace std;

int arr[1000][4];
int n;
int rgb[1000][4];
int index = 0;

void distance() {
	rgb[0][1] = arr[0][1];
	rgb[0][2] = arr[0][2];
	rgb[0][3] = arr[0][3];

	for (int i = 1; i < n; i++) {
		for (int j = 1; j < 4; j++) {
			switch (j) {
			case 1:
				rgb[i][j] = min(rgb[i - 1][2], rgb[i - 1][3]) + arr[i][j];
				break;
				
			case 2:
				rgb[i][j] = min(rgb[i - 1][1], rgb[i - 1][3]) + arr[i][j];
				break;

			case 3:
				rgb[i][j] = min(rgb[i - 1][1], rgb[i - 1][2]) + arr[i][j];
				break;
			}
		}
	}
	cout << min(rgb[n - 1][1], min(rgb[n - 1][2], rgb[n - 1][3]));
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 1; j < 4; j++) {
			cin >> arr[i][j];
		}
	}

	distance();
}