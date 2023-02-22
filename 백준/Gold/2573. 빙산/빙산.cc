#include<cstdio>


using namespace std;

int n, m;
int Height[300][300];
bool IsIce[300][300];

int Adj[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };


void dfs(int i, int j) {
	if (IsIce[i][j]) {
		IsIce[i][j] = false;
		for (int k = 0; k < 4; k++)
			dfs(i + Adj[k][0], j + Adj[k][1]);
	}
}


int num_iceberg(void) {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			IsIce[i][j] = Height[i][j] > 0 ? true : false;

	int cnt = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (IsIce[i][j]) {
				cnt++;
				dfs(i, j);
			}

	return cnt;
}


void melt(void) {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (Height[i][j] > 0)
				for (int k = 0; k < 4; k++)
					if (Height[i][j] > 0 && Height[i + Adj[k][0]][j + Adj[k][1]] == -1)
						Height[i][j]--;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (Height[i][j] == 0)
				Height[i][j] = -1;
}


int main(void) {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++) {
			scanf("%d", &Height[i][j]);
			if (Height[i][j] == 0)
				Height[i][j] = -1;
		}

	int y = 0, ni;
	while ((ni = num_iceberg()) == 1) {
		melt();
		y++;
	}
	printf("%d", ni > 1 ? y : 0);

	return 0;
}