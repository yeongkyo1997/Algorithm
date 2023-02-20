#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, arr[51];

vector<pair<int, int>> v;

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        v.push_back(make_pair(a, i));
    }
    sort(v.begin(), v.end());

    for (int i = 0; i < n; i++)
        arr[v[i].second] = i;

    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
}