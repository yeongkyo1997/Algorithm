#include <iostream>
#include <cstring>
#define MAP_SIZE 101

using namespace std;

int map[MAP_SIZE][MAP_SIZE];
int ans[MAP_SIZE][MAP_SIZE];
bool visited[MAP_SIZE][MAP_SIZE];
int N;


void input() {
	cin >> N;
	for (int r = 0; r < N; r++) {
		for (int c = 0; c < N; c++) {
			cin >> map[r][c];
		}
	}
}

void DFS(int target, int r) {
	for (int c = 0; c < N; c++) {
		if (map[r][c] == 1 && visited[r][c] == false) {
			ans[target][c] = 1;
			visited[r][c] = true;
			DFS(target, c);
		}
	}
}

void output() {
	for (int r = 0; r < N; r++) {
		for (int c = 0; c < N; c++) {
			cout << ans[r][c] << ' ';
		}
		cout << endl;
	}
}


int main() {
	input();
	for (int r = 0; r < N; r++) {
		memset(visited, false, sizeof(visited));
		DFS(r, r);
	}
	output();
}