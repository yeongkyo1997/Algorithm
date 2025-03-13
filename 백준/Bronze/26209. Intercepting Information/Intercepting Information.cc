#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    bool valid = true;
    for (int i = 0; i < 8; ++i) {
        int num;
        cin >> num;
        if (num == 9) valid = false;
    }
    
    cout << (valid ? "S" : "F") << '\n';
    return 0;
}