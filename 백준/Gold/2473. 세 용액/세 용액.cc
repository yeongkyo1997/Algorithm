#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<long long> data(n);

    for (int i = 0; i < n; i++)
        cin >> data[i];

    sort(data.begin(), data.end());

    int ml = 0, mm = 1, mr = n - 1;
    long long min = numeric_limits<long long>::max();

    for (int i = 0; i < n - 2; i++) {
        int left = i;
        int mid = i + 1;
        int right = n - 1;

        while (mid < right) {
            long long sum = data[left] + data[mid] + data[right];
            if (min > abs(sum)) {
                min = abs(sum);
                ml = left; mm = mid; mr = right;
            }
            if (sum > 0) right--;
            else if (sum < 0) mid++;
            else {
                cout << data[ml] << " " << data[mm] << " " << data[mr] << endl;
                return 0;
            }
        }
    }
    cout << data[ml] << " " << data[mm] << " " << data[mr] << endl;
    return 0;
}