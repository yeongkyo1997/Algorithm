#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
#include <algorithm>

using namespace std;

// Helper function to convert date string "YYYY.MM.DD" to total days
long long get_total_days(const string &date)
{
    int year, month, day;
    sscanf(date.c_str(), "%d.%d.%d", &year, &month, &day);
    return static_cast<long long>(year) * 12 * 28 + (month - 1) * 28 + day;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies)
{
    unordered_map<char, int> term_map;
    for (const string &term : terms)
    {
        char type;
        int months;
        sscanf(term.c_str(), "%c %d", &type, &months);
        term_map[type] = months;
    }

    long long today_days = get_total_days(today);

    vector<int> result;

    for (int i = 0; i < privacies.size(); ++i)
    {
        string date_str;
        char type;
        sscanf(privacies[i].c_str(), "%[^ ] %c", &date_str[0], &type); // This line is incorrect, fix below

        stringstream ss(privacies[i]);
        ss >> date_str >> type;

        long long collection_days = get_total_days(date_str);

        int validity_months = term_map[type];

        long long expiry_days = collection_days + static_cast<long long>(validity_months) * 28 - 1;

        if (expiry_days < today_days)
        {
            result.push_back(i + 1);
        }
    }

    return result;
}
