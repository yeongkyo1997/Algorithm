#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    long long n;
    cin >> n;
    cout << n * (n - 1) / 2 << '\n' << 2;
    return 0;
}