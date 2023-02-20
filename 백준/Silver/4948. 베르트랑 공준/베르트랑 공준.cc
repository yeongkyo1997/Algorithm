#include <iostream>
#include <vector>
using namespace std;
int c[250000],n,ans;
vector <int> a;
int main() {
    for (int i = 2; i < 250000; i++)
    {
        if (c[i] == 0)
            a.push_back(i);
        for (int j = i; j < 250000; j += i)
                c[j] = 1;
    }
    while (1)
    {
        cin >> n;
        ans = 0;
        if (n == 0)break;
        for (int i = 0; i < a.size(); i++)
        {
            if (a[i] > n && a[i]<=2*n)
                ans++;
            else if (a[i] > 2 * n)
                break;
        }
        cout << ans << '\n';
    }
}
