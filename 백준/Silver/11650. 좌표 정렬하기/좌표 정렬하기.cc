#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

class Node
{
public:
    int a, b;

    Node(int a, int b) : a(a), b(b) {}
    Node() : a(0), b(0) {}

    bool operator<(const Node &node) const
    {
        if (this->a == node.a)
        {
            return this->b < node.b;
        }
        return this->a < node.a;
    }

    string toString() const
    {
        ostringstream oss;
        oss << a << " " << b << "\n";
        return oss.str();
    }
};

int main()
{
    ios_base::sync_with_stdio(false);

    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    vector<Node> arr;

    for (int i = 0; i < N; i++)
    {
        int a, b;
        cin >> a >> b;
        arr.emplace_back(a, b);
    }
    sort(arr.begin(), arr.end());

    for (auto &a : arr)
    {
        cout << a.toString();
    }
}