#include <iostream>
#include <vector>
#include <string>
#include <climits>
#include <cstdlib>
#include <algorithm>
#include <unordered_map>
using namespace std;

int manhattan(pair<int, int> a, pair<int, int> b)
{
    return abs(a.first - b.first) + abs(a.second - b.second);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<string> grid(N);
    for (int i = 0; i < N; i++)
    {
        cin >> grid[i];
    }

    pair<int, int> home, recruit;

    unordered_map<char, vector<pair<int, int>>> toppings;
    toppings['J'] = vector<pair<int, int>>();
    toppings['C'] = vector<pair<int, int>>();
    toppings['B'] = vector<pair<int, int>>();
    toppings['W'] = vector<pair<int, int>>();

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < grid[i].size(); j++)
        {
            char c = grid[i][j];
            if (c == 'H')
            {
                home = {i, j};
            }
            else if (c == '#')
            {
                recruit = {i, j};
            }
            else if (c == 'J' || c == 'C' || c == 'B' || c == 'W')
            {
                toppings[c].push_back({i, j});
            }
        }
    }

    vector<char> order = {'J', 'C', 'B', 'W'};
    unordered_map<char, int> bestDist;

    for (char type : order)
    {
        auto &vec = toppings[type];

        vector<int> perm = {0, 1, 2};
        int minRoute = INT_MAX;
        do
        {
            int dist = 0;

            dist += manhattan(home, vec[perm[0]]);

            dist += manhattan(vec[perm[0]], vec[perm[1]]);
            dist += manhattan(vec[perm[1]], vec[perm[2]]);

            dist += manhattan(vec[perm[2]], recruit);
            minRoute = min(minRoute, dist);
        } while (next_permutation(perm.begin(), perm.end()));

        bestDist[type] = minRoute;
    }

    char ansType = ' ';
    int ansDist = INT_MAX;
    for (char type : order)
    {
        if (bestDist[type] < ansDist)
        {
            ansDist = bestDist[type];
            ansType = type;
        }
    }

    unordered_map<char, string> division;
    division['J'] = "Assassin";
    division['C'] = "Healer";
    division['B'] = "Mage";
    division['W'] = "Tanker";

    cout << division[ansType] << "\n";

    return 0;
}