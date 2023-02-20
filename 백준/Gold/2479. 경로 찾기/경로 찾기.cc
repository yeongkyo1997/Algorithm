#include<iostream>
#include<string>
#include<map>
#include<queue>

using namespace std;

int N, K, a, b;
string s[1002], visit[1002];
map<string, int> m;
queue<int> q;


string bfs() {
	q.push(a);
	visit[a] = to_string(a);
	while (!q.empty()) {
		int t = q.front(); q.pop();
		if (t == b) return visit[t];
		string ts = s[t];
		for (int i = 0; i < K; i++) {
			ts[i] = ts[i] == '0' ? '1' : '0';
			if (m.find(ts) != m.end()) {
				int idx = m[ts];
				if (visit[idx] == "") {
					visit[idx] = visit[t] + " " + to_string(idx);
					q.push(idx);
				}
			}
			ts[i] = ts[i] == '0' ? '1' : '0';
		}
	}
	return "-1";
}
int main() {
	cin >> N >> K;
	for (int i = 1; i <= N; i++) {
		cin >> s[i];
		m.insert({ s[i], i });
	}
	cin >> a >> b;
	cout << bfs();
	return 0;
}
