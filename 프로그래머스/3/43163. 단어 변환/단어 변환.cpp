#include <string>
#include <vector>
#include <queue>
#include <unordered_map>
#include <algorithm>
using namespace std;

/*
 * 두 단어 word1, word2가 단 한 글자만 다른지 확인하는 함수
 */
bool isOneCharDiff(const string &word1, const string &word2)
{
    int diffCount = 0;
    for (int i = 0; i < word1.size(); i++)
    {
        if (word1[i] != word2[i])
        {
            diffCount++;
            if (diffCount > 1)
                return false;
        }
    }
    return (diffCount == 1);
}

int solution(string begin, string target, vector<string> words)
{

    if (find(words.begin(), words.end(), target) == words.end())
    {
        return 0;
    }

    unordered_map<string, bool> visited;
    for (auto &w : words)
    {
        visited[w] = false;
    }

    queue<pair<string, int>> q;
    q.push({begin, 0});

    while (!q.empty())
    {
        auto [current, step] = q.front();
        q.pop();

        if (current == target)
        {
            return step;
        }

        for (auto &w : words)
        {

            if (!visited[w] && isOneCharDiff(current, w))
            {
                visited[w] = true;
                q.push({w, step + 1});
            }
        }
    }

    return 0;
}
