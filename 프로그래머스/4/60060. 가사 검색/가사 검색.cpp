#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <iostream>

using namespace std;

int countByRange(const vector<string> &words, const string &lower, const string &upper)
{

    int left = lower_bound(words.begin(), words.end(), lower) - words.begin();

    int right = upper_bound(words.begin(), words.end(), upper) - words.begin();
    return right - left;
}

vector<int> solution(vector<string> words, vector<string> queries)
{
    vector<int> answer;

    unordered_map<int, vector<string>> len_dict;

    unordered_map<int, vector<string>> reversed_len_dict;

    for (const string &word : words)
    {
        int len = word.size();
        len_dict[len].push_back(word);
        string reversed_word = word;
        reverse(reversed_word.begin(), reversed_word.end());
        reversed_len_dict[len].push_back(reversed_word);
    }

    for (auto &[len, vec] : len_dict)
    {
        sort(vec.begin(), vec.end());
    }
    for (auto &[len, vec] : reversed_len_dict)
    {
        sort(vec.begin(), vec.end());
    }

    for (const string &query : queries)
    {
        int qlen = query.size();

        if (len_dict.find(qlen) == len_dict.end())
        {
            answer.push_back(0);
            continue;
        }

        if (query[0] == '?')
        {

            string reversed_query = query;
            reverse(reversed_query.begin(), reversed_query.end());

            size_t first_non_q = reversed_query.find_first_not_of('?');
            if (first_non_q == string::npos)
            {

                answer.push_back(len_dict[qlen].size());
                continue;
            }

            size_t first_q_after = reversed_query.find_first_of('?', first_non_q);
            string key;
            if (first_q_after == string::npos)
            {

                key = reversed_query.substr(first_non_q);
            }
            else
            {

                key = reversed_query.substr(first_non_q, first_q_after - first_non_q);
            }

            string upper_key = key;
            if (!upper_key.empty())
            {
                upper_key.back()++;
            }

            int cnt = countByRange(reversed_len_dict[qlen], key, upper_key);
            answer.push_back(cnt);
        }
        else
        {

            size_t last_non_q = query.find_last_not_of('?');
            if (last_non_q == string::npos)
            {

                answer.push_back(len_dict[qlen].size());
                continue;
            }

            string key = query.substr(0, last_non_q + 1);

            string upper_key = key;
            if (!upper_key.empty())
            {
                upper_key.back()++;
            }

            int cnt = countByRange(len_dict[qlen], key, upper_key);
            answer.push_back(cnt);
        }
    }

    return answer;
}
