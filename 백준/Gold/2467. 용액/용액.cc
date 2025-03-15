#include <iostream>
#include <vector>
#include <cstdlib>
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
    
    int left = 0, right = n - 1;
    int best_sum = arr[left] + arr[right];
    int best_left = left, best_right = right;
    
    while (left < right) {
        int current_sum = arr[left] + arr[right];
        
        if (abs(current_sum) < abs(best_sum) || 
            (abs(current_sum) == abs(best_sum) && current_sum < best_sum)) {
            best_sum = current_sum;
            best_left = left;
            best_right = right;
        }
        
        if (current_sum > 0) {
            right--;
        } else {
            left++;
        }
    }
    
    cout << arr[best_left] << " " << arr[best_right];
    return 0;
}