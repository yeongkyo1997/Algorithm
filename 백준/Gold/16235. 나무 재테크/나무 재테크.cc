#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int n, m, k, ans, e[11][11], remain[11][11];

deque <int> que[11][11]; 

int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1}; 

int main(void) {
	ios::sync_with_stdio(false);
	cin >> n >> m >> k; 
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> e[i][j];

	for (int i = 0; i < m; i++) {
		int a, b, c;

		cin >> a >> b >> c;

		que[a-1][b-1].push_back(c);
	}

	for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++) {
			remain[i][j] = 5;
			sort(que[i][j].begin(), que[i][j].end());
		} while (k--) { // 봄 & 여름 

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int p = 0; p < que[i][j].size(); p++) {
						if (que[i][j][p] <= remain[i][j]) {
							remain[i][j] -= que[i][j][p]; 
							que[i][j][p]++; 
						}
						else {
							while (p < que[i][j].size()) {
								remain[i][j] += (que[i][j].back() / 2); 
								que[i][j].pop_back();
							}
							break; 
						} 
					}
				}
			}

			// 가을 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int p = 0; p < que[i][j].size(); p++) {
						if (que[i][j][p] % 5 == 0) {
							for (int r = 0; r < 8; r++) {
								int nx = i + dx[r];
								int ny = j + dy[r]; 
								if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
									que[nx][ny].push_front(1);
								}
							}
						}
					}
				}
			}
			// 겨울 
			for (int i = 0; i < n;i++) {
				for (int j = 0; j < n; j++) {
					remain[i][j] += e[i][j];
				}
			}
		}
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				ans += que[i][j].size();
		cout << ans << "\n";
}

