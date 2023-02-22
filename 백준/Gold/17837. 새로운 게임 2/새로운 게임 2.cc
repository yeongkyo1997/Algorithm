#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, k;
int table[12][12];

vector<int> order[12][12];

struct g {
	int y;
	int x;
	int d;
};

const int dy[4] = { 0,0,-1,1 };
const int dx[4] = { 1,-1,0,0};

int main() {
	vector<g> v;

	cin >> n >> k;

	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
			cin >> table[i][j];

	for (int i = 0; i < k; ++i) {
		int y, x, d;

		cin >> y >> x >> d;

		y -= 1; x -= 1; d -= 1;
		order[y][x].push_back(i);
		g temp = { y, x, d };
		v.push_back(temp);

	}

	int turn = 0;
	while (1) {

		if (turn > 1000) break;

		turn++;
		for (int i = 0; i < k; ++i) {
			int y = v[i].y; int x = v[i].x;

			int ny = y + dy[v[i].d];
			int nx = x + dx[v[i].d];


			if (!(0 <= ny && ny < n && 0 <= nx && nx < n) || table[ny][nx] == 2) {
				if (v[i].d == 0)
					v[i].d = 1;
				else if (v[i].d == 1)
					v[i].d = 0;
				else if (v[i].d == 2)
					v[i].d = 3;
				else if (v[i].d == 3)
					v[i].d = 2;

				ny = y + dy[v[i].d];
				nx = x + dx[v[i].d];
			}

			if (!(0 <= ny && ny < n && 0 <= nx && nx < n) || table[ny][nx] == 2) 
				continue;

			else if (table[ny][nx] == 0) {
				int idx = -1;

				for (int j = 0; j < order[y][x].size(); ++j) {
					int cand = order[y][x][j];
					
					if (cand == i) {
						idx = j;
					}

					if (idx == -1) 
						continue;

					v[cand].y = ny;
					v[cand].x = nx;

					order[ny][nx].push_back(cand);

					if (order[ny][nx].size() >= 4) {
						cout << turn << "\n";
						return 0;
					}
				}

				int cnt = order[y][x].size();

				for (int j = idx; j < cnt; ++j)
					order[y][x].pop_back();
			}

			else {
				int idx = -1;

				for (int j = order[y][x].size() - 1; j >= 0; --j) {
					int cand = order[y][x][j];
					
					if (cand == i) {
						idx = j;
						break;
					}
				}

				for (int j = order[y][x].size() - 1; j >= idx; --j) {
					int cand = order[y][x][j];

					v[cand].y = ny;
					v[cand].x = nx;

					order[ny][nx].push_back(cand);

					if (order[ny][nx].size() >= 4) {
						cout << turn << "\n";
						return 0;
					}
				}
				int cnt = order[y][x].size();
				for (int j = idx; j < cnt; ++j)
					order[y][x].pop_back();
			}
		}
	}
	cout << -1 << "\n";
	return 0;
}