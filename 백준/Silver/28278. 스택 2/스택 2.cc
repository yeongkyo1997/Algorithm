#include <iostream>
#include <stack>
using namespace std;

#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("avx,avx2,fma")

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int N;
    cin >> N;
    stack<int> stk;
    
    while (N--) {
        int cmd;
        cin >> cmd;
        
        if (cmd == 1) {
            int x;
            cin >> x;
            stk.push(x);
        } else if (cmd == 2) {
            if (stk.empty()) cout << "-1\n";
            else {
                cout << stk.top() << '\n';
                stk.pop();
            }
        } else if (cmd == 3) {
            cout << stk.size() << '\n';
        } else if (cmd == 4) {
            cout << (stk.empty() ? 1 : 0) << '\n';
        } else if (cmd == 5) {
            if (stk.empty()) cout << "-1\n";
            else cout << stk.top() << '\n';
        }
    }
}