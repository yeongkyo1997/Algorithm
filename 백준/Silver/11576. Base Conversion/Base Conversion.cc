#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    int A, B, m;
    cin >> A >> B;
    cin >> m;

    int decimal = 0;
    vector<int> number(m);

    for (int i = 0; i < m; i++) {
        cin >> number[i];
    }

    for (int i = 0; i < m; i++) {
        decimal += number[i] * pow(A, m - 1 - i);
    }

    vector<int> result;
    while (decimal > 0) {
        result.push_back(decimal % B);
        decimal /= B;
    }

    for (int i = result.size() - 1; i >= 0; i--) {
        cout << result[i] << ' ';
    }

    return 0;
}