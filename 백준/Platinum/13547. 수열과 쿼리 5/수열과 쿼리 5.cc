#include <bits/stdc++.h>
using namespace std;

struct Query
{
    int L, R, idx;
};

int block_size;
bool cmp(const Query &a, const Query &b)
{
    int block_a = a.L / block_size;
    int block_b = b.L / block_size;
    if (block_a != block_b)
        return block_a < block_b;

    return a.R < b.R;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> A(N + 1);
    for (int i = 1; i <= N; i++)
        cin >> A[i];

    int M;
    cin >> M;
    vector<Query> queries(M);
    for (int i = 0; i < M; i++)
    {
        cin >> queries[i].L >> queries[i].R;
        queries[i].idx = i;
    }

    block_size = static_cast<int>(sqrt(N)) + 1;

    sort(queries.begin(), queries.end(), cmp);

    const int MAX_A = 1000000;
    vector<int> freq(MAX_A + 1, 0);
    vector<int> answer(M);
    int current_distinct = 0;
    int currL = 1, currR = 0;

    for (auto &q : queries)
    {

        while (currL > q.L)
        {
            currL--;
            if (freq[A[currL]] == 0)
                current_distinct++;
            freq[A[currL]]++;
        }

        while (currR < q.R)
        {
            currR++;
            if (freq[A[currR]] == 0)
                current_distinct++;
            freq[A[currR]]++;
        }

        while (currL < q.L)
        {
            freq[A[currL]]--;
            if (freq[A[currL]] == 0)
                current_distinct--;
            currL++;
        }

        while (currR > q.R)
        {
            freq[A[currR]]--;
            if (freq[A[currR]] == 0)
                current_distinct--;
            currR--;
        }

        answer[q.idx] = current_distinct;
    }

    for (int i = 0; i < M; i++)
        cout << answer[i] << "\n";
}