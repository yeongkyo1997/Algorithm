#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
#define xx first
#define yy second
#define all(v) (v).begin(), (v).end()

int n, q;
vector<ll> a, p1, p2;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> q;
    a.resize(n+1);
    p1.resize(n+1);
    p2.resize(n+1);
    for(int i=1; i<=n; ++i){
        cin >> a[i];
        p1[i] = p1[i-1] + a[i];
        p2[i] = p2[i-1] + a[i]*a[i];
    }
    while(q--){
        int l, r;
        cin >> l >> r;
        ll s1 = p1[r] - p1[l-1];
        ll s2 = p2[r] - p2[l-1];
        cout << (s1*s1 - s2)/2 << '\n';
    }
}