#include <iostream>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long N;
    cin >> N;

    const string S = "WelcomeToSMUPC"; // 길이 14
    cout << S[(N - 1) % S.size()] << '\n';
    return 0;
}