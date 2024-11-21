#include <bits/stdc++.h>

using namespace std;

string isValid(string s)
{
    int val = 0;
    for (char &c : s)
    {
        if (c == '(')
            val++;
        else
        {
            if (val == 0)
                return "NO";
            else
            {
                val--;
            }
        }
    }
    if (val == 0)
        return "YES";
    else
        return "NO";
}

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    while (N--)
    {
        string s;
        cin >> s;
        cout << isValid(s) << '\n';
    }
}