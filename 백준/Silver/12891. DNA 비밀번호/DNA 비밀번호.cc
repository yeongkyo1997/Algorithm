#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int MOD = 1000000007;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, P;
    cin >> N >> P;
    string S;
    cin >> S;
    // Read min counts
    int minA, minC, minG, minT;
    cin >> minA >> minC >> minG >> minT;

    if(P > N){
        cout << "0\n";
        return 0;
    }

    // Map characters to indices: 'A'->0, 'C'->1, 'G'->2, 'T'->3
    auto char_to_idx = [&](char c) -> int {
        switch(c){
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return -1; // Should not happen
        }
    };

    // Initialize counts
    int counts[4] = {0, 0, 0, 0};

    for(int i=0;i<P;i++){
        int idx = char_to_idx(S[i]);
        if(idx != -1){
            counts[idx]++;
        }
    }

    // Function to check if current counts satisfy the constraints
    auto is_valid = [&](int cnt[]) -> bool {
        return cnt[0] >= minA && cnt[1] >= minC && cnt[2] >= minG && cnt[3] >= minT;
    };

    ll answer = 0;
    if(is_valid(counts)){
        answer++;
    }

    // Slide the window
    for(int i=P; i<N; i++){
        // Remove S[i-P]
        int out_idx = char_to_idx(S[i-P]);
        if(out_idx != -1){
            counts[out_idx]--;
        }
        // Add S[i]
        int in_idx = char_to_idx(S[i]);
        if(in_idx != -1){
            counts[in_idx]++;
        }
        // Check
        if(is_valid(counts)){
            answer++;
        }
    }

    cout << (answer % MOD) << "\n";

    return 0;
}