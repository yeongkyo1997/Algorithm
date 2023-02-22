#include <iostream>

#include <vector>

#include <queue>

using namespace std;



int adj[50][50];

int dy[4] = { -1,1,0,0 };

int dx[4] = { 0, 0, 1,-1 };

int R, C, T;

// 공기 청정기 좌표

int upX, upY, downX, downY;

// 반시계, 시계 방향

int rc[4] = { 2,0,3,1 };

int c[4] = { 2,1,3,0 };



void Copy(int Copyadj[50][50]) {

	for (int i = 0; i < R; ++i)
		for (int j = 0; j < C; ++j) {
			Copyadj[i][j] = adj[i][j];
		}
}

int solve() {

	for (int t = 0; t < T; ++t) {
		int Copyadj[50][50];
		
		//복사한 배열

		Copy(Copyadj);
		
		queue<pair<int, int>> q;
		
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j) {
				
				if (adj[i][j] != 0 && adj[i][j] != -1) {
					q.push(make_pair(i, j));
				}
			}
			while (!q.empty()) {
				int y = q.front().first;
				
				int x = q.front().second;
				
				int push = Copyadj[y][x] / 5;
				
				q.pop();
				
				for (int i = 0; i < 4; ++i) {
					int ny = y + dy[i];
					
					int nx = x + dx[i];
					
					if (ny >= 0 && nx >= 0 && ny < R && nx < C && Copyadj[ny][nx] != -1) {
						adj[ny][nx] += push;
						adj[y][x] -= push;
					}
				}
			}
			
			//복사한 배열
			
			Copy(Copyadj);
			
			int y = upY;
			int x = upX + 1;
			//반시계 공기청정 처리
			
			adj[y][x] = 0;
			for (int i = 0; i < 4; ++i) {
				while (1) {
					
					// 오른쪽,위쪽,왼쪽,아래
					int ny = y + dy[rc[i]];
					
					int nx = x + dx[rc[i]];
					
					if (ny == upY && nx == upX)
						break;
					
					if (ny < 0 || nx < 0 || ny >= R || nx >= C)
						break;
					
					adj[ny][nx] = Copyadj[y][x];
					y = ny;
					x = nx;
				}
			}
			
			y = downY;
			
			x = downX + 1;
			
			adj[y][x] = 0;
			
			//시계 공기청정 처리 
			for (int i = 0; i < 4; ++i) {
				
				while (1) {
					// 오른쪽, 아래 , 왼쪽 , 위
					int ny = y + dy[c[i]];
					int nx = x + dx[c[i]];
					
					if (ny == downY && nx == downX)
						break;
					
					if (ny < 0 || nx < 0 || ny >= R || nx >= C)
						break;
					
					adj[ny][nx] = Copyadj[y][x];
					y = ny;
					x = nx;
				}
			}
	}

	int ret = 0;
	for (int i = 0; i < R; ++i)
		for (int j = 0; j < C; ++j)
			if (adj[i][j] >= 1)
				ret += adj[i][j];
	return ret;
}

int main() {
	cin >> R >> C >> T;

	bool temp = false;

	for (int i = 0; i < R; ++i)
		for (int j = 0; j < C; ++j) {
			cin >> adj[i][j];
			
			if (adj[i][j] == -1) {
				if (!temp) {
					upY = i;

					upX = j;

					temp = true;
				}
				else {
					downY = i;
					downX = j;
				}
			}
		}
		
		cout << solve() << "\n";
		return 0;
}