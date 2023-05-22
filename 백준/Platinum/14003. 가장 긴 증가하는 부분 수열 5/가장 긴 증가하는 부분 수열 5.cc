#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> lis(const vector<int>& arr) {
    vector<int> lis_arr = {arr[0]};
    vector<int> index_arr(arr.size());

    int index = 1;

    for (size_t i = 1; i < arr.size(); i++) {
        int num = arr[i];
        if (lis_arr.back() < num) {
            lis_arr.push_back(num);
            index_arr[i] = index;
            index++;
        } else {
            auto it = lower_bound(lis_arr.begin(), lis_arr.end(), num);
            *it = num;
            index_arr[i] = distance(lis_arr.begin(), it);
        }
    }

    return index_arr;
}

vector<int> get_lis(const vector<int>& arr, const vector<int>& index_arr) {
    vector<int> ans;
    int idx = index_arr.size() - 1;

    auto max_val = *max_element(index_arr.begin(), index_arr.end());
    auto num = max_val;

    while (idx >= 0) {
        if (index_arr[idx] == num) {
            ans.push_back(arr[idx]);
            num--;
        }
        idx--;
    }

    reverse(ans.begin(), ans.end());
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    vector<int> nums(N);

    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }

    vector<int> index_arr = lis(nums);
    vector<int> ans = get_lis(nums, index_arr);

    cout << ans.size() << '\n';
    for (int value : ans) {
        cout << value << ' ';
    }

    return 0;
}