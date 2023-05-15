#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct dNode {
    int targetNode;
    int value;

    dNode(int targetNode = 0, int value = 0) : targetNode(targetNode), value(value) {}
};

vector<dNode> list[10001];
vector<dNode> reverseList[10001];
int duration[10001];
int indegree[10001];
int n;
queue<int> q;

void topologicalSort(vector<dNode>* list, int* indegree) {
    while (!q.empty()) {
        int node = q.front();
        q.pop();
        for (dNode d : list[node]) {
            if (--indegree[d.targetNode] == 0) q.push(d.targetNode);
            duration[d.targetNode] = max(duration[d.targetNode], duration[node] + d.value);
        }
    }
}

int reverseTopologicalSort(vector<dNode>* reverseList, int goal) {
    int resultCount = 0;
    bool visited[10001] = { false };
    q = queue<int>();
    q.push(goal);
    visited[goal] = true;

    while (!q.empty()) {
        int now = q.front();
        q.pop();
        for (dNode next : reverseList[now]) {
            if (duration[next.targetNode] + next.value == duration[now]) {
                resultCount++;
                if (!visited[next.targetNode]) {
                    visited[next.targetNode] = true;
                    q.push(next.targetNode);
                }
            }
        }
    }
    return resultCount;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int start, end, value;
        cin >> start >> end >> value;
        list[start].push_back(dNode(end, value));
        reverseList[end].push_back(dNode(start, value));
        indegree[end]++;
    }

    int here, goal;
    cin >> here >> goal;
    q.push(here);

    topologicalSort(list, indegree);
    cout << duration[goal] << "\n";
    cout << reverseTopologicalSort(reverseList, goal) << "\n";

    return 0;
}