#include <bits/stdc++.h>
using namespace std;

int arr[101];

int main() {
    int n, l, k, a, b, sum = 0;
    cin >> n >> l >> k;
    for (int i = 0; i < n; i++) {
        cin >> a >> b;
        if (b <= l)
            arr[i] = 140;
        else if (a <= l)
            arr[i] = 100;
    }
    sort(arr, arr + n);
    for (int i = 0; i < k; i++) {
        sum += arr[i];
    }
    cout << sum << endl;
}