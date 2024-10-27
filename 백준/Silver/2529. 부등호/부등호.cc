#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

bool check(const vector<char> &signs, const vector<int> &perm)
{
    for (int i = 0; i < signs.size(); i++)
    {
        if (signs[i] == '<' && perm[i] > perm[i + 1])
            return false;
        if (signs[i] == '>' && perm[i] < perm[i + 1])
            return false;
    }
    return true;
}

pair<string, string> findMinMax(int k, const vector<char> &signs)
{
    vector<int> digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    string minNum = "9876543210";
    string maxNum = "0123456789";

    do
    {
        vector<int> perm(digits.begin(), digits.begin() + k + 1);
        if (check(signs, perm))
        {
            string numStr;
            for (int n : perm)
                numStr += to_string(n);
            if (numStr < minNum)
                minNum = numStr;
            if (numStr > maxNum)
                maxNum = numStr;
        }
    } while (next_permutation(digits.begin(), digits.end()));

    return {maxNum, minNum};
}

int main()
{
    int k;
    cin >> k;
    vector<char> signs(k);
    for (int i = 0; i < k; i++)
        cin >> signs[i];

    pair<string, string> result = findMinMax(k, signs);
    cout << result.first << endl;  // 최대값
    cout << result.second << endl; // 최소값

    return 0;
}