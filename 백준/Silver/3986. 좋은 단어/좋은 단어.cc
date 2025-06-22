#include <iostream>
#include <string>
#include <stack>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    
    int n;
    std::cin >> n;
    
    int good_word_count = 0;
    
    for (int i = 0; i < n; ++i) {
        std::string s;
        std::cin >> s;
        
        std::stack<char> st;
        for (char c : s) {
            if (st.empty() || st.top() != c) {
                st.push(c);
            } else {
                st.pop();
            }
        }
        
        if (st.empty()) {
            good_word_count++;
        }
    }
    
    std::cout << good_word_count << std::endl;
    
    return 0;
}