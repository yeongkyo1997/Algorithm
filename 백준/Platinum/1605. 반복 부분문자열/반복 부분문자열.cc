#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>

using namespace std;

const int base1 = 911, mod1 = 1e9 + 7;
const int base2 = 3571, mod2 = 1e9 + 9;

struct HashPair {
    long long h1, h2;
    HashPair(long long a, long long b) : h1(a), h2(b) {}
    bool operator==(const HashPair& other) const {
        return h1 == other.h1 && h2 == other.h2;
    }
};

namespace std {
    template<> struct hash<HashPair> {
        size_t operator()(const HashPair& p) const {
            return (p.h1 * 1234567891 + p.h2) % (1LL << 32);
        }
    };
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int L;
    string s;
    cin >> L >> s;
    
    if (L < 2) {
        cout << 0 << '\n';
        return 0;
    }
    
    vector<long long> prefix1(L + 1, 0), prefix2(L + 1, 0);
    vector<long long> base_pows1(L + 1, 1), base_pows2(L + 1, 1);
    
    for (int i = 1; i <= L; ++i) {
        base_pows1[i] = (base_pows1[i-1] * base1) % mod1;
        base_pows2[i] = (base_pows2[i-1] * base2) % mod2;
    }
    
    for (int i = 0; i < L; ++i) {
        prefix1[i+1] = (prefix1[i] * base1 + (s[i] - 'a' + 1)) % mod1;
        prefix2[i+1] = (prefix2[i] * base2 + (s[i] - 'a' + 1)) % mod2;
    }
    
    int answer = 0;
    int low = 1, high = L-1;
    
    while (low <= high) {
        int mid = (low + high) / 2;
        bool found = false;
        unordered_set<HashPair> seen;
        
        for (int i = 0; i <= L - mid; ++i) {
            long long h1 = (prefix1[i + mid] - (prefix1[i] * base_pows1[mid]) % mod1 + mod1) % mod1;
            long long h2 = (prefix2[i + mid] - (prefix2[i] * base_pows2[mid]) % mod2 + mod2) % mod2;
            HashPair current(h1, h2);
            
            if (seen.count(current)) {
                found = true;
                break;
            }
            seen.insert(current);
        }
        
        if (found) {
            answer = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    
    cout << answer << '\n';
    
    return 0;
}