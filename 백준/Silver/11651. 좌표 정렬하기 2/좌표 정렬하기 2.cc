#include <bits/stdc++.h>

using namespace std;

class Point
{
public:
    int x, y;

    Point(int x, int y) : x(x), y(y) {}

    bool operator<(const Point &point) const
    {
        if (this->y == point.y)
            return this->x < point.x;
        return this->y < point.y;
    }

    string toString() const
    {
        ostringstream oss;
        oss << this->x << ' ' << this->y;
        return oss.str();
    }
};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    vector<Point> arr;
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin >> x >> y;
        arr.emplace_back(x, y);
    }

    sort(arr.begin(), arr.end());
    for (auto a : arr)
    {
        cout << a.toString() << '\n';
    }
}