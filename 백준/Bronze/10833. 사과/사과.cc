#include <iostream>
using namespace std;

#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, students, apples, total = 0;
    cin >> N;

    while (N--) {
        cin >> students >> apples;
        total += apples % students;
    }

    cout << total;
    return 0;
}