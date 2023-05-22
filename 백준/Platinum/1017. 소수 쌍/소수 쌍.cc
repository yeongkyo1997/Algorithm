#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <cstring>

using namespace std;

// 에라토스테네스의 체 배열 (소수 판별용)
vector<bool> IS_NOT_PRIME;

vector<int> left_side;
vector<int> right_side;
bool hasNode[51][51];
bool visited[51];
int matched[51];
int selected;

void eratosthenes()
{
    IS_NOT_PRIME.resize(2000, false);
    
    IS_NOT_PRIME[0] = true;
    IS_NOT_PRIME[1] = true;
    
    int maxPrime = (int)ceil(sqrt(2000));
    
    for (int i = 2; i < maxPrime; i++)
    {
        if (!IS_NOT_PRIME[i])
        {
            for (int j = i + i; j < IS_NOT_PRIME.size(); j += i)
            {
                if (!IS_NOT_PRIME[j])
                {
                    IS_NOT_PRIME[j] = true;
                }
            }
        }
    }
}

bool dfs(int num)
{
    if (!visited[num])
    {
        visited[num] = true;
        for (int i = 0; i < right_side.size(); i++)
        {
            if (hasNode[num][i] && i != selected && !IS_NOT_PRIME[left_side[num] + right_side[i]])
            {
                if (matched[i] == -1 || dfs(matched[i]))
                {
                    matched[i] = num;
                    return true;
                }
            }
        }
    }
    return false;
}

int bipartite()
{
    int size = 1;
    memset(matched, -1, sizeof(matched));
    
    for (int i = 1; i < left_side.size(); i++)
    {
        memset(visited, false, sizeof(visited));
        if (dfs(i))
        {
            size++;
        }
    }
    return size;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    eratosthenes();

    int N;
    cin >> N;

    vector<int> numbers(N);
    for (int i = 0; i < N; i++)
    {
        cin >> numbers[i];
    }

    if (numbers[0] % 2 != 0)
    {
        for (int value : numbers)
        {
            if (value % 2 != 0)
            {
                left_side.push_back(value);
            }
            else
            {
                right_side.push_back(value);
            }
        }
    }
    else
    {
        for (int value : numbers)
        {
            if (value % 2 == 0)
            {
                left_side.push_back(value);
            }
            else
            {
                right_side.push_back(value);
            }
        }
    }
    
    if (left_side.size() == right_side.size())
    {
        for (int i = 1; i < left_side.size(); i++)
        {
            for (int j = 0; j < right_side.size(); j++)
            {
                int ref = left_side[i] + right_side[j];

                if (!IS_NOT_PRIME[ref])
                {
                    hasNode[i][j] = true;
                }
            }
        }

        vector<int> list;

        for (int i = 0; i < N / 2; i++)
        {
            if (!IS_NOT_PRIME[left_side[0] + right_side[i]])
            {
                selected = i;

                int size = bipartite();

                if (size == N / 2)
                {
                    list.push_back(right_side[selected]);
                }
            }
        }

        if (list.size() == 0)
        {
            cout << "-1";
        }
        else
        {
            sort(list.begin(), list.end());

            for (int i = 0; i < list.size(); i++)
            {
                if (i > 0)
                {
                    cout << " ";
                }
                cout << list[i];
            }
        }
    }
    else
    {
        cout << "-1";
    }

    cout << '\n';
    return 0;
}