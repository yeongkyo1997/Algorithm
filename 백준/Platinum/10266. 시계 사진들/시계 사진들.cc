#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

vector<int> computeGaps(const vector<int>& angles) {
    int n = angles.size();
    vector<int> gaps(n);
    for (int i = 0; i < n; ++i) {
        if (i < n - 1) {
            gaps[i] = angles[i + 1] - angles[i];
        } else {
            gaps[i] = 360000 - angles[i] + angles[0];
        }
    }
    return gaps;
}

bool checkSameFrequency(const vector<int>& a, const vector<int>& b) {
    unordered_map<int, int> freq;
    for (int x : a) freq[x]++;
    for (int x : b) {
        if (--freq[x] < 0) return false;
    }
    return true;
}

vector<int> computeFailure(const vector<int>& pattern) {
    int m = pattern.size();
    vector<int> failure(m, 0);
    int j = 0;
    for (int i = 1; i < m; ++i) {
        while (j > 0 && pattern[i] != pattern[j]) {
            j = failure[j - 1];
        }
        if (pattern[i] == pattern[j]) {
            failure[i] = ++j;
        }
    }
    return failure;
}

bool kmpSearch(const vector<int>& text, const vector<int>& pattern) {
    int n = text.size();
    int m = pattern.size();
    if (m == 0) return true;

    vector<int> failure = computeFailure(pattern);
    int j = 0;
    for (int i = 0; i < n; ++i) {
        while (j > 0 && text[i] != pattern[j]) {
            j = failure[j - 1];
        }
        if (text[i] == pattern[j]) {
            if (++j == m) return true;
        }
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> a(n), b(n);
    for (int& x : a) cin >> x;
    for (int& x : b) cin >> x;

    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    vector<int> gapsA = computeGaps(a);
    vector<int> gapsB = computeGaps(b);

    if (!checkSameFrequency(gapsA, gapsB)) {
        cout << "impossible\n";
        return 0;
    }

    vector<int> text = gapsA;
    text.insert(text.end(), gapsA.begin(), gapsA.end());

    if (kmpSearch(text, gapsB)) {
        cout << "possible\n";
    } else {
        cout << "impossible\n";
    }

    return 0;
}