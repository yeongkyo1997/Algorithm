#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int arr[1001];
int temp[1001];
int n;

int main() {
    cin >> n;
    
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
    
    for (int i = 1; i <= n; i++) {
        temp[i] = 1;
        for (int j = 1; j < i; j ++) {
            if (arr[i] < arr[j] && temp[i] < temp[j] + 1) {
                temp[i] = temp[j] + 1;
            }
        }
    }
    int MAX = 0x80000000;

    for (int i = 1; i <=n; i++) {
        MAX = max(temp[i], MAX);
    }
    cout << MAX;
}