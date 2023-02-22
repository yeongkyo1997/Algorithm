#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
#define xx first
#define yy second
#define all(v) (v).begin(), (v).end()

string a[5];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for(auto &i : a) cin >> i;
    for(int i=0; i<a[0].size(); ++i){
        if(a[0][i] == 'o'){
            for(int j=0; j<5; ++j)
                a[j][i] = ".omln"[j];
        }
        else if(a[1][i] == 'o'){
            for(int j=0; j<5; ++j)
                a[j][i] = "owln."[j];
        }
    }

    for(int i=0; i<5; ++i){
        cout << a[i] << '\n';
    }
}