#include <iostream>
#include <vector>

using namespace std;
 
int main() {
 
    std::ios_base::sync_with_stdio(false);
    
    int N;
    
	cin >> N;

	vector<int> vec(N+2, 0);
	vec[0] = -1000000000;
	vec[N + 1] = 1000000000;

	int ans = 0;
	int cnt = 0;
	int before_dec = 0;
	int after_dec = 0;

	for (int i = 1; i <= N; i++) {
		cin >> vec[i];

		if (vec[i] < vec[i - 1]) {
			cnt++;
			before_dec = i - 1;
			after_dec = before_dec+1;
		}
	}

	if (cnt == 0) 
		ans = N;

	else if (cnt > 1)
		ans = 0;

	else {
		if (vec[before_dec - 1] <= vec[after_dec])
			ans++;

		if (vec[before_dec] <= vec[after_dec + 1]) 
			ans++;
	}

	cout << ans << endl;
}