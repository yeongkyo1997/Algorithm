#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int n;
vector<int> prime;

void getPrime(int n) {
    vector<int> temp(n + 1);
    int rootN = sqrt(n);
    for (int i = 2; i <= n; i++) {
        temp[i] = i;
    }
    for (int i = 2; i <= rootN; i++) {
        if (temp[i] != 0) {
            for (int j = i + i; j <= n; j += i) {
                temp[j] = 0;
            }
        }
    }
    for (int i = 2; i <= n; i++) {
        if (temp[i] != 0) {
            prime.push_back(temp[i]);
        }
    }
}

int main() {
    cin >> n;
    getPrime(n);

    int left = 0, right = 0;
    int ans = 0, sum = 2;
    int size = prime.size();

    while (left < size && right < size) {
        if (sum == n) {
            ans++;
            sum -= prime[left];
            left++;
        } else if (sum > n) {
            sum -= prime[left];
            left++;
        } else {
            right++;
            if (right >= size)
                break;
            sum += prime[right];
        }
    }

    cout << ans << endl;

    return 0;
}