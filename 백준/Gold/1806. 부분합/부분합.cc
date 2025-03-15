#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, S;
    cin >> N >> S;
    
    vector<int> nums(N);
    for (int i = 0; i < N; ++i) {
        cin >> nums[i];
    }
    
    int start = 0, end = 0;
    int sum = 0;
    int min_length = INT_MAX;
    
    while (end < N) {
        sum += nums[end++];
        
        while (sum >= S) {
            int current_length = end - start;
            if (current_length < min_length) {
                min_length = current_length;
            }
            sum -= nums[start++];
        }
    }
    
    if (min_length == INT_MAX) {
        cout << 0;
    } else {
        cout << min_length;
    }
    
    return 0;
}