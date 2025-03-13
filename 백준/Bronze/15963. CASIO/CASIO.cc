#include <iostream>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string n, m;
    cin >> n >> m;
    cout << (n == m) << '\n';
}