#include <iostream>
#include <vector>
#include <stack>
#include <tuple>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, R, Q;
    cin >> N >> R >> Q;
    
    vector<vector<int>> adj(N + 1);
    for (int i = 0; i < N - 1; ++i) {
        int U, V;
        cin >> U >> V;
        adj[U].push_back(V);
        adj[V].push_back(U);
    }
    
    vector<int> subtree_size(N + 1, 0);
    stack<tuple<int, int, bool>> st;
    st.push(make_tuple(R, -1, false));
    
    while (!st.empty()) {
        auto current = st.top();
        st.pop();
        int u = get<0>(current);
        int parent = get<1>(current);
        bool visited = get<2>(current);
        
        if (!visited) {
            st.push(make_tuple(u, parent, true));
            for (int v : adj[u]) {
                if (v != parent) {
                    st.push(make_tuple(v, u, false));
                }
            }
        } else {
            subtree_size[u] = 1;
            for (int v : adj[u]) {
                if (v != parent) {
                    subtree_size[u] += subtree_size[v];
                }
            }
        }
    }
    
    for (int i = 0; i < Q; ++i) {
        int U;
        cin >> U;
        cout << subtree_size[U] << '\n';
    }
    
    return 0;
}