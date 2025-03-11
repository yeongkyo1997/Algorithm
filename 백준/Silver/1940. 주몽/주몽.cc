#include <iostream>
#include <vector>
#include <algorithm>
#pragma GCC optimize("O3")
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, M;
    cin >> N >> M;
    vector<int> materials(N);
    for(int i = 0; i < N; ++i) {
        cin >> materials[i];
    }
    sort(materials.begin(), materials.end());
    
    int count = 0, left = 0, right = N - 1;
    while(left < right) {
        int sum = materials[left] + materials[right];
        if(sum < M) ++left;
        else if(sum > M) --right;
        else {
            if(materials[left] == materials[right]) {
                int n = right - left + 1;
                count += n * (n - 1) / 2;
                break;
            }
            int curr_left = materials[left], cnt_left = 0;
            while(materials[left] == curr_left) ++cnt_left, ++left;
            int curr_right = materials[right], cnt_right = 0;
            while(materials[right] == curr_right) ++cnt_right, --right;
            count += cnt_left * cnt_right;
        }
    }
    cout << count;
    return 0;
}