#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main()
{
    int N;
    unordered_map<string, int> card;
    cin >> N;
    while (N--)
    {
        string fruit;
        int num;
        cin >> fruit >> num;
        if (card.find(fruit) == card.end())
        {
            card[fruit] = 0;
        }
        card[fruit] += num;
    }
    for (auto &c : card)
    {
        if (c.second == 5)
        {
            cout << "YES" << "\n";
            return 0;
        }
    }
    cout << "NO" << "\n";
}