#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
#include <cstdlib>

using namespace std;

int min_distance(int current_x, int current_y, int target_x, int target_y)
{
    return abs(current_x - target_x) + abs(current_y - target_y);
}

string solution(int n, int m, int x, int y, int r, int c, int k)
{
    int md = min_distance(x, y, r, c);

    if (k < md)
    {
        return "impossible";
    }

    int current_x = x;
    int current_y = y;
    string path = "";

    vector<pair<char, pair<int, int>>> directions = {
        {'d', {1, 0}},
        {'l', {0, -1}},
        {'r', {0, 1}},
        {'u', {-1, 0}}};

    for (int step = 1; step <= k; ++step)
    {
        bool moved = false;
        for (auto &dir : directions)
        {
            char move_char = dir.first;
            int dx = dir.second.first;
            int dy = dir.second.second;
            int new_x = current_x + dx;
            int new_y = current_y + dy;

            if (new_x >= 1 && new_x <= n && new_y >= 1 && new_y <= m)
            {
                int steps_left = k - step;
                int new_md = min_distance(new_x, new_y, r, c);
                if (new_md <= steps_left)
                {
                    path += move_char;
                    current_x = new_x;
                    current_y = new_y;
                    moved = true;
                    break;
                }
            }
        }
        if (!moved)
        {
            return "impossible";
        }
    }

    if (current_x == r && current_y == c)
    {
        return path;
    }
    else
    {
        return "impossible";
    }
}