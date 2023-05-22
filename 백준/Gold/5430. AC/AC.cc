#include <iostream>
#include <string>
#include <deque>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

string ac(deque<int>& dq, string commands) {
    bool reverse = false;

    for (char cmd : commands) {
        if (cmd == 'R') {
            reverse = !reverse;
        } else {
            if (dq.empty()) {
                return "error";
            }

            if (reverse) {
                dq.pop_back();
            } else {
                dq.pop_front();
            }
        }
    }

    stringstream ss;
    ss << '[';

    while (!dq.empty()) {
        ss << (reverse ? dq.back() : dq.front());

        if (reverse) {
            dq.pop_back();
        } else {
            dq.pop_front();
        }

        if (!dq.empty()) {
            ss << ',';
        }
    }

    ss << ']';

    return ss.str();
}

int main() {
    int T;
    cin >> T;

    for (int tc = 1; tc <= T; ++tc) {
        string p;
        int n;

        cin >> p >> n;

        string arrStr;
        cin >> arrStr;

        arrStr = arrStr.substr(1, arrStr.length() - 2);
        stringstream ss(arrStr);
        string token;
        deque<int> dq;

        while (getline(ss, token, ',')) {
            if (!token.empty()) {
                dq.push_back(stoi(token));
            }
        }

        cout << ac(dq, p) << endl;
    }

    return 0;
}