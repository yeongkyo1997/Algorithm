#include <iostream>
#include <string>
using namespace std;
int main() {
    string a, b;
    int t;
    cin >> t;
    while (t--)
    {
        int ans = 0;
        cin >> a >> b;
        for (int i = 0; i < a.size(); i++)
            if (a[i] != b[i])ans++;
        cout << "Hamming distance is " << ans << '.' << '\n';
    }
}
