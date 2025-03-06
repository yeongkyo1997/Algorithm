#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
 
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    int N;
    cin >> N;
    vector<long long> D(N - 1);
    for (int i = 0; i < N - 1; i++){
        cin >> D[i];
    }
 
    // Compute prefix sum array P with P[0] = 0.
    vector<long long> P(N, 0);
    P[0] = 0;
    for (int i = 1; i < N; i++){
        P[i] = P[i - 1] + D[i - 1];
    }
 
    // Determine the valid range for A1.
    long long L = 1 - P[0]; // lower bound candidate (i=0)
    long long R = N - P[0]; // upper bound candidate (i=0)
    for (int i = 0; i < N; i++){
        L = max(L, 1 - P[i]);
        R = min(R, (long long)N - P[i]);
    }
 
    // Unique solution exists if and only if L == R.
    if(L > R || L < R){
        cout << -1;
        return 0;
    }
 
    // With A1 = L, recover the A sequence.
    long long A1 = L;  // Remember L == R here.
    vector<long long> A(N);
    for (int i = 0; i < N; i++){
        A[i] = A1 + P[i];
        // (The prior bounds ensure A[i] is within [1, N].)
    }
 
    // Output the resulting sequence.
    for (int i = 0; i < N; i++){
        cout << A[i] << (i == N - 1 ? "\n" : " ");
    }
 
    return 0;
}