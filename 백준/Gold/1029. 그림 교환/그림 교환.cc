#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int D[1 << 15][17];
int N;
char price[17][17];

int vec2i(vector<int> V) {
	int a = 0;
	for (auto val : V) {
		a = ((a << 1) | val);
	}
	return a;
}
int bit(int i) {
	return 1 << (N - 1 - i);
}
int main(void) {
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> price[i];

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			price[i][j] -= '0';

	for (int i = 0; i < (1 << N); i++)
		for (int j = 0; j < N; j++)
			D[i][j] = 0x7ffff;
	D[bit(0)][0] = 0;

	int ans = 1;

	for (int buyer = 2; buyer <= N; buyer++) {
		vector<int> tmp(N);
		for (int i = N - buyer; i < N; i++)
			tmp[i] = 1;
		do {
			int bitmask1 = vec2i(tmp);
			for (int i = 0; i < N; i++) {
				if (tmp[i] == 1) {

					int bitmask2 = bitmask1 - bit(i);
					for (int lst = 0; lst < N; lst++) {
						if (lst == i)
							continue;
						if (D[bitmask2][lst] <= price[lst][i] && price[lst][i] < D[bitmask1][i]) {
							D[bitmask1][i] = price[lst][i];
							ans = buyer;
						}
					}
				}
			}
		} while (next_permutation(tmp.begin(), tmp.end()));
	}
	cout << ans;
}