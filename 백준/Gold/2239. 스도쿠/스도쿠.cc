#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

int sudoku[9][9];
vector<pair<int, int>> arr;

void input(int sudoku[9][9]) {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			scanf("%1d", &sudoku[i][j]);
			if (sudoku[i][j] == 0)
				arr.push_back({ i, j });
		}
	}
}

void show() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cout << sudoku[i][j];
		}
		cout << endl;
	}
}

bool checkRow(int c, int num) {
	for (int i = 0; i < 9; i++) {
		if (sudoku[i][c] == num)
			return false;
	}
	return true;
}

bool checkCol(int r, int num) {
	for (int i = 0; i < 9; i++) {
		if (sudoku[r][i] == num)
			return false;
	}
	return true;
}

bool checkBlock(int r, int c, int num) {
	int rr = (r / 3) * 3;
	int cc = (c / 3) * 3;
	for (int i = rr; i < rr + 3; i++) {
		for (int j = cc; j < cc + 3; j++) {
			if (sudoku[i][j] == num)
				return false;
		}
	}
	return true;
}

bool checkAll(int r, int c, int num) {
	if (checkRow(c, num) && checkCol(r, num) && checkBlock(r, c, num)) {
		return true;
	}
	else return false;
}

bool backtraking(int n) {
	if (n == arr.size()) {
		if (sudoku[arr[n - 1].first][arr[n - 1].second] == 0)
			return false;
		else {
			show();
			exit(0);
			return true;
		}
	}
	else {
		for (int i = 1; i <= 9; i++) {
			if (checkAll(arr[n].first, arr[n].second, i)) {
				sudoku[arr[n].first][arr[n].second] = i;
				backtraking(n + 1);
				sudoku[arr[n].first][arr[n].second] = 0;
			}
		}
	}
}

int main() {
	input(sudoku);
	for (int i = 1; i <= 9; i++) {
		if (checkAll(arr[0].first, arr[0].second, i)) {
			sudoku[arr[0].first][arr[0].second] = i;
			if (backtraking(1) == false)
				continue;
		}
	}
}