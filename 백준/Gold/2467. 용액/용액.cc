#include <bits/stdc++.h>

using namespace std;

int N;
vector<int> nums;

int abs(int num) {
    return num >= 0 ? num : -num;
}

pair<int, int> twoPointerSearch(int target) {
    int lp = 0, rp = N - 1;
    int lr = 0, rr = N - 1, tmp = abs(nums[lr] + nums[rr]);

    while (lp < rp) {
        int val = nums[lp] + nums[rp];
        int abs_val = abs(val);
        if (tmp > abs_val) {
            tmp = abs_val;
            lr = lp;
            rr = rp;
        }

        if (val < target) {
            lp++;
        } else if (val > target) {
            rp--;
        } else {
            return make_pair(nums[lp], nums[rp]);
        }
    }

    return make_pair(nums[lr], nums[rr]);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    nums.resize(N);
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }
    sort(nums.begin(), nums.end());
    pair<int, int> result = twoPointerSearch(0);
    cout << result.first << " " << result.second;

    return 0;
}