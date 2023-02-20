#include <iostream>
using namespace std;
int v, e, t, ans;
int main() {
    cin >> t;
    while (t--)
    {
        cin >> v >> e;
        cout << 2 - v + e << '\n';
    }
}