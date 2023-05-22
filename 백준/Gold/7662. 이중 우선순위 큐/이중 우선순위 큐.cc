#include <iostream>
#include <map>
#include <sstream>
#include <string>
using namespace std;

int main() {
    int T;
    cin >> T;
    cin.ignore();

    string line;
    for (int tc = 0; tc < T; ++tc) {
        map<int, int> m;
        int k;
        getline(cin, line);
        k = stoi(line);

        for (int i = 0; i < k; ++i) {
            getline(cin, line);
            istringstream iss(line);
            char c;
            int n;
            iss >> c >> n;

            if (c == 'I') {
                m[n]++;
            } else if (m.size() == 0) {
                continue;
            } else {
                auto it = (n == 1) ? --m.end() : m.begin();
                if (it->second == 1) {
                    m.erase(it);
                } else {
                    it->second--;
                }
            }
        }

        if (m.size() == 0) {
            cout << "EMPTY" << endl;
        } else {
            cout << (--m.end())->first << " " << m.begin()->first << endl;
        }
    }

    return 0;
}