#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <cstring>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;

    while (t-- > 0) {
        int a, b;
        cin >> a >> b;

        queue<int> q;
        vector<bool> visited(10000, false);
        vector<string> command(10000);

        q.push(a);
        visited[a] = true;

        for (int i = 0; i < 10000; i++) {
            command[i] = "";
        }

        while (!q.empty() && !visited[b]) {
            int now = q.front(); 
            q.pop();

            int D = (2 * now) % 10000;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!visited[D]) {
                q.push(D);
                visited[D] = true;
                command[D] = command[now] + "D";
            }

            if (!visited[S]) {
                q.push(S);
                visited[S] = true;
                command[S] = command[now] + "S";
            }

            if (!visited[L]) {
                q.push(L);
                visited[L] = true;
                command[L] = command[now] + "L";
            }

            if (!visited[R]) {
                q.push(R);
                visited[R] = true;
                command[R] = command[now] + "R";
            }
        }

        cout << command[b] << '\n';
    }

    return 0;
}