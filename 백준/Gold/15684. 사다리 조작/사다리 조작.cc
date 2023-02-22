#include<iostream>
using namespace std;
bool a[31][11]; int n, m, h, Ladder;    bool res;
bool Count_Ladder() {
	for (int i = 1; i <= n; i++) { // 세로선 번호  // i는 반복문 시작전 최초의 시작점, pt는 변경될 시작점
		int pt = i;
		for (int j = 1; j <= h; j++) {
			if (a[j][pt]) pt += 1;   // 오른쪽으로 이동
			else if (pt - 1 > 0 && a[j][pt - 1]) pt -= 1; // 왼쪽으로 이동 
		}
		if (i == pt) continue;
		else
			return false;
	}
	res = true;
	return true;
}

void dfs(int x, int cnt) {
	if (res) return;
	if (cnt == Ladder) {
		if (Count_Ladder())  m = cnt;
		return;
	}
	for (int i = x; i <= h; i++) {   // 기존 행에 사다리를 놓았다면 해당 행과 같거나 더 커야한다.
									 // 사다리가 역주행해서 위로 올라갈순 없으니...
		for (int j = 1; j < n; j++) {
			if (!a[i][j]) {
				if (!a[i][j - 1] && !a[i][j + 1]) { // 연속되지 않은 가로선 
					a[i][j] = 1;
					dfs(i, cnt + 1);
					a[i][j] = 0;
				}
			}
		}
	}
	return;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m >> h;
	while (m--) {
		int x, y; cin >> x >> y;
		a[x][y] = 1;
	}
	for (int i = 0; i <= 3; i++) {
		Ladder = i;
		dfs(1, 0);
		if (res) break;
	}
	if (!res) cout << -1 << '\n';
	else cout << m << '\n';
	return 0;
}