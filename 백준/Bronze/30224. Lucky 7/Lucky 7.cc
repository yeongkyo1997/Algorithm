#include <iostream>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    string s = to_string(N);
    bool hasSeven = s.find('7') != string::npos;
    bool divisibleBy7 = (N % 7 == 0);
    
    cout << (hasSeven ? 2 : 0) + (divisibleBy7 ? 1 : 0) << '\n';
    return 0;
}