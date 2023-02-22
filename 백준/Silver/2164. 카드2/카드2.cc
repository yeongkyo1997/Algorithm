#include<iostream>
#include<queue>

#define endl "\n"
using namespace std;

int N;
queue<int> Q;

void Input() {
	cin >> N;
	for (int i = 1; i <= N; i++)
	{
		Q.push(i);
	}

	if (Q.size() == 1)
	{
		cout << 1 << endl;
		exit(0);
	}
}

void Solution() {
	int Remainder;
	while (1) {
		Q.pop();
		if (Q.size() == 1) {
			Remainder = Q.front();
			break;
		}

		Q.push(Q.front());
		Q.pop();
	}

	cout << Remainder << endl;
}

void Solve() {
	Input();
	Solution();
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	Solve();
}