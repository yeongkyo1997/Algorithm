#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int t, n, m,k;
int d[111][111];
int f[111];

int main() {
	cin >> t;

	while (t--) {
		memset(f, 0, sizeof(f));
	
		for (int i = 0; i < 110; i++) {
			for (int j = 0; j < 110; j++) {
				d[i][j] = 1e+9;
			}
		}
		cin >> n >> m;

		for (int i = 0; i < m; i++) {
			int a, b, c;
			
			cin >> a >> b >> c;

			d[a][b] = d[b][a] = c;
		}
		for (int i = 1; i <= n; i++) 
			d[i][i] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (d[j][k] > d[j][i] + d[i][k]) 
						d[j][k] = d[j][i] + d[i][k];
				}
			}
		}
		cin >> k;

		for (int i = 0; i < k; i++)
			cin >> f[i];

		int ans = 1e+9;
		int pos = -1;

		for (int i = 1; i <= n; i++) {
			int temp = 0;
		
			for (int j = 0; j < k; j++) {
				temp += d[f[j]][i];
			}
			if (ans > temp) {
				ans = temp; pos = i;
			}
		}
		cout << pos << "\n";
	}
}