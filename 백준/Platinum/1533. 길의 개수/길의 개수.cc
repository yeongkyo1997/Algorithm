#include <iostream>
#include <vector>
#include <string>

using namespace std;

const int MOD = 1000003;
int N, S, E, T;
vector<vector<long>> array;

vector<vector<long>> squareProcession(const vector<vector<long>>& a, const vector<vector<long>>& b);
vector<vector<long>> powProcession(const vector<vector<long>>& a, int n);

int main() {
    cin >> N >> S >> E >> T;
    array.resize(N * 5 + 1, vector<long>(N * 5 + 1));

    string s;
    for (int i = 1; i <= N; i++) {
        cin >> s;
        for (int j = 0; j < s.size(); j++) {
            if (s[j] != '0') {
                array[i * 5][(j + 1) * 5 - (s[j] - '0' - 1)] = 1;
            }
        }

        for (int j = 1; j < 5; j++) {
            array[(i - 1) * 5 + j][(i - 1) * 5 + j + 1] = 1;
        }
    }

    cout << powProcession(array, T)[5 * S][5 * E] << endl;

    return 0;
}

vector<vector<long>> squareProcession(const vector<vector<long>>& a, const vector<vector<long>>& b) {
    vector<vector<long>> result(N * 5 + 1, vector<long>(N * 5 + 1));

    for (int i = 1; i <= 5 * N; i++) {
        for (int j = 1; j <= 5 * N; j++) {
            for (int k = 1; k <= 5 * N; k++) {
                result[i][j] += (a[i][k] * b[k][j]);
                result[i][j] %= MOD;
            }
        }
    }

    return result;
}

vector<vector<long>> powProcession(const vector<vector<long>>& a, int n) {
    vector<vector<long>> result(N * 5 + 1, vector<long>(N * 5 + 1));
    for (int i = 1; i <= N * 5; i++) {
        result[i][i] = 1;
    }

    vector<vector<long>> temp = a;
    while (n != 0) {
        if (n % 2 == 1) {
            result = squareProcession(result, temp);
        }

        n /= 2;
        temp = squareProcession(temp, temp);
    }

    return result;
}