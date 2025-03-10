#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    
    vector<int> boxes(n);
    for(int i = 0; i < n; ++i)
        cin >> boxes[i];
    
    vector<int> dp;
    for(int box : boxes) {
        auto it = lower_bound(dp.begin(), dp.end(), box);
        if(it == dp.end())
            dp.push_back(box);
        else
            *it = box;
    }
    
    cout << dp.size();
    return 0;
}