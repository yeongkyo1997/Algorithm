#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());
    
    long long min_sum = LLONG_MAX;
    int res[3] = {0, 0, 0};
    
    for (int i = 0; i < n-2; ++i) {
        int left = i+1, right = n-1;
        
        while (left < right) {
            long long current = (long long)arr[i] + arr[left] + arr[right];
            
            if (abs(current) < abs(min_sum)) {
                min_sum = current;
                res[0] = arr[i];
                res[1] = arr[left];
                res[2] = arr[right];
            }
            
            if (current < 0) ++left;
            else if (current > 0) --right;
            else {
                cout << res[0] << ' ' << res[1] << ' ' << res[2];
                return 0;
            }
        }
    }
    
    cout << res[0] << ' ' << res[1] << ' ' << res[2];
    return 0;
}