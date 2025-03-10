#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int N;
    cin >> N;
    for(int i=1; i<=N; ++i) {
        cout << "Hello World, Judge " << i << "!\n";
    }
    return 0;
}