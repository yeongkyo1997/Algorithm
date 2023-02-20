#include <iostream>
#include <string>
using namespace std;
string k;
int t, ans, a[26];
int main() {
    cin >> t;
    while (t--)
    {
        ans = 0;
        for (int i = 0; i < 26; i++)
            a[i] = 0;
        cin >> k;
        for (int i = 0; i < k.size(); i++)
            a[k[i] - 'A'] = 1;
        for(int i = 0; i<26; i++)
            if (a[i] == 0) { ans += i + 'A'; }
        cout << ans << '\n';
    }
}
