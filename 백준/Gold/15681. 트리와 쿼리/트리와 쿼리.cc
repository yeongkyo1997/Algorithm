#include <bits/stdc++.h>
using namespace std;

const int MAX = 100001;
vector<int> adj[MAX];
int subtree_size[MAX];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, R, Q;
    cin >> N >> R >> Q;
    
    for(int i = 0; i < N-1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    stack<tuple<int, int, bool>> st;
    st.push(make_tuple(R, -1, false));
    
    while(!st.empty()) {
        auto tpl = st.top();
        st.pop();
        
        int u = get<0>(tpl);
        int parent = get<1>(tpl);
        bool visited = get<2>(tpl);
        
        if(!visited) {
            st.push(make_tuple(u, parent, true));
            for(int v : adj[u]) {
                if(v != parent) {
                    st.push(make_tuple(v, u, false));
                }
            }
        }
        else {
            subtree_size[u] = 1;
            for(int v : adj[u]) {
                if(v != parent) {
                    subtree_size[u] += subtree_size[v];
                }
            }
        }
    }

    while(Q--) {
        int U;
        cin >> U;
        cout << subtree_size[U] << '\n';
    }
}