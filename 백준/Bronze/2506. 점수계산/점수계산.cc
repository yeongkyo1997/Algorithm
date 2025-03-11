#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    
    int current = 0, total = 0;
    while(n--) {
        int x;
        cin >> x;
        current = x ? current + 1 : 0;
        total += current;
    }
    
    cout << total << '\n';
    return 0;
}