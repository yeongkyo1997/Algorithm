#include <iostream>
#include <cstring>
#include <queue>

#define end '\n'

using namespace std;

struct color {
	int x, y;
};

int n;
char a[101][101];
bool check[101][101];
const int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, 1, 0, -1 };

void bfs(int i, int j, char c, bool w) {
	queue<color> q;
	q.push({ i, j });
	check[i][j] = true;

	while (!q.empty()) {
		int x = q.front().x, y = q.front().y;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if (check[nx][ny])
				continue;

			if (!w && a[nx][ny] != c)
				continue;

			if (w && (a[nx][ny] == 'R' && c == 'B'))
				continue;

			if (w && (a[nx][ny] == 'G' && c == 'B'))
				continue;

			if (w && (a[nx][ny] == 'B' && c != 'B'))
				continue;

			q.push({ nx, ny });
			check[nx][ny] = true;
		}
	}
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	int cnt = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] == false) {
				bfs(i, j, a[i][j], false);
				cnt++;
			}
		}
	}
	cout << cnt << ' ';
	cnt = 0;

	memset(check, false, sizeof(check));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] == false) {
				bfs(i, j, a[i][j], true);
				cnt++;
			}
		}
	}
	cout << cnt << endl;
	return 0;
}