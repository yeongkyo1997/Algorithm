#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int main() {
    int T;
    cin >> T;

    while (T-- > 0) {
        unordered_map<string, int> hm; 
        int N;
        cin >> N;

        while (N-- > 0) {
            string cloth_name, kind;
            cin >> cloth_name >> kind;

            if (hm.count(kind) > 0) {
                hm[kind]++;
            } else {
                hm[kind] = 1;
            }
        }

        int result = 1;

        for (const auto& val : hm) {
            result *= (val.second + 1);
        }

        cout << result - 1 << endl; 
    }

    return 0;
}