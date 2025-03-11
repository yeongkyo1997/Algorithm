#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("avx,avx2,fma")

#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, M;
    cin >> N >> M;
    
    vector<int> A(N), B(M);
    for(int i=0; i<N; ++i) cin >> A[i];
    for(int i=0; i<M; ++i) cin >> B[i];
    
    vector<int> merged;
    merged.reserve(N+M);
    
    int i=0, j=0;
    while(i<N && j<M) {
        if(A[i] < B[j]) merged.push_back(A[i++]);
        else merged.push_back(B[j++]);
    }
    while(i<N) merged.push_back(A[i++]);
    while(j<M) merged.push_back(B[j++]);
    
    for(int k=0; k<merged.size(); ++k) {
        cout << merged[k] << ' ';
    }
    
    return 0;
}