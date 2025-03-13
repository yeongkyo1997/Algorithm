#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int T;
    cin >> T;
    
    while (T--) {
        string input;
        cin >> input;
        
        vector<char> left, right;
        
        for (char c : input) {
            if (c == '<') {
                if (!left.empty()) {
                    right.push_back(left.back());
                    left.pop_back();
                }
            } else if (c == '>') {
                if (!right.empty()) {
                    left.push_back(right.back());
                    right.pop_back();
                }
            } else if (c == '-') {
                if (!left.empty()) {
                    left.pop_back();
                }
            } else {
                left.push_back(c);
            }
        }
        
        reverse(right.begin(), right.end());
        
        string password;
        password.reserve(left.size() + right.size());
        password.append(left.begin(), left.end());
        password.append(right.begin(), right.end());
        
        cout << password << '\n';
    }
    
    return 0;
}