#include <bits/stdc++.h>
using namespace std;
typedef vector<int> v;
int DIRx[4] = { 1,-1,0,0 };
int DIRy[4] = { 0,0,1,-1 };
queue<v> q;
int D[26][26][26][26][26];
char state[7][7];
v star(5, 25);
int starIdx = 0;

int Dval(v tmp) {
	return D[tmp[0]][tmp[1]][tmp[2]][tmp[3]][tmp[4]];
}

int* Dval_ptr(v tmp) {
	return &D[tmp[0]][tmp[1]][tmp[2]][tmp[3]][tmp[4]];
}

int check(int x, int y) {
	return 0 > x || x >= 5 || 0 > y || y >= 5;
}

void recursion(vector<int>& move, int idx, int dir) {
	int addX = move[idx] / 5;
	int addY = move[idx] % 5;
	int curX = addX + DIRx[dir];
	int curY = addY + DIRy[dir];
	if (check(curX, curY) || find(move.begin(), move.end(), 5 * curX + curY) != move.end())
		return;

	if (move.size() == starIdx - 1) {
		vector<int> tmp(5, 25);
		int i = 0;
		for (; i < move.size(); i++)
			tmp[i] = move[i];
		tmp[i] = 5 * curX + curY;
		sort(tmp.begin(), tmp.end());
		if (Dval(tmp) == 0) {
			*Dval_ptr(tmp) = 1;
			q.push(tmp);
		}
		return;
	}
	move.push_back(5 * curX + curY);
	for (int i = 0; i < move.size(); i++) {
		for (int dir = 0; dir < 4; dir++)
			recursion(move, i, dir);
	}
	move.pop_back();
}

int main(void) {
	for (int i = 0; i < 5; i++)
		scanf("%s", state[i]);
	for (int i = 0; i < 5; i++)
		for (int j = 0; j < 5; j++)
			if (state[i][j] == '*') star[starIdx++] = 5 * i + j;
	if (starIdx == 1) {
		printf("0");
		return 0;
	}
	sort(star.begin(), star.end());

	for (int x = 0; x < 5; x++) {
		for (int y = 0; y < 5; y++) {
			vector<int> move;
			move.push_back(5 * x + y);
			for (int dir = 0; dir < 4; dir++)
				recursion(move, 0, dir);
		}
	}
	while (!q.empty()) {
		v cur = q.front();
		q.pop();
		int val = Dval(cur);
		for (int idx = 0; idx < starIdx; idx++) {
			for (int dir = 0; dir < 4; dir++) {
				v tmp = cur;
				int chX = tmp[idx] / 5 + DIRx[dir];
				int chY = tmp[idx] % 5 + DIRy[dir];
				if (check(chX, chY) || find(tmp.begin(), tmp.end(), 5 * chX + chY) != tmp.end()) continue;
				tmp[idx] = 5 * chX + chY;
				sort(tmp.begin(), tmp.end());
				if (Dval(tmp) == 0) {
					*Dval_ptr(tmp) = val + 1;
					q.push(tmp);
				}
			}
		}
	}
	printf("%d", Dval(star) - 1);
}