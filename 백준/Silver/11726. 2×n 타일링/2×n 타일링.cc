#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> cache(1001, 0);
    cache[1] = 1;
    cache[2] = 2;
    for (int i = 3; i <= 1000; i++) {
        cache[i] = (cache[i-1] + cache[i-2]) % 10007;
    }
    cout << cache[n] << endl;
    return 0;
}