#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int commonPrefix(const string &a, const string &b)
{
    int len = min(a.size(), b.size());
    int count = 0;
    while (count < len && a[count] == b[count])
    {
        count++;
    }
    return count;
}

int solution(vector<string> words)
{
    int N = words.size();
    if (N == 0)
        return 0;

    sort(words.begin(), words.end());

    long long total = 0;

    for (int i = 0; i < N; i++)
    {
        int cp_prev = 0;
        int cp_next = 0;

        if (i > 0)
        {
            cp_prev = commonPrefix(words[i], words[i - 1]);
        }

        if (i < N - 1)
        {
            cp_next = commonPrefix(words[i], words[i + 1]);
        }

        int max_cp = max(cp_prev, cp_next);

        int needed = max_cp + 1;

        if (needed > words[i].size())
        {
            needed = words[i].size();
        }

        total += needed;
    }

    return (int)total;
}