#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

struct UnionFind
{
    unordered_map<long long, long long> parent;

    long long find(long long x)
    {
        if (parent.find(x) == parent.end())
        {

            parent[x] = x + 1;
            return x;
        }

        if (parent[x] == x)
        {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    void union_set(long long x, long long y)
    {
        long long px = find(x);
        long long py = find(y);
        if (px != py)
        {
            parent[px] = py;
        }
    }
};

vector<long long> solution(long long k, vector<long long> room_number)
{
    vector<long long> answer;
    UnionFind uf;

    for (auto req : room_number)
    {
        long long available = uf.find(req);
        answer.push_back(available);

        uf.parent[available] = available + 1;
    }

    return answer;
}