#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int main(void) {
    int n;
    cin >> n;
    int mindiv = 1000000;
    int maxdiv = 2;

    while (n--) {
        int t;
        cin >> t;
        mindiv = min(mindiv, t);
        maxdiv = max(maxdiv, t);
    }
    cout << mindiv * maxdiv;
}