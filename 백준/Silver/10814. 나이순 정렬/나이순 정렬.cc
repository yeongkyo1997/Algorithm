#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Node
{
public:
    int age;
    string name;
    Node() : age(0), name("") {}
    Node(int age, string name) : age(age), name(name) {}

    bool operator<(const Node &node) const
    {
        return this->age < node.age;
    }
};

int main()
{
    int N;

    cin >> N;
    vector<Node> arr(N);
    for (int i = 0; i < N; i++)
    {
        int age;
        string name;
        cin >> age >> name;
        arr[i] = Node(age, name);
    }

    stable_sort(arr.begin(), arr.end());

    for (const auto &a : arr)
    {
        cout << a.age << " " << a.name << "\n";
    }
}