#include <cstdio>
#include <queue>
#include <algorithm>
using namespace std;

#define MAX_N 26

int n;
int map[MAX_N][MAX_N];
int groups[MAX_N * MAX_N];
int dfs(int y, int x) {
	if (y < 0 || x < 0 || y >= n || x >= n || map[y][x] == 0) return 0;
	map[y][x] = 0;
	return 1 + dfs(y + 1, x) + dfs(y - 1, x)
		+ dfs(y, x + 1) + dfs(y, x - 1);
}
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		char line[MAX_N];
		scanf("%s", line);
		for (int j = 0; j < n; j++)
			map[i][j] = line[j] - '0';
	}

	int cnt = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (map[i][j] == 1) {
				groups[cnt] = dfs(i, j);
				cnt = cnt + 1;
			}


	printf("%d\n", cnt);
	sort(groups, groups + cnt);
	for (int i = 0; i < cnt; i++)
		printf("%d\n", groups[i]);

	return 0;
}