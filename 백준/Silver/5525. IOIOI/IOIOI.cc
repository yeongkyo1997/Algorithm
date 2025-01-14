#include <bits/stdc++.h>
using namespace std;

// Function to build the prefix function for KMP
vector<int> buildPrefix(const string &pattern) {
    int m = pattern.size();
    vector<int> prefix(m, 0);
    for(int i =1; i < m; i++) {
        int j = prefix[i-1];
        while(j >0 && pattern[i] != pattern[j]) {
            j = prefix[j-1];
        }
        if(pattern[i] == pattern[j]) {
            j++;
        }
        prefix[i] = j;
    }
    return prefix;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    // Read inputs
    int N;
    cin >> N;
    int M;
    cin >> M;
    string S;
    cin >> S;
    
    // Generate pattern PN: 'I' followed by 'OI' N times
    string PN = "I";
    for(int i=0; i < N; i++) {
        PN += "OI";
    }
    
    // Edge case: if PN length > M, no matches
    if(PN.size() > S.size()) {
        cout << "0\n";
        return 0;
    }
    
    // Build prefix function for PN
    vector<int> prefix = buildPrefix(PN);
    
    // KMP search
    int count =0;
    int j =0; // index for PN
    for(int i=0; i < S.size(); i++) {
        while(j >0 && S[i] != PN[j]) {
            j = prefix[j-1];
        }
        if(S[i] == PN[j]) {
            j++;
        }
        if(j == PN.size()) {
            count++;
            j = prefix[j-1];
        }
    }
    
    cout << count << "\n";
    
    return 0;
}