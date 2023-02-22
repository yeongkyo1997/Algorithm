#include<iostream>
#include<vector>
#include<queue>

using namespace std;


bool isBipartite(vector<vector<int>>& Adj) {
    int v = Adj.size();
    int Color[v] = { 0 };

    queue<int> Q;

    for (int i = 0; i < v; i++) {
        if (Color[i] != 0) continue;

        Q.push(i);

        while (!Q.empty()) {
            int Qsize = Q.size();
            for (int j = 0; j < Qsize; j++) {
                int current = Q.front();
                Q.pop();

                int adjColor = 0;
                for (int next : Adj[current]) {
                    if (Color[next] == 0) Q.push(next);
                    else {
                        if (adjColor == 0) adjColor = Color[next];
                        else if (adjColor != Color[next]) return false;
                    }
                }

                Color[current] = (adjColor == 0) ? 1 : (3 - adjColor);
            }
        }
    }

    return true;
}


int main(void) {
    int k;
    cin >> k;

    for (; k > 0; k--) {
        int v, e;
        cin >> v >> e;

        vector<vector<int>> Adj(v);

        for (int i = 0; i < e; i++) {
            int start, end;
            scanf("%d %d", &start, &end);
            Adj[start - 1].push_back(end - 1);
            Adj[end - 1].push_back(start - 1);
        }

        if (isBipartite(Adj)) printf("YES\n");
        else printf("NO\n");
    }

    return 0;
}