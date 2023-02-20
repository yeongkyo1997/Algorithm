#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
#define xx first
#define yy second
#define all(v) (v).begin(), (v).end()

int n, a[111], x, y;

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for(int i=0; i<n; ++i) cin >> a[i];
	cin >> x >> y;
	cout << n * x / 100 << ' ' << count_if(a, a+n, [](int x){return x >= y;});
}