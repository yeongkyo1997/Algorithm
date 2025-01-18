#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int solution(string s)
{
    int n = s.size();
    if (n <= 1)
        return n;

    int maxLen = 1;

    for (int center = 0; center < n; center++)
    {
        int left = center;
        int right = center;
        while (left >= 0 && right < n && s[left] == s[right])
        {
            int currentLen = right - left + 1;
            maxLen = max(maxLen, currentLen);
            left--;
            right++;
        }
    }

    for (int center = 0; center < n - 1; center++)
    {
        int left = center;
        int right = center + 1;
        while (left >= 0 && right < n && s[left] == s[right])
        {
            int currentLen = right - left + 1;
            maxLen = max(maxLen, currentLen);
            left--;
            right++;
        }
    }

    return maxLen;
}
