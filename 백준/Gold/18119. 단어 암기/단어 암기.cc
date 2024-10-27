#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    string consonants = "bcdfghjklmnpqrstvwxyz";
    int consonant_bit[26];
    for (int i = 0; i < 26; i++)
        consonant_bit[i] = -1;
    for (int i = 0; i < consonants.size(); i++)
    {
        consonant_bit[consonants[i] - 'a'] = i;
    }

    int N, M;
    cin >> N >> M;

    int size = 1 << 21;
    vector<int> freq(size, 0);

    // Read N words
    for (int i = 0; i < N; i++)
    {
        string word;
        cin >> word;
        int mask = 0;
        for (char c : word)
        {
            if (consonant_bit[c - 'a'] != -1)
            {
                mask |= (1 << consonant_bit[c - 'a']);
            }
        }
        freq[mask]++;
    }

    vector<int> f = freq;

    for (int i = 0; i < 21; i++)
    {
        for (int mask = 0; mask < (1 << 21); mask++)
        {
            if (mask & (1 << i))
            {
                f[mask] += f[mask ^ (1 << i)];
            }
        }
    }

    int cur_state_mask = (1 << 21) - 1;

    for (int i = 0; i < M; i++)
    {
        int o;
        char x;
        cin >> o >> x;
        int bit = consonant_bit[x - 'a'];
        if (o == 1)
        {
            // Forget x
            cur_state_mask &= ~(1 << bit);
        }
        else
        {
            // Remember x
            cur_state_mask |= (1 << bit);
        }
        cout << f[cur_state_mask] << "\n";
    }
}