#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int d, p, q;
    cin >> d >> p >> q;

    int a = max(p, q);
    int b = min(p, q);

    if (b == 1 || (b == 2 && d % 2 == 0) || d % a == 0 || d % b == 0) {
        cout << d << endl;
        return 0;
    }

    int limit = d / a + 1;
    int answer = a - 1;
    unordered_set<int> hs;

    for (int i = 0; i <= limit; i++) {
        int remain = d - a * i;

        if (remain > 0 && remain % b == 0) {
            cout << d << endl;
            return 0;
        }

        if (remain < 0)
            remain += b;

        int tmp = b - remain % b;

        if (hs.count(tmp) > 0)
            break;

        hs.insert(tmp);

        if (answer > tmp)
            answer = tmp;
    }
    cout << d + answer << endl;

    return 0;
}