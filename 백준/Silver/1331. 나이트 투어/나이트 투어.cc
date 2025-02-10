#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <cmath>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<string> moves(36);
    for (int i = 0; i < 36; i++)
    {
        cin >> moves[i];
    }

    set<string> visited;
    for (int i = 0; i < 36; i++)
    {
        if (visited.find(moves[i]) != visited.end())
        {
            cout << "Invalid" << "\n";
            return 0;
        }
        visited.insert(moves[i]);
    }

    vector<pair<int, int>> coords(36);
    for (int i = 0; i < 36; i++)
    {
        char colChar = moves[i][0];
        char rowChar = moves[i][1];
        int col = colChar - 'A';
        int row = rowChar - '1';
        coords[i] = {row, col};
    }

    auto isKnightMove = [](pair<int, int> from, pair<int, int> to) -> bool
    {
        int dr = abs(from.first - to.first);
        int dc = abs(from.second - to.second);
        return (dr == 1 && dc == 2) || (dr == 2 && dc == 1);
    };

    for (int i = 0; i < 35; i++)
    {
        if (!isKnightMove(coords[i], coords[i + 1]))
        {
            cout << "Invalid" << "\n";
            return 0;
        }
    }

    if (!isKnightMove(coords[35], coords[0]))
    {
        cout << "Invalid" << "\n";
        return 0;
    }

    cout << "Valid" << "\n";
    return 0;
}