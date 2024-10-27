#include <bits/stdc++.h>
#include <regex>
using namespace std;

int main()
{
    string s;
    cin >> s;
    regex pattern(R"(^(100+1+|01)+$)");
    if (regex_match(s, pattern))
    {
        cout << "SUBMARINE";
    }
    else
    {
        cout << "NOISE";
    }
}