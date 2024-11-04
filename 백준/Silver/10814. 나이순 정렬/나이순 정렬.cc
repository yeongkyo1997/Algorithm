#include <bits/stdc++.h>

using namespace std;

class Node
{
public:
    int age;
    string name;
    Node(int age, string name) : age(age), name(name) {}

    bool operator<(const Node &node) const
    {
        return this->age < node.age;
    }

    string toString() const
    {
        ostringstream oss;
        oss << this->age << ' ' << this->name;
        return oss.str();
    }
};

int main()
{
    ios::sync_with_stdio(false);

    int N;
    cin >> N;

    vector<Node> arr;

    while (N--)
    {
        int age;
        string name;
        cin >> age >> name;

        arr.emplace_back(age, name);
    }

    stable_sort(arr.begin(), arr.end());

    for (auto &a : arr)
    {
        cout << a.toString() << '\n';
    }
}